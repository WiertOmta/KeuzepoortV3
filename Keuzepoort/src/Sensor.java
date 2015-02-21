public abstract class Sensor implements Runnable {
	protected SensorListener theListener = null;
	abstract void setListener(SensorListener sensorListener);
}