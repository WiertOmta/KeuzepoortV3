
import java.util.Timer;
import java.util.TimerTask;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.PinState;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SystemController extends TimerTask implements GpioPinListenerDigital {

	private TrueSensor trueSensor;
	private FalseSensor falseSensor;
	private QuestionHandler questionHandler;
	private int trueCount;
	private int falseCount;
	private String currentQuestion;
	private Window window;
	private DateFormat dateFormat;
	private File file;
	private BufferedWriter bw;
	private FileWriter fw;


	public static void main(String[] args) {
		SystemController systemController = new SystemController();
	}

	public void run() {
		if(currentQuestion.equals("")) {
			currentQuestion = questionHandler.getNextQuestion();
			window.setQuestionLabel("<html><body style='width: 850px'>" + currentQuestion + "</body></html>");
		} else 
			//write currentquestion, trueCount, falseCount to answers.csv;
			try {
				Date date = new Date();
				bw.write(dateFormat.format(date) + "," + currentQuestion + "," + trueCount + "," + falseCount);
				bw.newLine();
				bw.flush();
			} catch(IOException e) {
				
			}
			
			/*Reset the counters and the currentQuestion string.*/
			trueCount = 0;
			falseCount = 0;
			currentQuestion = questionHandler.getNextQuestion();
			window.setQuestionLabel("<html><body style='width: 850px'>" + currentQuestion + "</body></html>");
			window.setRandomBackgroundColor();
		}

	public SystemController() {
		try {
			File file = new File("answers.csv");
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
		} catch(IOException e) {
			
		}
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		window = new Window();
		trueCount = 0;
		falseCount = 0;
		currentQuestion = "";
		questionHandler = new QuestionHandler();
		trueSensor = new TrueSensor();
		trueSensor.setListener(this);
		falseSensor = new FalseSensor();
		falseSensor.setListener(this);

		trueSensor.start();
		falseSensor.start();

		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(this, 0, 10000);
	}
	
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
  		if((event.getPin().getPin().getAddress() == 0) && (event.getState() == PinState.HIGH)) {
  			trueCount++;
  		} else if((event.getPin().getPin().getAddress() == 2) && (event.getState() == PinState.HIGH)) {
  			falseCount++;
  		}
   	}
}
