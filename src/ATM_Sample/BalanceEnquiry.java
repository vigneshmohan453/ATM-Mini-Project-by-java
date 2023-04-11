package ATM_Sample;

import java.sql.*;

public class BalanceEnquiry extends Customer {
	public static void balanceEnquiry() {
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
			System.out.println("            Your Account Balance is:= " + bal);
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println();
			System.out.println("==========================================================");
			int choice = sc.nextInt();
			if (choice == 2)
				Errors.exit();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
