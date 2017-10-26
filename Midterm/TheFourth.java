
public class TheFourth {
	int result = 0;
	
	public int countNumberOfPossibleWays(int m, int n, int x) {
		int sum = 0;
		recursion(m, n, 1, sum, x);
		return result;
	}
	
	public void recursion(int m, int n, int start, int sum, int x) {
		if (sum == x && start == n + 1) {
			++result;
			return;
		}
		
		if (start == n + 1) {
			return;
		}
		
		for (int i = 1; i <= n; ++i) {
			sum += i;
			recursion(m, n, start + 1, sum, x);
			sum -= i;
		}
	}
	
	public static void main(String[] args) {
		TheFourth tf = new TheFourth();
		
		System.out.println(tf.countNumberOfPossibleWays(3, 6, 15));
	}

}
