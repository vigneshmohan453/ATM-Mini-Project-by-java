package ATM_Sample;

import java.sql.*;

public class PinChange extends Customer {

	public static void pinChange() {
		try {
			System.out.println("Enter your New Password");
			String newpass = sc.nextLine();
			System.out.println("Enter your confirm Password");
			String conpass = sc.nextLine();
			if (newpass.equals(conpass)) {
				String qry = "update Customer set password=? where name=? and password=?";
				Connection con = DBConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(qry);
				pst.setString(1, newpass);
				pst.setString(2, name);
				pst.setString(3, pass);
				@SuppressWarnings("unused")
				int row = pst.executeUpdate();
				System.out.println("Password changed successfully");
				con.close();
				Errors.exit();
			} 
			else {
				System.out.println("Password Mismatch");
				pinChange();
			}
		} catch (Exception e) {

		}
	}
}
