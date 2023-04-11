package ATM_Sample;

public class Errors extends Customer  {
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
			AtmInterface.atmMachine();
		else if (choice == 2)
			exit();
		else
			AtmInterface.atmMachine();
	}
}
