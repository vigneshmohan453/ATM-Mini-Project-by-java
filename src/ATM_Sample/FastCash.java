package ATM_Sample;

public class FastCash extends Customer {
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
			Withdraw.fastWithdraw(100);
			break;
		case 2:
			Withdraw.fastWithdraw(200);
			break;
		case 3:
			Withdraw.fastWithdraw(500);
			break;
		case 4:
			Withdraw.fastWithdraw(1000);
			break;
		case 5:
			Withdraw.fastWithdraw(2000);
			break;
		case 6:
			Withdraw.fastWithdraw(5000);
			break;
		case 7:
			Withdraw.fastWithdraw(10000);
			break;
		case 8:
			Withdraw.withdraw();
			break;
		}
	}
}
