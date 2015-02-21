public abstract class Sensor extends Thread {
	protected SensorListener theListener = null;
	abstract void setListener(SensorListener sensorListener);
}