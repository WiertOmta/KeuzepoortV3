
import java.util.Timer;
import java.util.TimerTask;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class SystemController extends TimerTask implements GpioPinListenerDigital {

	private TrueSensor trueSensor;
	private FalseSensor falseSensor;
	private QuestionHandler questionHandler;
	private int trueCount;
	private int falseCount;
	private String currentQuestion;

	public static void main(String[] args) {
		SystemController systemController = new SystemController();
	}

	public void run() {
		trueCount = 0;
		falseCount = 0;
		currentQuestion = questionHandler.getNextQuestion();
		System.out.println(currentQuestion);
	}

	public SystemController() {
		trueCount = 0;
		falseCount = 0;
		questionHandler = new QuestionHandler();
		trueSensor = new TrueSensor();
		trueSensor.setListener(this);
		falseSensor = new FalseSensor();
		falseSensor.setListener(this);

		trueSensor.start();
		falseSensor.start();

		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(this, 0, 5000);
	}
	
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
  		System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin().getAddress() + " = " + event.getState());
   	}
}
