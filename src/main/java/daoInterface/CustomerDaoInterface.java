package daoInterface;

import model.Customer;

import java.util.List;

public interface CustomerDaoInterface {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void addCustomer(Customer c);
    boolean updateCustomer(Customer customer,int id);
    boolean removeCustomerById(int id);


}
