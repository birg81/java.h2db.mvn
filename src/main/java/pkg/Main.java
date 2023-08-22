package pkg;
// for reading sql file
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
// for use JDBC fecturies
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		final String
			username = "admin",
			password = "12345",
			db_name = "PeopleDB";
		String sql = "";
		try {
			// read sql file and transfert sql command into String data
			sql = String.join("\n", Files.readAllLines(Paths.get(".//%s.sql".formatted(db_name)), StandardCharsets.UTF_8));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// Start H2DB Server
			org.h2.Driver.load();
			con = DriverManager.getConnection("jdbc:h2:.//%s".formatted(db_name), username, password);
			st = con.createStatement();
			for(String q: sql.split(";")) {
				q = q.strip();
				if(!q.toLowerCase().contains("select")) 
					try {
						st.execute(q);
						con.commit();
					} catch (Exception e) {
						System.err.printf(
							"""
							ERRORE 
							---- QUERY: -------------
							%s...
							---- (ABORTED QUERY) ----
							""",
							// print a digest query message
							q.substring(0, 22)
						);
					}
				else
					rs = st.executeQuery(q);
			}
			System.out.printf(
				"\n%2s  %10s %-10s %2s\n",
				"ID", "FIRSTNAME", "LASTNAME", "AGE"
			);
			while (rs.next())
				System.out.printf(
					"%2d. %10s %-10s %2d\n",
					rs.getInt("id"),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getInt("age")
				);
			st.close();
			rs.close();
			con.close();
			// close H2DB Server
			org.h2.Driver.unload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
