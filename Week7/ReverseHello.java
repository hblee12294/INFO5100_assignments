
public class ReverseHello extends Thread {
	private int id;
	
	public ReverseHello(int id) {
		this.id = id;
	}
	
	public void run() {
//		System.out.println("Thread " + id + " is running ...");
		try {
			if (id != 50) {
				ReverseHello rh = new ReverseHello(id+1);
				rh.start();
				rh.join();
			}
			System.out.println("Hello from Thread " + id + "£¡");
		}
		catch (InterruptedException e) {
			System.out.println("Thread " + id + " interrupted.");
		}

	}
	
	public static void main(String[] args) {
		ReverseHello rh = new ReverseHello(1);
		rh.start();
	}
}
