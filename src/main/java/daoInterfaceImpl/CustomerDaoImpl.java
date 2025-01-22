package daoInterfaceImpl;

import daoInterface.CustomerDaoInterface;
import model.Customer;
import utility.connectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerDaoImpl extends connectionDB implements CustomerDaoInterface {

    @Override
    public List<Customer> getAllCustomers() {
        try {
            Connection connection = connectionDB.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            List customerList = new ArrayList();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setEmail(rs.getString("email"));
                c.setFname(rs.getString("fname"));
                c.setLname(rs.getString("lname"));
                customerList.add(c);
            }
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from customer where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int customerid = (rs.getInt("id"));
                String email = (rs.getString("email"));
                String firstName = (rs.getString("fname"));
                String lastName = (rs.getString("lname"));
                customer = new Customer(customerid, email, firstName, lastName);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer c) {
        try {
            Connection connection = connectionDB.getConnection();
            //for (Customer customer : c) {
                String sqlQuery = "INSERT INTO customer (email, fname,lname) Values (?,?,?)";
                PreparedStatement prepStmt = connection.prepareStatement(sqlQuery);
                prepStmt.setString(1, c.getEmail());
                prepStmt.setString(2, c.getFname());
                prepStmt.setString(3, c.getLname());
                int affectedRows = prepStmt.executeUpdate();
                System.out.println(affectedRows + " row(s) affected .");
            //}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateCustomer(Customer customer, int id) {
        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE customer SET email=?, fname=? ,lname=? WHERE id=?");
            ps.setString(1, customer.getEmail());
            ps.setString(2, customer.getFname());
            ps.setString(3, customer.getLname());
            ps.setInt(4, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return false;
    }

    @Override
    public boolean removeCustomerById(int id) {
        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM customer WHERE id=?");

            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }
}
