
import java.util.Timer;
import java.util.TimerTask;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.PinState;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SystemController extends TimerTask implements GpioPinListenerDigital {

	private TrueSensor trueSensor;
	private FalseSensor falseSensor;
	private QuestionHandler questionHandler;
	private int trueCount;
	private int falseCount;
	private String currentQuestion;
	private PrintWriter printWriter;

	public static void main(String[] args) {
		SystemController systemController = new SystemController();
	}

	public void run() {
		if(currentQuestion.equals("")) {
			currentQuestion = questionHandler.getNextQuestion();;
		} else {
			printWriter.println(currentQuestion + ", " + trueCount + ", " + falseCount);
			trueCount = 0;
			falseCount = 0;
			currentQuestion = questionHandler.getNextQuestion();
			System.out.println(currentQuestion);
		}
	}

	public SystemController() {
		try {
			printWriter = new PrintWriter("answers.csv","UTF-8");
		} catch(FileNotFoundException e) {

		} catch(UnsupportedEncodingException e) {

		}
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
  			System.out.println(trueCount);
  		} else if((event.getPin().getPin().getAddress() == 2) && (event.getState() == PinState.HIGH)) {
  			falseCount++;
  			System.out.println(falseCount);
  		}
   	}
}
