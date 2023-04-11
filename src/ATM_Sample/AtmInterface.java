package ATM_Sample;

public class AtmInterface extends AtmTesingServer {
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
				BalanceEnquiry.balanceEnquiry();
				break;
			case 2:
				PinChange.pinChange();
				break;
			case 3:
				UserDetails.userDetails();
				break;
			case 4:
				FastCash.fastCash();
				break;
			case 5:
				Withdraw.withdraw();
				break;
			case 6:
				Deposit.deposit();
				break;
			case 7:
				Errors.exit();
				break;
			}
		}
	}
}
