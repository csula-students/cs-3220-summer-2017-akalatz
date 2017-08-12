package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class InventoryDAO implements DAO<FoodItem> {
    public List<FoodItem> list() {
        List<FoodItem> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FoodItem");
            while (rs.next()) {
                list.add(new FoodItem(
                    rs.getInt("id"),
                    rs.getString("foodName"),
                    rs.getString("description"),
                    rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodItem> get(int id) {
        Optional<FoodItem> returnvalue = Optional.empty();
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM FoodItem WHERE FoodItem.id = ? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                FoodItem editfood = new FoodItem(rs.getInt("id"),
                                                    rs.getString("foodName"),
                                                    rs.getString("description"),
                                                    rs.getDouble("price"));
                returnvalue = Optional.of(editfood);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnvalue;
    }
    public void add(FoodItem entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO FoodItem (id, foodName, description, price) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, entry.getId());
            pstmt.setString(2, entry.getFoodName());
            pstmt.setString(3, entry.getDescription());
            pstmt.setFloat(4, (float) entry.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FoodItem entry) {

    	Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE FoodItem SET id = ?, foodName = ?, description = ?, price = ? WHERE id = ?");
            pstmt.setInt(1, entry.getId());
            pstmt.setString(2, entry.getFoodName());
            pstmt.setString(3, entry.getDescription());
            pstmt.setDouble(4, entry.getPrice());
            pstmt.setInt(5, entry.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void delete(int id) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM FoodItem WHERE FoodItem.id = ? ");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}