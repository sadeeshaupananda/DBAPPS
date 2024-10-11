import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Driver;

public class DBAPP {

    public static void main(String[] args) {
        try {

            String qry = "SELECT * FROM student";
            Connection con = DriverManager.getConnection("jdbc:mysql:// localhost/mca_school", "root", "1234");
            Statement stm = con.createStatement();
            ResultSet rslt = stm.executeQuery(qry);

            // rslt.next();

            // System.out.println(rslt.getInt("id"));
            // System.out.println(rslt.getString("name"));
            // System.out.println(rslt.getString("nic"));

            while (rslt.next()) {

                int id = rslt.getInt("id");
                String name = rslt.getString("name");
                String nic = rslt.getString("nic");

                System.out.println(id + "\t" + name + "\t" + nic);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("can't connect as" + e.getMessage());
        }

    }
}
