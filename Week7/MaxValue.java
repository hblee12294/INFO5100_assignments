
public class MaxValue extends Thread {
	private String name;
	private int lo, hi;
	private int[] arr;
	private int maxValue;

	public MaxValue(int[] arr, int lo, int hi, String name) {
		this.arr = arr;
		this.lo = lo;
		this.hi = hi;
		this.name = name;
	}
	
	public void run() {
		System.out.println(name + " is running ...");
		for (int i = lo; i < hi; ++i) {
			if (arr[i] > maxValue)
				maxValue = arr[i];
		}
	}
	
	public static int max(int[] arr) throws InterruptedException {
		int len = arr.length;
		int value = 0;
		
		MaxValue[] mv = new MaxValue[4];
		for (int i = 0; i < 4; ++i) {
			mv[i] = new MaxValue(arr, i/4 * len, (i+1)/4 * len, "Thread " + i);
			mv[i].start();
		}
		
		for (int i = 0; i < 4; ++i) {
			mv[i].join();
			if (mv[i].maxValue > value)
				value = mv[i].maxValue;
		}
		return value;
	}
	
	public static void main(String[] args) throws InterruptedException {
		int[] array = new int[50];
		for (int i = 0; i < array.length; ++i) {
			array[i] = (int)(Math.random() * 100);
		}
		
		System.out.print("Array: ");
		for (int a : array)
			System.out.print(a + " ");
		System.out.println("");
		
		int result = max(array);
		System.out.println("Max value: " + result);
	}
}
