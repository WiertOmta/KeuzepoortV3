import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;

public abstract class Sensor extends Thread {
	protected final GpioController gpioController = GpioFactory.getInstance();
	protected GpioPinDigitalInput pin;
}