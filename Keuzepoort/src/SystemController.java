
import java.util.Timer;
import java.util.TimerTask;

public class SystemController extends TimerTask implements SensorListener {

	private TrueSensor trueSensor;
	private FalseSensor falseSensor;
	private QuestionHandler questionHandler;

	public static void main(String[] args) {
		SystemController systemController = new SystemController();
	}

	public void run() {
		System.out.println(questionHandler.getNextQuestion());
	}

	public SystemController() {
		questionHandler = new QuestionHandler();
		trueSensor = new TrueSensor();
		trueSensor.setListener(this);
		falseSensor = new FalseSensor();
		falseSensor.setListener(this);

		trueSensor.run();
		falseSensor.run();

		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(this, 0, 30 * 60 * 60 * 1000);
	}

	public void SensorTriggered(Sensor s) {
		if(s == trueSensor) {
			System.out.println("TrueSensor triggered!");
		} else if(s == falseSensor) {
			System.out.println("FalseSenor triggered!");
		}
	}
}
