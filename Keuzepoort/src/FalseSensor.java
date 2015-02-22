import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class FalseSensor extends Sensor {

	private final GpioController gpioController;
	private final GpioPinDigitalInput pin;

	public FalseSensor() {
		gpioController = GpioFactory.getInstance();
		pin = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_13, "FalseSensorPin", PinPullResistance.PULL_DOWN);
	}

	/*public void setListener(SensorListener sensorListener) {
		theListener = sensorListener;
	}*/

	public void setListener(GpioPinListenerDigital listener) {
		pin.addListener(listener);
	}

	public void run() {
		/*Check the IR sensor. If the IR sensor sensed something, tell the listener.*/
		while(true) {
			//System.out.println("FalseSensor!");
		}
	}
}