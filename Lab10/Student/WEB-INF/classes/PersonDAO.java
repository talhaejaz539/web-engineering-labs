import java.sql.*;
import java.util.ArrayList;

public class PersonDAO {

	public int addPerson(String rollNo, String studentName, Double cgpa) {
		int rs = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/university";
			Connection con = DriverManager.getConnection(url, "root", "root");

			String sql = "INSERT INTO studentinfo (rollNo, studentName, cgpa) VALUES(?,?,?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, rollNo);
			pStmt.setString(2, studentName);
			pStmt.setDouble(3, cgpa);

			rs = pStmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return rs;
	}

	// method searchPerson
	public PersonInfo searchPerson(String rollNo, String studentName) {
		PersonInfo person = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/university";
			Connection con = DriverManager.getConnection(url, "root", "root");

			String sql = "SELECT * FROM studentinfo WHERE rollNo = ? AND studentName = ?";
			System.out.println(sql);
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, rollNo);
			pStmt.setString(2, studentName);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String roll = rs.getString("rollNo");
				String name = rs.getString("studentName");
				double cgpa = rs.getDouble("cgpa");
				person = new PersonInfo(roll, name, cgpa);
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	public ArrayList<PersonInfo> data() {

		ArrayList<PersonInfo> stlist = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/university";
			Connection con = DriverManager.getConnection(url, "root", "root");

			Statement st = con.createStatement();
			String sql = "SELECT * FROM studentinfo";
			System.out.println(sql);
			ResultSet rst = st.executeQuery(sql);

			while (rst.next()) {
				String rollNo = rst.getString("rollNo");
				String name = rst.getString("studentName");
				double cgpa = rst.getDouble("cgpa");
				PersonInfo person = new PersonInfo(rollNo, name, cgpa);
				stlist.add(person);

			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return stlist;

	}

}