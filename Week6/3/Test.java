
public class Test {

	public static void main(String[] args) {
		Atm atm = new Atm(1000, 25);
		
		// Login and Reset password
		atm.start();
		
		// Test deposit and withDraw
		atm.deposit(100);
		atm.deposit(1000);
		atm.withDraw(50);
		// Test recentTransaction
		atm.recentTransactions();
		
		atm.deposit(346);
		atm.deposit(743);
		atm.withDraw(973);
		atm.deposit(500);
		atm.deposit(203);
		atm.withDraw(465);
		atm.deposit(4985);
		atm.deposit(135);
		atm.withDraw(236);
		atm.recentTransactions();
		
		// Test changePassword
		atm.changePassword();
		
		// Test withDraw amount is more than availableBalance
		atm.withDraw(6389);
		// Test withDraw amount is more than availableBalance in ATM
		atm.withDraw(100000);
		
		// Test exit
		atm.exit();
	}
} 
