import java.util.*;

public class SpiralMatrix {

	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		
		int m = matrix[0].length;
		int n = matrix.length;
//		int circle = m > n ? (m + 1) / 2 : (n + 1) / 2;
		
		int hori = 0;
		int verti = 0;
		int horiLen = m - 1;
		int vertiLen = n - 1;
		
		while (horiLen > 0 || vertiLen > 0) {
			while (horiLen != 0) {
				result.add(matrix[verti][hori]);
				++hori;
				--horiLen;
			}
			horiLen += 2;
			while (vertiLen != 0) {
				result.add(matrix[verti][hori]);
				++verti;
				--vertiLen;
			}
			vertiLen += 1;
			while (horiLen != 0) {
				result.add(matrix[verti][hori]);
				--hori;
				--horiLen;
			}
			while (vertiLen != 0) {
				result.add(matrix[verti][hori]);
				--verti;
				--vertiLen;
			}
			
		}

		
		return result;
	}
	
	public void printM(int[][] matrix) {
		System.out.println("Matrix:");
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j)
				System.out.print(matrix[i][j]);
			System.out.println(" ");
		}
	}
	
	public void printMatrix(List<Integer> list) {
		System.out.println("Spiral Matrix:");
		for (int n : list)
			System.out.print(n + " ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		SpiralMatrix matrix = new SpiralMatrix();
		
		List<Integer> result = new ArrayList<Integer>();
		int[][] mtx1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] mtx2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int[][] mtx3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		result = matrix.spiralOrder(mtx1);
		matrix.printM(mtx1);
		matrix.printMatrix(result);
		
		result = matrix.spiralOrder(mtx2);
		matrix.printM(mtx2);
		matrix.printMatrix(result);
		
		result = matrix.spiralOrder(mtx3);
		matrix.printM(mtx3);
		matrix.printMatrix(result);
	}
}