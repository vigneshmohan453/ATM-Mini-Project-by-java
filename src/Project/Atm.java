package Project;

import java.util.HashMap;
import java.util.Scanner;

public class Atm {
	static int balance = 100000, withdraw, deposit;
	static Scanner sc = new Scanner(System.in);
	private static HashMap<String, Integer> users = new HashMap<String, Integer>();

	static {
		users.put("vignesh", 1234);
		users.put("ganesh", 5678);
	}

	public static void main(String[] args) {
		customer();
	}

	public static void atmMachine() {
		while (true) {
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("            Welcome to Mariyamman Indian Bank             ");
			System.out.println("       Choose any option to continue this operation       ");
			System.out.println();
			System.out.println("==> (1) Balance Inquiry           ==> (4) Fast Cash");
			System.out.println("==> (2) Pin Change                ==> (5) Cash withdraw");
			System.out.println("==> (3) User Details              ==> (6) Deposit");
			System.out.println("                   <== (7) Exit ==>                      ");
			System.out.println();
			System.out.println("==========================================================");

			// get choice from user
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				balanceEnquiry();
				break;
			case 2:
				pinChange();
				break;
			case 3:
				userDetails();
				break;
			case 4:
				fastCash();
				break;
			case 5:
				withdraw();
				break;
			case 6:
				deposit();
				break;
			case 7:
				exit();
				break;
			}
		}
	}

	public static void customer() {
		while (true) {
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("            Welcome to Mariyamman Indian Bank             ");
			System.out.println();
			System.out.println("            Enter UserName:                               ");
			System.out.println();
			System.out.println("==========================================================");

			String username = sc.next();
			if (users.containsKey(username)) {
				System.out.println("==========================================================");
				System.out.println();
				System.out.println("            Welcome to Mariyamman Indian Bank             ");
				System.out.println();
				System.out.println("            Welcome " + username+"........");
				System.out.println();
				System.out.println("            Enter Password:                               ");
				System.out.println();
				System.out.println("==========================================================");

				int password = sc.nextInt();

				if (users.get(username).equals(password)) 
					atmMachine();
			}
			else {
				System.out.println("==========================================================");
				System.out.println();
				System.out.println("            	    Mariyamman Indian Bank           	 ");
				System.out.println();
				System.out.println("                   <<<<<Wrong username>>>>>           ");
				System.out.println();
				System.out.println("             If you want to continue this operation       ");
				System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
				System.out.println();
				System.out.println("==========================================================");
				int choice = sc.nextInt();
				if (choice == 2)
					exit();
			}
		}
	}

	public static void balanceEnquiry() {
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                 Mariyamman Indian Bank                    ");
		System.out.println();
		System.out.println("            Your Account Balance is:= " + balance);
		System.out.println();
		System.out.println("             If you want to continue this operation       ");
		System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
		System.out.println();
		System.out.println("==========================================================");
		int choice = sc.nextInt();
		if (choice == 2)
			exit();
		System.out.println();
	}

	public static void pinChange() {

		System.out.println("==========================================================");
		System.out.println();
		System.out.println("            		Mariyamman Indian Bank             ");
		System.out.println();
		System.out.println("            Enter Username:                               ");
		System.out.println("            Enter Password:                               ");
		System.out.println("            Enter confirm Password:                               ");
		System.out.println();
		System.out.println("==========================================================");
		String username = sc.next();
		int pass1 = sc.nextInt();
		int pass2 = sc.nextInt();
		if (pass1 == pass2) {
			users.replace(username, pass2);
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("            		Mariyamman Indian Bank             ");
			System.out.println();
			System.out.println("             <<<<<Password Successfully changed>>>>>      ");
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println();
			System.out.println("==========================================================");
			int choice = sc.nextInt();
			if (choice == 1)
				atmMachine();
			if (choice == 2)
				exit();
		} else {
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("            		Mariyamman Indian Bank             ");
			System.out.println();
			System.out.println("                  <<<<<Password mismatch>>>>>      ");
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println();
			System.out.println("==========================================================");
			int choice = sc.nextInt();
			if (choice == 1)
				atmMachine();
			if (choice == 2)
				exit();
		}
	}

	public static void userDetails() {

		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                 Mariyamman Indian Bank                    ");
		System.out.println();
		System.out.println("            Enter your Username Details:.......		       ");
		System.out.println();
		System.out.println("==========================================================");

		String username = sc.next();
		int password = users.get(username);

		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                 Mariyamman Indian Bank                    ");
		System.out.println();
		System.out.println("          	   Hello " + username + " welcome		      ");
		System.out.println();
		System.out.println("               Username: " + username);
		System.out.println("               Password: " + password);
		System.out.println();
		System.out.println("             If you want to continue this operation       ");
		System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
		System.out.println();
		System.out.println("==========================================================");

		int choice = sc.nextInt();
		if (choice == 1)
			atmMachine();
		else if (choice == 2)
			exit();
	}

	public static void fastCash() {
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                 Mariyamman Indian Bank                    ");
		System.out.println();
		System.out.println("               Please select any one option               ");
		System.out.println();
		System.out.println("    ==> (1) 100                       ==> (5) 2000        ");
		System.out.println("    ==> (2) 200                       ==> (6) 5000        ");
		System.out.println("    ==> (3) 500                       ==> (7) 10000        ");
		System.out.println("    ==> (4) 1000                      ==> (8) Any other   ");
		System.out.println();
		System.out.println("==========================================================");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			fastWithdraw(100);
			break;
		case 2:
			fastWithdraw(200);
			break;
		case 3:
			fastWithdraw(500);
			break;
		case 4:
			fastWithdraw(1000);
			break;
		case 5:
			fastWithdraw(2000);
			break;
		case 6:
			fastWithdraw(5000);
			break;
		case 7:
			fastWithdraw(10000);
			break;
		case 8:
			withdraw();
			break;
		}
		System.out.println();
	}

	public static void fastWithdraw(int withdraw) {
		// remove the withdrawl amount from the total balance
		balance = balance - withdraw;
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                  Mariyamman Indian Bank                  ");
		System.out.println();
		System.out.println("                Please collect your money                 ");
		System.out.println();
		System.out.println("            Your Account Balance is:= " + balance);
		System.out.println();
		System.out.println("             If you want to continue this operation       ");
		System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
		System.out.println();
		System.out.println("==========================================================");
		int choice = sc.nextInt();
		if (choice == 2)
			exit();
		System.out.println("");
	}

	public static void withdraw() {
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                 Mariyamman Indian Bank                    ");
		System.out.println();
		System.out.println("               Enter money to be withdrawn:               ");
		System.out.println();
		System.out.println("==========================================================");
		// get the withdrawl money from user
		withdraw = sc.nextInt();
		// check whether the balance is greater than or equal to the withdrawal amount
		if (balance >= withdraw && withdraw > 0) {
			// remove the withdrawl amount from the total balance
			balance = balance - withdraw;
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("                  Mariyamman Indian Bank                  ");
			System.out.println();
			System.out.println("                Please collect your money                 ");
			System.out.println();
			System.out.println("            Your Account Balance is:= " + balance);
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println();
			System.out.println("==========================================================");
			int choice = sc.nextInt();
			if (choice == 2) {
				exit();
			}
		} else {
			// show custom error message
			System.out.println("==========================================================");
			System.out.println("                  Mariyamman Indian Bank                  ");
			System.out.println();
			System.out.println("                  Insufficient Balance....                ");
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println("==========================================================");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("==========================================================");
				System.out.println("                  Mariyamman Indian Bank                  ");
				System.out.println();
				System.out.println("               Your Account Balance:= " + balance);
				System.out.println();
				System.out.println("            	Re-Enter your withdraw Amount:            ");
				System.out.println();
				System.out.println("==========================================================");
				// get the withdrawl money from user
				withdraw = sc.nextInt();
				// check whether the balance is greater than or equal to the withdrawal amount
				if (balance >= withdraw && withdraw > 0) {
					// remove the withdrawl amount from the total balance
					balance = balance - withdraw;
					System.out.println("==========================================================");
					System.out.println("                  Mariyamman Indian Bank                  ");
					System.out.println();
					System.out.println("                Please collect your money                 ");
					System.out.println();
					System.out.println("            Your Account Balance is:= " + balance);
					System.out.println();
					System.out.println("             If you want to continue this operation       ");
					System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
					System.out.println("==========================================================");
					int choice1 = sc.nextInt();
					if (choice1 == 1)
						System.out.println();
					else if (choice1 == 2)
						exit();
				} else if (choice == 2)
					exit();
			}
			System.out.println("");
		}
	}

	public static void deposit() {
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                 Mariyamman Indian Bank                    ");
		System.out.println();
		System.out.println("              Enter money to be deposited:=                 ");
		System.out.println();
		System.out.println("==========================================================");
		// get deposite amount from te user
		deposit = sc.nextInt();
		// add the deposit amount to the total balanace
		if (deposit > 0) {
			balance = balance + deposit;
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("                 Mariyamman Indian Bank                    ");
			System.out.println();
			System.out.println("          Your Money has been successfully depsited      ");
			System.out.println();
			System.out.println("              Your Account Balance is:=" + balance);
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println();
			System.out.println("==========================================================");
		} else if (deposit <= 0) {
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("                 Mariyamman Indian Bank                    ");
			System.out.println();
			System.out.println("           <<<<<<<<Enter valid Amount>>>>>>>>             ");
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println();
			System.out.println("==========================================================");
		}
		int choice = sc.nextInt();
		if (choice == 2) {
			exit();
		}
		System.out.println();
	}

	public static void exit() {
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                  Mariyamman Indian Bank                  ");
		System.out.println();
		System.out.println("           Thank you for visiting ATM visit again...      ");
		System.out.println();
		System.out.println("==========================================================");
		System.exit(0);
	}

	public static void invalid() {
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("                  Mariyamman Indian Bank                  ");
		System.out.println();
		System.out.println("              <<<<<<<<Invalid Keyword>>>>>>>>             ");
		System.out.println();
		System.out.println("             If you want to continue this operation       ");
		System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
		System.out.println();
		System.out.println("==========================================================");
		int choice = sc.nextInt();
		if (choice == 1)
			atmMachine();
		else if (choice == 2)
			exit();
		else
			System.exit(0);
	}
}
