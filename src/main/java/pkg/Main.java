package pkg;
// for use JDBC fecturies
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// for reading sql file
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		final String
			// https://db4free.net/phpMyAdmin/ basta registrarsi
			protocol = /* */ "h2:./",	/*	"h2:mem:./",	/* * / "mysql://db4free.net:3306", /* */
			username = "birg81",
			password = "itirenatoelia",
			db_name = protocol.contains("h2") ? "PeopleDB" : "teaching_repo";
		String sql = "SELECT * FROM Person ORDER BY firstname ASC LIMIT 5;";
		if(protocol.contains("h2")) {
			try {
				// read sql file and transfert sql command into String data
				sql = String.join("\n",Files.readAllLines(Paths.get(".//%s.sql".formatted(db_name)), StandardCharsets.UTF_8));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			if(protocol.contains("h2")) org.h2.Driver.load();		// Start H2DB Server
			con = DriverManager.getConnection(
				"jdbc:%s/%s".formatted(protocol, db_name),
				username, password
			);
			st = con.createStatement();
			for(String q: sql.split(";")) {
				q = q.strip();
				if(!q.toLowerCase().contains("select") && protocol.contains("h2")) 
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
			if(protocol.contains("h2")) org.h2.Driver.unload();		// Stop H2DB Server
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
