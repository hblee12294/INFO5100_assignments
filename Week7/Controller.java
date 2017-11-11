import java.text.DecimalFormat;

public class Controller extends Thread {

	private Device device;
	private Sensor heat;
	private Sensor pressure;
	private DecimalFormat df = new DecimalFormat("###0.00");
	
	public Controller(Device device, Sensor heat, Sensor pressure) {
		this.device = device;
		this.heat = heat;
		this.pressure = pressure;
	}
	
	public void run() {
		device.startup();
		synchronized (device) {
			while (heat.getValue() <= 70 && pressure.getValue() <= 100) {
				System.out.println("heat -> " + df.format(heat.getValue()) + " ,pressure -> " + df.format(pressure.getValue()));
				try {
					device.wait();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			Sensor.exit = false;
			System.out.println("heat -> " + df.format(heat.getValue()) + " ,pressure -> " + df.format(pressure.getValue()));
		}
		device.shutdown();
	}
}
