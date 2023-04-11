package ATM_Sample;

import java.sql.*;

public class UserDetails extends Customer {
	public static void userDetails() {
		try {
			String qry = "Select * from Customer where name=? and password=?";
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			rs.next();
//			System.out.println("Account Number : " + rs.getString(2));
//			System.out.println("Name : " + rs.getString(3));
//			System.out.println("Password : " + rs.getString(4));
//			System.out.println("Account Balance : " + rs.getString(5));
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("                 Mariyamman Indian Bank                    ");
			System.out.println();
			System.out.println("               Hello " + rs.getString(3) + " welcome		      ");
			System.out.println();
			System.out.println("               Acc Num : " + rs.getString(2));
			System.out.println("               Password: " + rs.getString(4));
			System.out.println("               Balance : " + "Rs."+rs.getString(5));
			System.out.println();
			System.out.println("             If you want to continue this operation       ");
			System.out.println("                 ==> (1) Yes   ==> (2) No                 ");
			System.out.println();
			System.out.println("==========================================================");

			int choice = sc.nextInt();
			if (choice == 1)
				AtmInterface.atmMachine();
			else if (choice == 2)
				Errors.exit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
