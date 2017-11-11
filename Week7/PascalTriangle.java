
public class PascalTriangle {

	public void printPascalTriangle(int n) {
		int[][] matrix = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i + 1; ++j) {
				if (j == 0)
					matrix[i][j] = 1;
				if (i - 1 >= 0 && j - 1 >= 0)
					matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		
		pt.printPascalTriangle(1);
		System.out.println();
		
		pt.printPascalTriangle(3);
		System.out.println();
		
		pt.printPascalTriangle(6);
		System.out.println();
		
		pt.printPascalTriangle(10);
		System.out.println();
	}
}
