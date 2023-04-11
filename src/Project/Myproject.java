package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Myproject {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql://localhost:3306/vignesh";
		String user = "root";
		String pwd = "tiger";

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			String qry = "Select * from users";
			ResultSet rs = stmt.executeQuery(qry);
			while (rs.next()) {
				System.out.println
				(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3)+"\t"+rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
