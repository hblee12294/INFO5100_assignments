import java.util.Arrays;

public class Partition {

	public boolean findPartition(int arr[]) {
		Arrays.sort(arr);
		int sum = 0;
		for (int i : arr)
			sum += i;
		if (sum % 2 != 0) 
			return false;
		
		sum /= 2;
		return dfs(0, sum, arr);
	}
	
	public boolean dfs(int pos, int sum, int[] arr) {
		sum -= arr[pos];
		if (sum == 0)
			return true;
		
		for (int i = pos + 1; i < arr.length; ++i) {
			if (sum < arr[i]) break;
			if (dfs(i, sum, arr)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Partition pt = new Partition();
		
		int[] array1 = {1, 5, 11, 5};
		int[] array2 = {1, 5, 3};
		int[] array3 = {4, 8, 2, 6};
		int[] array4 = {2, 3, 9, 5};
		
		System.out.println(pt.findPartition(array1));
		System.out.println(pt.findPartition(array2));
		System.out.println(pt.findPartition(array3));
		System.out.println(pt.findPartition(array4));
	}
}
