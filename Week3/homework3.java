// 1.Find the error in the folling code and explain in few lines what it is wrong.
//   Here is the code.

public class Book {
	int size;
	int price;
	String name;

	public Book(int size) {     // The type of argument 'size' is 'int'
		this.size = size;
	}

	public Book(int size, int price, String name) {
		super();
		this.size = size;
		this.price = price;
		this.name = name;
	}

	public Book(int price) {    // The type of argument 'price' is also 'int'
		this.price = price;
	}

	public setName(String name) {
		return name;
	}
}

/* 	Type or amount of arguments in constructors should be different with each other.
	Otherwise, the complier can not decide which constructor should be called when 
	initializing new objects.
*/

// ----------------------------------------------------------------------------------
//2.Find the error in the following code and explain in few lines why it is wrong.
//	Here is the code.

class Clock {
	String time;

	void getTime() {          // Return type should be 'String', which is 
		return time;          // same as the type of return value
	}

	void setTime(String t) {
		time = t;
	}
}

//	The return type of getTime() should be in consistent with the return value.	

// ----------------------------------------------------------------------------------
//3.Write a Java function to remove vowels in a string.
//	i.The function should take a string as input.
// 	ii.Should return the input string after omitting the vowels.
//  Here is the prototype you can work with.

public class CheckVowels {
	String vowels = "aeiouAEIOU";

	public String removeVowelsFromString(String input) {
		String output = "";
		boolean ifVowel = false;
			
		for (int i = 0; i < input.length(); ++i) {
			for (int j = 0; j < vowels.length(); ++j) {
				if (input.charAt(i) == vowels.charAt(j)) {
					ifVowel = true;
					break;
				}
			}
			if (!ifVowel)
				output += input.charAt(i);
			ifVowel = false;
		}
		return output;
	}
	
	/* Test
	public static void main(String[] args) {
		CheckVowels check = new CheckVowels();
		String str1 = "AEIOUaeiou";
		String str2 = "Iloveu";
		String str3 = "Give me five.";
		
		String rst1 = check.removeVowelsFromString(str1);
		String rst2 = check.removeVowelsFromString(str2);
		String rst3 = check.removeVowelsFromString(str3);
		
		System.out.println(rst1);
		System.out.println(rst2);
		System.out.println(rst3);
	}
	*/
}

// ----------------------------------------------------------------------------------
//4.Write a java function to check if two strings are Anagrams or not.
//	i.The function should take two input strings.
//	ii.Should return a boolean 'true' if the inputs are Anagram else return 'false'
//	Here is the protype you can work with.

public class CheckAnagrams {
//	int[] alphabet;       // A ~ Z and a ~ z in ASCII from #65-122
	int[] alphabet;		  // It's actually all the characters in ASCII

	public boolean checkIfTwoStringsAreAnagrams(String s1, String s2) {
//		alphabet = new int[57];
		alphabet = new int[127];	// All ASCII characters from #0 ~ #126 
		
		if (s1.equals(s2))
			return true;
		
		for (int i = 0; i < s1.length(); ++i) {
			++alphabet[s1.charAt(i) - ' '];        // The first character is ' '(space)
		}
		
		for (int j = 0; j < s2.length(); ++j) {
			--alphabet[s2.charAt(j) - ' '];
		}
		
		for (int k = 0; k < alphabet.length; ++k) {
			if (alphabet[k] != 0)
				return false;
		}
		
		return true;
	}
	
	/* Test
	public static void main(String[] args) {
		CheckAnagrams check = new CheckAnagrams();
		boolean result;
		
		String str1 = "abcdefg";
		String str2 = "gfedcba";
		result = check.checkIfTwoStringsAreAnagrams(str1, str2);
		System.out.println(str1 + " & " + str2 + ": " + result); 
		
		String str3 = "Elva";
		String str4 = "Leav";
		result = check.checkIfTwoStringsAreAnagrams(str3, str4);
		System.out.println(str3 + " & " + str4 + ": " + result); 
		
		String str5 = "Utoo";
		String str6 = "tooU";
		result = check.checkIfTwoStringsAreAnagrams(str5, str6);
		System.out.println(str5 + " & " + str6 + ": " + result); 

		String str7 = "U t oo%#";
		String str8 = " t %#ooU";
		result = check.checkIfTwoStringsAreAnagrams(str7, str8);
		System.out.println(str7 + " & " + str8 + ": " + result); 
	}
	*/
}

// ----------------------------------------------------------------------------------
//5.Create a calculator that can perform the following featrues.
//	i.The calculator should be able to perform addition, subtraction, multiplication, 
//	division.
//	ii.Should be able to perform squreRoot, square, cube.
//	iii.Should be able to convert 'Fahrenheit-Celsius', 'Feet-Inches'.
//	This calculator should be able to solve a quadratic equation and return the solution
//	as array.
//	i.This function should take three arguments.
//	ii.For example, if quadriatic equation is Ax^2 + BX + C. The function should take
//	A,B,C as arguments and return a solution as array.


public class Calculator {

	public double add(double num1, double num2) {	// Addition
		return num1 + num2;
	}
	
	public double sub(double num1, double num2) {  	// Subtractrion
		return num1 - num2;
	}
	
	public double mul(double num1, double num2) {	// Multiplication
		return num1 * num2;
	}
	
	public double div(double num1, double num2) {	// Division
		if (num2 == 0) {
			System.out.println("Divident cannot be Zero.");
			return 0;
		}
		return num1 / num2 + num1 % num2;
	}
	
	public double sqr(double num) {		// Square
		return num * num;
	}
	
	public double cube(double num) {	// Cube
		return num * num * num;
	}
	
	public double sqrRoot(double num) {	// Square root
		if (num < 0) {
			System.out.println("Radicand cannot be minus.");
			return 0;
		}
		return Math.sqrt(num);
	}
	
	public double fahrToCels(double temp) {	// Fahrenheit to Celsius
		return (temp - 32) / 1.8;
	}
	
	public double celsToFahr(double temp) {	// Celsius to Fahrenheit
		return temp * 1.8 + 32;
	}
	
	public double[] quadraticEquation(int a, int b, int c) {	// Quadratic Equation
		double delta = b * b - 4 * a * c;
		double roots[] = {0, 0};
		
		if (delta < 0) {
			System.out.println("The quation has no real roots.");
		} 
		else if (delta == 0) {
			roots[0] = (-b + Math.sqrt(delta)) / (2 * a);
			roots[1] = roots[0];
		}
		else {
			roots[0] = (-b + Math.sqrt(delta)) / (2 * a);
			roots[1] = (-b - Math.sqrt(delta)) / (2 * a);
		}
		
		return roots;
	}
	
	/*
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		double result = 0;
		
		double number1 = 2.412;
		double number2 = 8.349;
		
		result = cal.add(number1, number2);
		System.out.println(number1 + " + " + number2 + " = " + result);
		
		result = cal.sub(number1, number2);
		System.out.println(number1 + " - " + number2 + " = " + result);
		
		result = cal.mul(number1, number2);
		System.out.println(number1 + " * " + number2 + " = " + result);
		
		result = cal.div(number1, number2);
		System.out.println(number1 + " / " + number2 + " = " + result);
		
		result = cal.sqr(number1);
		System.out.println(number1 + " ^2 = " + result);
		
		result = cal.cube(number1);
		System.out.println(number1 + " ^3 = " + result);
		
		result = cal.sqrRoot(number1);
		System.out.println(number1 + " sqrt = " + result);
		
		double tmp1 = 66.2;
		double tmp2 = 19;
		
		result = cal.fahrToCels(tmp1);
		System.out.println(tmp1 + "F = " + result + "C");
		
		result = cal.celsToFahr(tmp2);
		System.out.println(tmp2 + "C = " + result + "F");
		
		double[] rootsResult = cal.quadraticEquation(2, 8, 6);
		System.out.println("x1 = " + rootsResult[0] + "; x2 = " + rootsResult[1]);
	}
	*/
}
