package service;

import daoInterface.CustomerDaoInterface;
import daoInterfaceImpl.CustomerDaoImpl;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
 private final CustomerDaoInterface customerDao;
    Scanner scanner = new Scanner(System.in);

    public CustomerService() {
        this.customerDao = new CustomerDaoImpl();
    }
    public void getAllCustomers() {
        List<Customer> customers = customerDao.getAllCustomers();
        System.out.println("All Customers");

        for(Customer customer: customers){
            System.out.println("Customer Number: " + customer.getId()  +
                    "Email: " + customer.getEmail()  +
                    " first name : " + customer.getFname()  +
                    " last name : " + customer.getLname());
        }

    }

public void getCustomerById() {
     //customerDao.getCustomerById(id);

    System.out.println("Enter Customer ID to get customer details: ");
    int customerId = Integer.parseInt(scanner.nextLine());
    // Call the getCustomerById method with the user input
      Customer customer = customerDao.getCustomerById(customerId);

    if (customer!= null) {
        // Do something with the customer
        System.out.println("Customer Found with Customer Number: " + customer.getId()  +
                "Email: " + customer.getEmail()  +
                " first name : " + customer.getFname()  +
                " last name : " + customer.getLname());

    } else if (customer == null) {
        System.out.println("No customer found with id: " + customerId);
    }

    //return customer;
}

public void saveCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        System.out.println("Enter number of  Customers to save customer details: ");
        int numberOfCustomers= Integer.parseInt(scanner.nextLine());
    for(int i = 0; i < numberOfCustomers; i++){
        Customer customer = new Customer();

        System.out.println("Enter  an Email for Customer " + (i + 1) + ":");
        customer.setEmail(scanner.nextLine());

        System.out.println("Enter First name for Customer " + (i +1) + ":");
        customer.setFname(scanner.nextLine());

        System.out.println("Enter Last name for Customer " + (i +1) + ":");
        customer.setLname(scanner.nextLine());

        customers.add(customer);
    }
    customerDao.saveCustomer(customers);
    System.out.println("Customers save successfully.");
}
public void updateCustomer() {
    Customer updatedCustomer = new Customer();
    System.out.println(" Enter Email of Customer to update");
    updatedCustomer.setEmail(scanner.nextLine());
    System.out.println(" Enter First Name of Customer to update");
    updatedCustomer.setFname(scanner.nextLine());
    System.out.println(" Enter Last Name of Customer to update");
    updatedCustomer.setLname(scanner.nextLine());
    System.out.println(" Enter ID of Customer to update");
    int customerId = Integer.parseInt(scanner.nextLine());
   updatedCustomer.setId(customerId);
    customerDao.updateCustomer(updatedCustomer,customerId);
}
public void deleteCustomer() {
    System.out.println("Enter the Customer Id of the customer to delete. ");
    int customerId = Integer.parseInt(scanner.nextLine());

    customerDao.deleteCustomer(customerId);
    System.out.println("Customer deleted successfully.");
}
}


