
/*1.
Example 1:  
Input: S = "2-4A0r7-4k", K = 4  
Output: "24A0-R74K"  
Explanation: The string S has been split into two parts, each part has 4 characters.
	
Example 2:  
Input: S = "2-4A0r7-4k", K = 3  
Output: "24-A0R-74K"  
Explanation: The string S has been split into three parts, each part has 3 characters, except the first part as it could be shorter as said above.  
*/

public class ReformateLicense {
	public String licenseReformate(String oldStr, int k) {
		String tmpStr = "";	// string which holds pure alphanumerical characters
		String newStr = ""; // string to be output

		for (int i = 0; i < oldStr.length(); ++i) {	// to strip dash
			if (oldStr.charAt(i) == '-') continue;
			tmpStr += oldStr.charAt(i);
		}
		
		tmpStr = tmpStr.toUpperCase();
		int fpl = tmpStr.length() % k;	// fpl: length of first part
		
		for (int j = 0; j < tmpStr.length(); ++j) {
			if (j != 0 && (j == fpl || j % k == 0))	// concate dash
				newStr += '-';
			newStr += tmpStr.charAt(j);
		}
		
		return newStr;
	}

	/* Test
	public static void main(String[] args) {
		ReformateLicense rl = new ReformateLicense();
		
		String str1 = "2-4A0r7-4k";
		int K1 = 4;
		String str2 = "2-4A0r7-4k";
		int K2 = 3;
		String str3 = "Udc-0342-OO49-z";
		int K3 = 3;

		System.out.println(rl.licenseReformate(str1, K1));
		System.out.println(rl.licenseReformate(str2, K2));
		System.out.println(rl.licenseReformate(str3, K3));

	}
	*/
}


/*2.Implement a class called Tool. It should have an int field called strength and a char field called type. 
	You may make them either private or protected. The Tool class should also contain the function void setStrength(int), which sets the strength for the Tool.
	Create 3 more classes called Rock, Paper, and Scissors, which inherit from Tool. Each of these classes will need a constructor which will take in 
	an int that is used to initialise the strength field. The constructor should also initialise the type field using 'r' for Rock, 'p' for Paper, and 's' for Scissors.
	These classes will also need a public function bool fight(Tool) that compares their strengths in the following way:
	Rock's strength is doubled (temporarily) when fighting scissors, but halved (temporarily) when fighting paper.
	In the same way, paper has the advantage against rock, and scissors against paper.
	The strength field shouldn't change in the function, which returns true if the original class wins in strength and false otherwise.
	You may also include any extra auxiliary functions and/or fields in any of these classes. Run the program without changing the main function, and 
	verify that the results are correct. 
*/

// ---------- class Tool ----------
public class Tool {

	private int strength;
	private char type;
	
	public Tool() {
		strength = 0;
		type = 't';
	}
	
	public int getStrength() {
		return strength;
	}
	
	public char getType() {
		return type;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void setType(char type) {
		this.type = type;
	}
}

// ---------- class Scissors ----------
public class Scissors extends Tool{
	
	public Scissors() {
		super();
		setType('s');;
	}
	
	public Scissors(int strength) {
		this();
		this.setStrength(strength);
	}
	
	public boolean fight(Tool opp) {
		boolean result = false;
		
		if (opp.getType() == 'p') {
			result = (getStrength() * 2 > opp.getStrength());
		}
		if (opp.getType() == 'r') {
			result = (getStrength() / 2 > opp.getStrength());
		}
		
		return result;
	}
}

// ---------- class Paper ----------
public class Paper extends Tool {

	public Paper () {
		super();
		setType('p');
	}
	
	public Paper(int strength) {
		this();
		this.setStrength(strength);
	}
	
	public boolean fight(Tool opp) {
		boolean result = false;
		
		if (opp.getType() == 'r') {
			result = (getStrength() * 2 > opp.getStrength());
		}
		if (opp.getType() == 's') {
			result = (getStrength() / 2 > opp.getStrength());
		}
		
		return result;
	}
}

// ---------- class Rock ----------
public class Rock extends Tool {

	public Rock() {
		super();
		setType('r');
	}
	
	public Rock(int strength) {
		this();
		this.setStrength(strength);
	}
	
	public boolean fight(Tool opp) {
		boolean result = false;
		
		if (opp.getType() == 's') {
			result = (getStrength() * 2 > opp.getStrength());
		}
		if (opp.getType() == 'p') {
			result = (getStrength() / 2 > opp.getStrength());
		}
		
		return result;
	}
}

/* Test
public class RockPaperScissorsGame {
	
	public static void main(String args[]){
		
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		
		System.out.println(s.fight(p) + " , "+ p.fight(s) );
		System.out.println(p.fight(r) + " , "+ r.fight(p) );
		System.out.println(r.fight(s) + " , "+ s.fight(r) );
		System.out.println(r.fight(r) + " , "+ s.fight(r) );
	}
}
*/


/*3.Instance variables:  
	dottedDecimal – a dotted-decimal string. Example value: "216.27.6.136"
	firstOctet, secondOctet, thirdOctet, fourthOctet – four int variables that store the octets for an IP address
	This constructor receives one parameter, a dotted-decimal string. You may assume that the parameter’s value is valid (i.e., no error checking required). 
	The constructor initialises the instance variables with appropriate values. There are many ways to solve the problem of extracting octets from the given dotted-decimal string.
	We recommend that you use String methods to extract the individual octets as strings, and then use parseInt method calls to convert the octet strings to ints.
	getDottedDecimal method:  This is a standard accessor method that simply returns the dottedDecimal instance variable’s value.
	getOctet method:  This method receives the position of one of the octets (1, 2, 3, or 4) and returns the octet that’s at that position.
	Provide a driver class that tests your IpAddress class. Your driver class should contain this main method:
	public static void main(String args[]){
		
			IpAddress ip = new IpAddress("216.27.6.136");
  			System.out.println(ip.getDottedDecimal());
  			System.out.println(ip.getOctet(4));
  			System.out.println(ip.getOctet(1));
  			System.out.println(ip.getOctet(3));
  			System.out.println(ip.getOctet(2));
*/

public class IpAddress {
	private String dottedDecimal;
	private int firstOctet;
	private int secondOctet;
	private int thirdOctet;
	private int fourthOctet;
	
	public IpAddress() {
		dottedDecimal = "000.000.000.000";
	}

	public IpAddress(String ipStr) {
		dottedDecimal = ipStr;
		String[] octets = ipStr.split("\\.");
		firstOctet = Integer.parseInt(octets[0]);
		secondOctet = Integer.parseInt(octets[1]);
		thirdOctet = Integer.parseInt(octets[2]);
		fourthOctet = Integer.parseInt(octets[3]);
	}
	
	public String getDottedDecimal() {
		return dottedDecimal;
	}
	
	public int getOctet(int position) {
		switch(position) {
			case 1:
				return firstOctet;
			case 2:
				return secondOctet;
			case 3:
				return thirdOctet;
			case 4:
				return fourthOctet;
			default:
				System.out.println("Position out of scope!(1-4)");
				return 0;
		}
	}
	
	/*
	public static void main(String args[]){	
		IpAddress ip = new IpAddress("216.27.6.136");
		
		System.out.println(ip.getDottedDecimal());
		System.out.println(ip.getOctet(4));
		System.out.println(ip.getOctet(1));
		System.out.println(ip.getOctet(3));
		System.out.println(ip.getOctet(2));
	}
	*/
}


/*4.Design a simple registration system that allows Student to register in a course using 2 classes: class Student & class Course.
	Implement the scenarios in class Test’s main method.
	Each student has a name and an id variables.
	Each object of class Student is initialised using values of name and id passed to constructor.
	Class Student has accessor methods for its instance variables
	---
	Each Course has a name, and a variable numberOfStudent representing the number of registered students.
	A course can have a maximum number of 10 students registered in it.
	Class Course store the registered students in students which is an array of type Student.
	When a student register in a course, he is added to the array.
	Each object of class Course is initialised using the title.
	Class Course has the following methods: method getStudents(): return the array of registered students;
											method boolean isFull():  return true if the course is full, accessor method for the title and numberOfStudent field
											method registerStudent (Student student): if the course is not full, register a student in course.
*/
// ----------- Student -----------
public class Student {
	private String name;
	private int id;
	
	public Student() {}
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}

// ----------- Course -----------
public class Course {
	private String name;
	private int numOfStudent;
	private Student[] students;
	private static int MaxStudents = 10;
	
	public Course() {}
	
	public Course(String name) {
		this.name = name;
		this.numOfStudent = 0;
		this.students = new Student[10];
	}
	
	public Student[] getStudents() {
		return students;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isFull() {
		return (numOfStudent == MaxStudents);
	}
	
	public void registerStudents(Student student) {
		if (!isFull()) {
			students[numOfStudent] = student;
			System.out.println(student.getName() + "(" + student.getId() + "): register successfully!");
			++numOfStudent;
		}
		else {
			System.out.println("Sorry, the course is full now, please choose other courses.");
		}
	}
	
	/* Test
	public static void main(String[] args) {
		Student s1 = new Student("Sam", 123);
		Student s2 = new Student("Joe", 124);
		Student s3 = new Student("Sasa", 125);
		Student s4 = new Student("Allen", 126);
		Student s5 = new Student("Zus", 127);
		Student s6 = new Student("Carlos", 128);
		Student s7 = new Student("Lee", 129);
		Student s8 = new Student("Jessie", 130);
		Student s9 = new Student("Oliva", 131);
		Student s10 = new Student("Zus", 132);
		Student s11 = new Student("Zus", 133);
		
		Course course = new Course("Math");
		
		course.registerStudents(s1); 
		course.registerStudents(s2); 
		course.registerStudents(s3); 
		course.registerStudents(s4); 
		course.registerStudents(s5); 
		course.registerStudents(s6); 
		course.registerStudents(s7); 
		course.registerStudents(s8); 
		course.registerStudents(s9); 
		course.registerStudents(s10); 
		course.registerStudents(s11); 
	}
	*/
}



//5.Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.




/*6.There are two sorted arrays nums1 and nums2 of size m and n respectively.
	Find the median of the two sorted arrays. 
*/
