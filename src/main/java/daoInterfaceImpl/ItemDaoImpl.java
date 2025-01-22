package daoInterfaceImpl;

//import com.mysql.cj.xdevapi.Statement;
import daoInterface.ItemDaoInterface;
import model.Item;
import utility.connectionDB;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ItemDaoImpl extends connectionDB  implements ItemDaoInterface {
    @Override
    public List<Item> getAllItems() {
        try{
            Connection connection = connectionDB.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from item");

            List itemList=new ArrayList();
            while(rs.next()){
                Item item=new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                itemList.add(item);
            }
            connection.close();
            return itemList;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public void addItem(Item i) {
        try{
            Connection connection = connectionDB.getConnection();
           // for(Item i: itemList){
                String sqlQuery = "INSERT INTO item (name, price) Values (?,?)";
                PreparedStatement prepStmt = connection.prepareStatement(sqlQuery);
                prepStmt.setString(1, i.getName());
                prepStmt.setDouble(2, i.getPrice());
                int affectedRows = prepStmt.executeUpdate();
                System.out.println(affectedRows + " row(s) affected .");
            //}
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean updateItem(Item item, int id) {
        try{
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE item SET name=?, price=? WHERE id=?");
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if(i ==1){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return false;
    }

    @Override
    public boolean removeItemById(int id) {
        try{
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM item WHERE id=?");

            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if(i == 1){
                return true;
            }
        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }
}
