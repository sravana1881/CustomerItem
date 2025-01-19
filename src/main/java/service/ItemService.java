package service;

import daoInterface.ItemDaoInterface;
import daoInterfaceImpl.ItemDaoImpl;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemService {
    private final ItemDaoInterface itemDao;
    Scanner scanner=new Scanner(System.in);

    public ItemService() {
        this.itemDao = new ItemDaoImpl();
    }
    public void getAllItems() {
        List<Item> items = itemDao.getAllItems();
        System.out.println("All Items");
        for (Item item : items) {
            System.out.println("Item Id: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice());
        }
    }

    public void saveItem() {
        ArrayList<Item> items = new ArrayList<>();
        System.out.println("Enter the number of items you want to save: ");
        int numberOfItems = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfItems; i++) {
            Item item = new Item();
            System.out.println("Enter the name of the item you want to save: ");
            item.setName(scanner.nextLine());
            System.out.println("Enter the price of the item you want to save: ");
            item.setPrice(Double.parseDouble(scanner.nextLine()));
            items.add(item);
        }
        itemDao.saveItem(items);
        System.out.println("Item added and  Saved successfully");
    }
     public void updateItem() {
        Item updateItem = new Item();
        System.out.println("Enter the id of the item you want to update: ");
        int itemId=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the name of the item you want to update: ");
        updateItem.setName(scanner.nextLine());
        System.out.println("Enter the price of the item you want to update: ");
        updateItem.setPrice(Double.parseDouble(scanner.nextLine()));
        itemDao.updateItem(updateItem, itemId);
        System.out.println("Item updated successfully");
     }

     public void deleteItem() {
         System.out.println("Enter the Item Id of the item to delete. ");
         int ItemId = Integer.parseInt(scanner.nextLine());
         itemDao.deleteItem(ItemId);
         System.out.println("Item deleted successfully.");
     }
}
