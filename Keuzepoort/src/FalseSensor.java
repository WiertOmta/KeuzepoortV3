public class FalseSensor extends Sensor {

	public FalseSensor() {

	}

	public void setListener(SensorListener sensorListener) {
		theListener = sensorListener;
	}

	public void run() {
		/*Check the IR sensor. If the IR sensor sensed something, tell the listener.*/
		while(true) {
			System.out.println("FalseSensor!");
		}
	}
}