import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class verifyUser {
	public boolean verify(String username, String password) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbusername = "SYSTEM";
			String dbpassword = "SYSTEM";
			Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword);
			if (conn != null) {
				System.out.println("Connected with database");
			} else {
				System.out.println("Connection failed");
				return false;
			}

			boolean ans = false;
			hashing hash = new hashing();
			String usersalt = "";
			String userhex = "";

			String table = "USERTABLE";
			String query = "SELECT * FROM " + table + " WHERE USERNAME=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usersalt = rs.getString("SALT");
				userhex = rs.getString("HASH");
			}

			if (usersalt != "" && userhex != "") {
				String hex = hash.getHash(password, usersalt);
				ans = hex.equals(userhex);
			}

			ps.close();
			conn.close();
			return ans;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
