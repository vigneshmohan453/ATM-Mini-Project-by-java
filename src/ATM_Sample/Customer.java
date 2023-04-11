package ATM_Sample;

import java.sql.*;

public class Customer extends AtmTesingServer {
	static String name = null;
	static String pass = null;

	public static void customer() {
		try {
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("            Welcome to Mariyamman Indian Bank             ");
			System.out.println();
			System.out.println("            Enter UserName:                               ");
			System.out.println();
			System.out.println("            Enter Pasword :                               ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("==========================================================");
			System.out.print("User name: ");
			name = sc.nextLine();
			System.out.println();
			System.out.print("Enter Password: ");
			pass = sc.nextLine();
			String qry = "Select name,password from Customer where name=? and password=?";
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == true) {
				//System.out.println("Login successfully.....");
				AtmInterface.atmMachine();
			} else {
				System.err.println("Log in failed..........");
				System.out.println();
				System.out.println();
				customer();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
