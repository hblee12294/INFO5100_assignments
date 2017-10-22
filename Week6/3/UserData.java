import java.util.ArrayList;

public class UserData {

	public User user;
	public String password;
	public double balance;
	public ArrayList<String> transactionLog;
	public boolean logStatus;
	
	public UserData() {
		user = new User();
		password = "";
		balance = 0;
		transactionLog = new ArrayList<String>();
		logStatus = false;
	}
	
	public boolean validate(String name, int age, String phoneNumber) {
		return user.name.equals(name) && user.age == age && user.phoneNumber.equals(phoneNumber);
	}
	
	public void log(String type, double amount) {
		transactionLog.add(type + " - " + amount);
	}
}
