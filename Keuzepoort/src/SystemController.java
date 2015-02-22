
import java.util.Timer;
import java.util.TimerTask;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class SystemController extends TimerTask implements GpioPinListenerDigital {

	private TrueSensor trueSensor;
	private FalseSensor falseSensor;
	private QuestionHandler questionHandler;

	public static void main(String[] args) {
		SystemController systemController = new SystemController();
	}

	public void run() {
		//System.out.println(questionHandler.getNextQuestion());
		System.out.println("TimerTask ticked!");
	}

	public SystemController() {
		//questionHandler = new QuestionHandler();
		trueSensor = new TrueSensor();
		trueSensor.setListener(this);
		falseSensor = new FalseSensor();
		//falseSensor.setListener(this);

		trueSensor.start();
		falseSensor.start();

		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(this, 0, 30 * 60 * 60 * 1000);
	}
	
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
   		// display pin state on console
  		System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
   	}

	/*public void SensorTriggered(Sensor s) {
		if(s == trueSensor) {
			System.out.println("TrueSensor triggered!");
		} else if(s == falseSensor) {
			System.out.println("FalseSenor triggered!");
		}
	}*/
}
