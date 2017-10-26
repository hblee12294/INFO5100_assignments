
public class TheFirst {

	public int[] reverseEvenIndices(int[] nums) {
		int head = 0;
		int end = nums.length - 1;
		int tmp = 0;
		
		if (end % 2 == 1)
			--end;
		
		while (head < end) {
			tmp = nums[end];
			nums[end] = nums[head];
			nums[head] = tmp;
			head += 2;
			end -= 2;
		}
		return nums;
	}
	
	public void print(int[] nums) {
		for (int n : nums)
			System.out.print(n + " ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[] i1 = {9, 4, 8, 7, 5, 1, 3};
		int[] i2 = {6, 4, 1, 0, 3, 2};
		int[] i3 = {1, 2, 3};
		
		TheFirst tf= new TheFirst();
		tf.print(tf.reverseEvenIndices(i1));
		tf.print(tf.reverseEvenIndices(i2));
		tf.print(tf.reverseEvenIndices(i3));
		
	}
}
