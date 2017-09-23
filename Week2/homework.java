
//#1
public class SalaryCalculator {

	public double employeeSalary(double hours) {
		double salary = 0;
		
		if (hours <= 36) {
			salary += hours * 15;
		}
		else if (hours <= 41) {
			salary += 36 * 15 + (hours - 36) * 15 * 1.5; 
		}
		else if (hours <= 48) {
			salary += 36 * 15 + 5 * 15 * 1.5 + (hours - 36 - 5) * 15 * 2;
		}
		else {
			salary += 36 * 15 + 5 * 15 * 1.5 + (48 - 36 - 5) * 15 * 2;
		}
		
		return salary;
	}

/* test
public static void main(String[] args) {
		double hr1 = 20;
		double hr2 = 39;
		double hr3 = 48;
		double hr4 = 50;
		SalaryCalculator calculator = new SalaryCalculator();
		
		double s1 = calculator.employeeSalary(hr1);
		double s2 = calculator.employeeSalary(hr2);
		double s3 = calculator.employeeSalary(hr3);
		double s4 = calculator.employeeSalary(hr4);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
	}
*/

//---------------------------------------------
// #2
public class DigitsAddition {

	public int addDigits(int input) {
		int sum = 0;
		int integer = input;
		int digit = 0;
		
		while (integer != 0) {
			 digit = integer % 10;
			 integer = integer / 10;
			 sum += digit;
		}
		
		return sum;
	}

/* test
public static void main(String[] args) {
		int i1 = 345;
		int i2 = 104;
		int i3 = 73;
		int i4 = 2;
		DigitsAddition dgtsAd = new DigitsAddition();
		
		int r1 = dgtsAd.addDigits(i1);
		int r2 = dgtsAd.addDigits(i2);
		int r3 = dgtsAd.addDigits(i3);
		int r4 = dgtsAd.addDigits(i4);
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
	}
*/


//---------------------------------------------
// #3
public class PerfectNumber {

	public void printPerfectNumber(int n) {
		for (int i = 1; i <= n; ++i) {
			int divisorSum = 0;
			
			for (int j = 1; j < i; ++j) {
				if (i % j == 0)
					divisorSum += j;
			}
			
			if (divisorSum == i)
				System.out.println(i + " is a perfect number between 1 to " + n);
		}
	}
	
/* test
	public static void main(String[] args) {
		int n1 = 6;
		int n2 = 300;
		int n3 = 1000;
		PerfectNumber pNum = new PerfectNumber();
		
		pNum.printPerfectNumber(n1);
		pNum.printPerfectNumber(n2);
		pNum.printPerfectNumber(n3);
	}
}
*/



// #4



// #5



// #6
public class TranglePrinter {

	public void printIsoscelesTrangle(int n) {
		for (int i = 0; i < n; ++i) {			
			for (int j = 0; j <= i; ++j) {
				if (j == 0 || j == i || i == n-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}

/* test
public static void main(String[] args) {
		TranglePrinter printer = new TranglePrinter();
		
		printer.printIsoscelesTrangle(3);
		System.out.println(" ");
		printer.printIsoscelesTrangle(6);
		System.out.println(" ");
		printer.printIsoscelesTrangle(8);
	}
*/