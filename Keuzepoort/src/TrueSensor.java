import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.PinPullResistance;

public class TrueSensor extends Sensor {

	public TrueSensor() {
		pin = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02, "TrueSensorPin", PinPullResistance.PULL_DOWN);
	}

	public void setListener(GpioPinListenerDigital listener) {
		pin.addListener(listener);
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {

			}
		}	
	}
}