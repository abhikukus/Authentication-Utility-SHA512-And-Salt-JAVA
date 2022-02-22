import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class addUser {
	public boolean adduser(String username, String password) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbusername = "SYSTEM";
			String dbpassword = "SYSTEM";
			Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword);
			if (conn != null) {
				System.out.println("Connected with database");
			} else {
				return false;
			}

			hashing hash = new hashing();
			String salt = hash.byteArrayToHex(hash.createSalt());
			String hex = hash.getHash(password, salt);

			String table = "USERTABLE";
			String query = "INSERT INTO " + table + " VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, salt);
			ps.setString(3, hex);
			ps.execute();
			ps.close();

			// close the connection object
			conn.close();

			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public void showTable() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbusername = "SYSTEM";
			String dbpassword = "SYSTEM";
			Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword);
			if (conn != null) {
				System.out.println("Connected with database");
			}

			// step3 create the statement object
			Statement stmt = conn.createStatement();

			String table = "USERTABLE";
			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from " + table);
			while (rs.next()) {
				System.out.print(rs.getRow() + " ");
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}

			// step5 close the connection object
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
