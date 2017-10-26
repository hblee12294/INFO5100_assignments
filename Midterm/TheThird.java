
public class TheThird {

	public int minMoves(int[] nums) {
		int sum = 0;
		int min = nums[0];
		for (int n : nums)
			if (n < min) min = n;
		for (int n : nums)
			sum += (n - min);
		return sum;
	}
	
	public static void main(String[] args) {
		TheThird tt = new TheThird();
		
		int[] a1 = {6, 6, 1};
		int[] a2 = {1, 2, 3};
		int[] a3 = {2, 2, 2};
		System.out.println(tt.minMoves(a1));
		System.out.println(tt.minMoves(a2));
		System.out.println(tt.minMoves(a3));
	}
}
