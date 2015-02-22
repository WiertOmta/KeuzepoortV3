import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.PinPullResistance;

public class TrueSensor extends Sensor {

	public TrueSensor() {
		gpioController = GpioFactory.getInstance();
		pin = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02, "TrueSensorPin", PinPullResistance.PULL_DOWN);
	}

	public void setListener(GpioPinListenerDigital listener) {
		pin.addListener(listener);
	}

	public void run() {
		/*Check the IR sensor. If the IR sensor sensed something, tell the listener.*/
		while(true) {
			//System.out.println("TrueSensor!");
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {

			}
		}	
	}
}