
// Exception class
public class MyIndexOutOfBoundException extends Exception{
	private int lowerBound;
	private int upperBound;
	private int index;
	
	public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}
	
	public String getMessage() {
		
		// I wonder if I need to pass the message to Throwable class or not. I just override getMessage method here. 
		return "Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper Bound: " + upperBound;
	}
}

// Test class
public class ErrorTest {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		int testIndex = 0;
		
		try {
			while (true) {
				if (testIndex >= 0 && testIndex < arr.length) {
					System.out.println(arr[testIndex]);
					testIndex++;
				}
				else {
					throw new MyIndexOutOfBoundException(0, arr.length - 1, testIndex);
				}
			}
		}
		catch (MyIndexOutOfBoundException e) {
			System.out.println(e.getMessage());		// only get error message
//			System.out.println(e.toString());		// get error type and message
		}
	}
}
