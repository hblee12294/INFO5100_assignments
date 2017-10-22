import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
	
	private double availableAmountInMachine;
	private double transactionFee;
	private ArrayList<UserData> users; 
	private UserData currentUser;
	
	public Atm(double availableAmountInMachine, double transactionFee) {
	this.availableAmountInMachine = availableAmountInMachine;
	this.transactionFee = transactionFee;
	init();
	}
	
	// For checking users
	public void printUsers() {
		for (UserData data: users) {
			System.out.println(data.user.bankAccountNumber + " + " + data.password);
		}
	}
	
	// For importing user data
	public void init() {
		users = new ArrayList<UserData>();
		
		// Test user1
		UserData user1 = new UserData();
		user1.user.name = "Wang";
		user1.user.age = 18;
		user1.user.address = "Terry Ave";
		user1.user.bankAccountNumber = "BK3456";
		user1.user.phoneNumber = "2063996674";
		user1.password = "123456";
		user1.balance = 1000;
		user1.logStatus = false;
		user1.transactionLog = new ArrayList<String>();
		users.add(user1);
		
		// Test user2
		UserData user2 = new UserData();
		user2.user.name = "Lily";
		user2.user.age = 34;
		user2.user.address = "1st St.";
		user2.user.bankAccountNumber = "BK0987";
		user2.user.phoneNumber = "2064594604";
		user2.password = "234567";
		user2.balance = 50000;
		user2.logStatus = false;
		user2.transactionLog = new ArrayList<String>();
		users.add(user2);
		
		// Test user3
		UserData user3 = new UserData();
		user3.user.name = "Jone";
		user3.user.age = 64;
		user3.user.address = "Space niddle";
		user3.user.bankAccountNumber = "BK6666";
		user3.user.phoneNumber = "2069347265";
		user3.password = "666666";
		user3.balance = 400;
		user3.logStatus = false;
		user3.transactionLog = new ArrayList<String>();
		users.add(user3);
	}
	
	// Start ATM process
	public void start() {
		if (login()) {
			System.out.println("*** Login successfully! ***");
		}
		else {
			System.out.println("*** Login unsuccessfully. ***");
		}
	}
	
	public boolean login() {
		System.out.println("|Log in|");
		System.out.print("Are you a NEW USER or CURRENT USER? /Forget Password? (N/C/F): ");
		UserData tmpUser = new UserData();
		String tmpAccountNumber = "";
		String tmpPassword = "";
		
		Scanner input = new Scanner(System.in);
		
		switch(input.next().charAt(0)) {
			default:
				System.out.print("Invalid input! Please enter 'N' or 'C'");
				break;
			case 'n':
			case 'N':
				// Set random bank account number and password
				tmpAccountNumber = "BK" + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10);
				tmpPassword = "" + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10);
				tmpUser.user.bankAccountNumber = tmpAccountNumber;
				System.out.println("Your account number is: " + tmpAccountNumber);
				tmpUser.password = tmpPassword;
				System.out.println("Your password is:" + tmpPassword);
				tmpUser.logStatus = true;
				currentUser = tmpUser;
				users.add(tmpUser);
				break;
			case 'c':
			case 'C':
				System.out.print("Account number ('BK' + 4 digits): ");
				tmpAccountNumber = input.next();
//				tmpAccountNumber = "BK6666";                              // Auto TEST
				System.out.print("Password (6 digits): ");
				tmpPassword = input.next();
//				tmpPassword = "666666";                                   // Auto TEST
				
				for (UserData userData : users) {
					if ((userData.user.bankAccountNumber).equals(tmpAccountNumber)) {
						if (userData.password.equals(tmpPassword)) {
							userData.logStatus = true;
							currentUser = userData;
							System.out.println("Loging...");
							return currentUser.logStatus;
						}
						else {
							System.out.println("*** Wrong password. ***");
							currentUser = userData;
							return currentUser.logStatus;
						}
					}
				}
				System.out.println("*** User not found. ***");
				break;
			case 'f':
			case 'F':
				if (resetPassword())
					System.out.println("*** Reset successfully. ***");
				else {
					System.out.println("*** Reset unsuccessfully. ***");
					currentUser = tmpUser;
				}
				break;
		}
		return currentUser.logStatus;
	}
	
	public boolean resetPassword() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n|Rest Password|");
		System.out.print("Enter name: ");
		String tmpName = input.next();
		System.out.print("Enter age: ");
		int tmpAge = Integer.parseInt(input.next());
		System.out.print("Enter phone number: ");
		String tmpPhoneNumber = input.next();

		for (UserData userData: users) {
			if (userData.validate(tmpName, tmpAge, tmpPhoneNumber)) {
				userData.password = ("" + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10));
				System.out.println("Your new password is: " + userData.password);
				userData.logStatus = true;
				currentUser = userData;
				return true;
			}
		}
		System.out.println("User information dismatched.");
		return false;
	}
	
	public double availableBalance() {
		if (currentUser.logStatus == false) {
			System.out.println("*** You have not log in yet. ***");
			return 0.0;
		}
		return currentUser.balance;
	}
	
	public boolean withDraw(double amount) {
		System.out.println("\n|WithDraw|");
		
		if (currentUser.logStatus == false) {
			System.out.println("*** You have not log in yet. ***");
			return false;
		}
		
		if (amount > availableAmountInMachine) {
			System.out.println("*** Available balance in ATM is not enough! ***");
			return false;
		}
		else if (amount > currentUser.balance) {
			System.out.println("*** Available balance is not enough! ***");
			return false;
		}
		else {
			currentUser.balance -= amount + transactionFee;
			availableAmountInMachine -= amount;
			currentUser.log("withDraw", amount);
			System.out.println("*** Withdraw " + amount + " ***");
		}
		
		return true;
	}
	
	public boolean deposit(double amount) {
		System.out.println("\n|Deposit|");
		
		if (currentUser.logStatus == false) {
			System.out.println("*** You have not log in yet. ***");
			return false;
		}
		
		currentUser.balance += amount - transactionFee;
		availableAmountInMachine += amount;
		currentUser.log("dposit", amount);
		System.out.println("*** Deposit " + amount + " ***");
		
		return true;
	}
	
	public boolean recentTransactions() {
		System.out.println("\n|Deposit|");
		
		if (currentUser.logStatus == false) {
			System.out.println("*** You have not log in yet. ***");
			return false;
		}
		
		System.out.println("(From the most recent transaction)");
		if (currentUser.transactionLog.size() > 10) {
			for (int i = 0; i < 10; ++i)
				System.out.println(currentUser.transactionLog.get(currentUser.transactionLog.size()-i-1));
		}
		else {
			for (int i = currentUser.transactionLog.size() - 1; i >= 0; --i) {
				System.out.println(currentUser.transactionLog.get(i));
			}
		}
		
		return true;
	}
	
	public boolean changePassword() {
		System.out.println("\n|Change password|");
		
		if (currentUser.logStatus == false) {
			System.out.println("*** You have not log in yet. ***");
			return false;
		}
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter new password (6 digits): ");
		String newPassword = input.next();
		
		if (newPassword.length() == 6) {
			currentUser.password = newPassword;
			System.out.println("Your new password is: " + currentUser.password);
			System.out.println("*** Password changed successfully! ***");
			return true;
		}
		
		System.out.println("Password length is not 6.");
		System.out.println("*** Password changed unsuccessfully. ***");
		return false;
	}
	
	public void exit() {
		System.out.println("\n|Exit|");
		
		if (currentUser.logStatus == false) {
			System.out.println("*** You have not log in yet. ***");
			return;
		}
		
		currentUser.logStatus = false;
		System.out.println("*** Thanks for using our service. ***");
	}
}
