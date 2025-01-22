package daoInterface;

import model.Item;

import java.util.List;

public interface ItemDaoInterface {
    List<Item> getAllItems();
    void addItem(Item i);
    boolean updateItem(Item item,int id);
    boolean removeItemById(int id);
}
