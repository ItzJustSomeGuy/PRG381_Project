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
import BusinessLogicLayer.Venue;
import jdk.internal.event.Event;

public class DBConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.sqlserver.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:3306/CateringDB", "root", "");
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

    public List<Food> getFood() throws ClassNotFoundException {
        Class.forName("com.sqlserver.cj.jdbc.Driver");
        List<Food> foods = new LinkedList<Food>();
        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:3306/CateringDB", "root", "");
                CallableStatement cstmt = con.prepareCall("{call dbo.spGetFood()}");) {

            cstmt.setInt(1, 0);
            ResultSet rs = cstmt.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                Food food = new Food(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getDouble(3));
                foods.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public List<Bookings> getEvent() throws ClassNotFoundException {
        Class.forName("com.sqlserver.cj.jdbc.Driver");
        List<Bookings> bookings = new LinkedList<Bookings>();
        Venue ven;
        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:3306/CateringDB", "root", "");
                CallableStatement cstmt = con.prepareCall("{call dbo.spGetEve()}");) {
            cstmt.setInt(1, 0);
            ResultSet rs = cstmt.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                Bookings booking = new Bookings(ven.equals(rs.getString(7)), rs.getString(2), rs.getString(4), rs.getDouble(3));
                bookings.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public void insertClient(String name, String surname, String phone, String Email) {
        Class.forName("com.sqlserver.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:3306/CateringDB", "root", "");
                CallableStatement cstmt = con.prepareCall("{call dbo.spInsertClient(?,?,?,?)}");) {

            cstmt.(1, 0);
            ResultSet rs = cstmt.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                Food food = new Food(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getDouble(3));
                foods.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
