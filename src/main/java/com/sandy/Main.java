package com.sandy;

import service.CustomerService;
import service.ItemService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
          service.getAllCustomers();
          service.getCustomerById();
          service.saveCustomer();
          service.updateCustomer();
          service.deleteCustomer();

        ItemService itemService = new ItemService();
          itemService.getAllItems();
          itemService.saveItem();
          itemService.updateItem();
          itemService.deleteItem();
    }
}