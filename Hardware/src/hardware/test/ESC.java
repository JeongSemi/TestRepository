
package hardware.test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.wiringpi.Gpio;

public class ESC {
	
	private GpioPinPwmOutput pin;
	private double minDuration;
	private double maxDuration;
	
	public ESC(Pin pinNo, double minDuration, double maxDuration){
		GpioController gpioController = GpioFactory.getInstance();
		pin = gpioController.provisionPwmOutputPin(pinNo);
		Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
		Gpio.pwmSetClock(1920);
		Gpio.pwmSetRange(200);
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
	}
	
	public static void main(String[] args){
		
	}

}
