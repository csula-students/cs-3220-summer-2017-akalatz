package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class OrderDAO implements DAO<Order> {

    public List<Order> list() {
        List<Order> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {

            // Get information from orders table
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders ;");
            while (rs.next()) {
                    list.add(new Order(
                       rs.getInt("order_id"), 
                        rs.getString("customer_name"),
                        rs.getString("status")
                    ));
                } 

               
            

        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }
    

    
    
    public Optional<Order> get(int id) {
        Optional<Order> toReturn = Optional.empty();
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM orders where order_id=?");
            pstmt.setInt(1, id);
          
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
               
                 Order   newOrder = new Order(rs.getInt("order_id"),
                                            rs.getString("customer_name"),
                                            rs.getString("status")
                                            );
                

                toReturn = Optional.of(newOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
    
    
    
    public void add(Order order) {

        Database db = new Database();
        try (Connection c = db.connection()) {

            // insert into ORDERS table
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (order_id, customer_name, status) VALUES (?, ?, ?)");
            pstmt.setInt(1, order.getId());
            pstmt.setString(2, order.getCustomerName());
            pstmt.setString(3, order.getStatus());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public void update(Order order) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE orders SET order_id = ?, customer_name = ?, status = ? WHERE order_id = ?");
            pstmt.setInt(1, order.getId());
            pstmt.setString(2, order.getCustomerName());
            pstmt.setString(3, order.getStatus());
            pstmt.setInt(4, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders WHERE orders.order_id = ? ");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}