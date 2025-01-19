package daoInterface;

import model.Customer;

import java.util.List;

public interface CustomerDaoInterface {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void saveCustomer(List<Customer> customerList);
    boolean updateCustomer(Customer customer,int id);
    boolean deleteCustomer(int id);


}
