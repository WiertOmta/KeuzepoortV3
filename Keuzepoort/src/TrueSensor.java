public class TrueSensor extends Sensor implements Runnable {

	public TrueSensor() {

	}

	public void setListener(SensorListener sensorListener) {
		theListener = sensorListener;
	}

	public void run() {
		/*Check the IR sensor. If the IR sensor sensed something, tell the listener.*/
		System.out.println("TrueSensor!");
	}
}