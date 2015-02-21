
public class SystemController implements SensorListener, TimerTask {

	private TrueSensor trueSensor;
	private FalseSensor falseSensor;

	public static void main(String[] args) {
		SystemController systemController = new SystemController();
	}

	public SystemController() {
		trueSensor = new TrueSensor();
		trueSensor.setListener(this);
		falseSensor = new FalseSensor();
		falseSensor.setListener(this);

		trueSensor.run();
		falseSensor.run();
	}

	public void SensorTriggered(Sensor s) {
		if(s == trueSensor) {
			System.out.println("TrueSensor triggered!");
		} else if(s == falseSensor) {
			System.out.println("FalseSenor triggered!");
		}
	}
}
