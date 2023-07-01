import java.sql.*;
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Linux";
        Connection con = DriverManager.getConnection(url, "root", "Admin@123");
        if(con == null) {
            System.out.println("Connection is not established");
            System.exit(1);
        }
        String query = "select * from Sample";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
        }
        con.close();
    }
}