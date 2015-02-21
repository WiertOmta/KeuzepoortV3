public class FalseSensor extends Sensor implements Runnable {

	public FalseSensor() {

	}

	public void setListener(SensorListener sensorListener) {
		theListener = sensorListener;
	}

	public void run() {
		/*Check the IR sensor. If the IR sensor sensed something, tell the listener.*/
		System.out.println("FalseSensor!");
	}
}