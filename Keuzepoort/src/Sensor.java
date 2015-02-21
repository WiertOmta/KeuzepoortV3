public abstract class Sensor implements Runnable {
	protected SensorListener theListener = null;
	abstract void run();
	abstract void setListener(SensorListener sensorListener);
}