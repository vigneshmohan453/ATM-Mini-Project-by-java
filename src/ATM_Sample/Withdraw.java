package ATM_Sample;

import java.sql.*;

public class Withdraw extends Customer {
	public static void fastWithdraw(int num) {
		try {
			String qry = "Select Balance from Customer where name=? and password=?";
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Double bal = rs.getDouble(1);

			// System.out.println(bal);
			if (bal >= num && num > 0) {
				double newbal = bal - num;

				String qry1 = "update Customer set Balance=? where name=? and password=?";
				pst = con.prepareStatement(qry1);
				pst.setDouble(1, newbal);
				pst.setString(2, name);
				pst.setString(3, pass);
				@SuppressWarnings("unused")
				int row = pst.executeUpdate();
				System.out.println("Withdraw successfully");
				System.out.println("==========================================================");
				System.out.println();
				System.out.println("                  Mariyamman Indian Bank                  ");
				System.out.println();
				System.out.println("                Please collect your money                 ");
				System.out.println();
				System.out.println("            Your Account Balance is:= " + newbal);
				System.out.println();
				System.out.println("             If you want to continue this operation       ");
				System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
				System.out.println();
				System.out.println("==========================================================");
				int choice = sc.nextInt();
				if (choice == 2)
					Errors.exit();
			} else {
				System.out.println("Insufficient Balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void withdraw() {
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
			System.out.println("               Enter money to be withdrawn:               ");
			System.out.println();
			System.out.println("==========================================================");
			//System.out.println("Enter amount to withdraw..");
			int num = sc.nextInt();

			// System.out.println(bal);
			if (bal >= num && num > 0) {
				double newbal = bal - num;

				String qry1 = "update Customer set Balance=? where name=? and password=?";
				pst = con.prepareStatement(qry1);
				pst.setDouble(1, newbal);
				pst.setString(2, name);
				pst.setString(3, pass);
				@SuppressWarnings("unused")
				int row = pst.executeUpdate();
				System.out.println("Withdraw successfully");
				
			} else {
				System.out.println("Insufficient Balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
