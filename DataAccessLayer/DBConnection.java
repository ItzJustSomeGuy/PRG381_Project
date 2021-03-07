package DataAccessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:3306/EmployeeDB","root","");
        CallableStatement cstmt = con.prepareCall("{call dbo.uspGetEmployeeManagers(?)}");) {

            cstmt.setInt(1, 50);
            ResultSet rs = cstmt.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                //Add to a list
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    
}
