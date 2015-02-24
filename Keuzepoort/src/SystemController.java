
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


String content = "This is the content to write into file";
 
			
			bw.write(content);
			bw.close();
 
			System.out.println("Done");


public class SystemController extends TimerTask implements GpioPinListenerDigital {

	private TrueSensor trueSensor;
	private FalseSensor falseSensor;
	private QuestionHandler questionHandler;
	private int trueCount;
	private int falseCount;
	private String currentQuestion;
	private Window window;
	File file;
	BufferedWriter bw;
	FileWriter fw;

	public static void main(String[] args) {
		SystemController systemController = new SystemController();
	}

	public void run() {
		if(currentQuestion.equals("")) {
			currentQuestion = questionHandler.getNextQuestion();
			window.setQuestionLabel(currentquestion);
		} else {
			//write currentquestion, trueCount, falseCount to answers.csv;
			try {
				bw.write(currentquestion + ",ja: " + trueCount + ",nee: " + falseCount + "\n");
			} catch(IOException e) {
				
			}
			
			/*Reset the counters and the currentQuestion string.*/
			trueCount = 0;
			falseCount = 0;
			currentQuestion = questionHandler.getNextQuestion();
			window.setQuestionLabel(currentquestion);
			window.setTrueLabel("Ja gestemd: " + trueCount);
			window.setFalseLabel("Nee gestemd: " + falseCount);
			System.out.println(currentQuestion);
		}
	}

	public SystemController() {
		try {
			File file = new File("/users/mkyong/filename.txt");

			if (!file.exists()) {
				file.createNewFile();
			}
	 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
		} catch(IOException e) {

		}

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
  			window.setTrueLabel("Ja gestemd: " + trueCount);
  			System.out.println(trueCount);
  		} else if((event.getPin().getPin().getAddress() == 2) && (event.getState() == PinState.HIGH)) {
  			falseCount++;
  			window.setFalseLabel("Nee gestemd: " + falseCount);
  			System.out.println(falseCount);
  		}
   	}
}
