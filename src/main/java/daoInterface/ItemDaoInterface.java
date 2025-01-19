package daoInterface;

import model.Item;

import java.util.List;

public interface ItemDaoInterface {
    List<Item> getAllItems();
    void saveItem(List<Item> itemList);
    boolean updateItem(Item item,int id);
    boolean deleteItem(int id);
}
