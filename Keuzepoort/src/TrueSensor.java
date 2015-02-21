public class TrueSensor extends Sensor {

	public TrueSensor() {

	}

	public void setListener(SensorListener sensorListener) {
		theListener = sensorListener;
	}

	public void run() {
		/*Check the IR sensor. If the IR sensor sensed something, tell the listener.*/
		System.out.println("TrueSensor!")
	}
}