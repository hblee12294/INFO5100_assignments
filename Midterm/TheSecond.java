
public class TheSecond {

	public int arrangeCoins(int n) {
		int i = 0;
		int sum = i;
		while (true) {
			int j = i + 1; 
			sum += j;
			if (n < sum)
				return j - 1;
			++i;
		}
	}
	
	public static void main(String[] args) {
		TheSecond ts = new TheSecond();
		
		System.out.println(ts.arrangeCoins(0));
		System.out.println(ts.arrangeCoins(1));
		System.out.println(ts.arrangeCoins(2));
		System.out.println(ts.arrangeCoins(5));
		System.out.println(ts.arrangeCoins(10));
		System.out.println(ts.arrangeCoins(11));
		System.out.println(ts.arrangeCoins(15));
		System.out.println(ts.arrangeCoins(1714636915));
	}
}
