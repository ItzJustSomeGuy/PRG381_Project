package DataAccessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import BusinessLogicLayer.Bookings;
import BusinessLogicLayer.Food;

public class DBConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.sqlserver.jdbc.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:3306/CateringDB","root","");
        CallableStatement cstmt = con.prepareCall("{call dbo.spGetFood()}");) {
            List<Food> foods = new LinkedList<Food>();
            cstmt.setInt(1, 0);
            ResultSet rs = cstmt.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                Food food = new Food(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getDouble(3));
            }
            
            for (Food food : foods) {
                System.out.println(food.getMealChoice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    
}
