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
          service.addCustomer();
          service.updateCustomer();
          service.removeCustomerById();

          System.out.println("============================================");

        ItemService itemService = new ItemService();
          itemService.getAllItems();
          itemService.addItem();
          itemService.updateItem();
          itemService.removeItemById();
    }
}