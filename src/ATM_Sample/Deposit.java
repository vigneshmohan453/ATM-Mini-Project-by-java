package ATM_Sample;

import java.sql.*;

public class Deposit extends Customer {
	public static void deposit() {
		try {
			String qry = "Select Balance from Customer where name=? and password=?";
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Double bal = rs.getDouble(1);
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("                 Mariyamman Indian Bank                    ");
			System.out.println();
			System.out.println("              Enter money to be deposited:=                 ");
			System.out.println();
			System.out.println("==========================================================");
			
			//System.out.println("Enter amount to Deposit...");
			int num = sc.nextInt();

			// System.out.println(bal);
			if (num > 0 && num % 100 == 0) {
				double newbal = bal + num;

				String qry1 = "update Customer set Balance=? where name=? and password=?";
				pst = con.prepareStatement(qry1);
				pst.setDouble(1, newbal);
				pst.setString(2, name);
				pst.setString(3, pass);
				@SuppressWarnings("unused")
				int row = pst.executeUpdate();
				System.out.println("Deposit successfully");
				System.out.println("==========================================================");
				System.out.println();
				System.out.println("                 Mariyamman Indian Bank                    ");
				System.out.println();
				System.out.println("          Your Money has been successfully depsited      ");
				System.out.println();
				System.out.println("              Your Account Balance is:=" + newbal);
				System.out.println();
				System.out.println("             If you want to continue this operation       ");
				System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
				System.out.println();
				System.out.println("==========================================================");
			} else if (num <= 0) {
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
				Errors.exit();
			} else {
				System.out.println("Invalid Amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
