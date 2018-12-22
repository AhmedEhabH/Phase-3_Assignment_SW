package Control;

import Entity.ItemEntity;
import static DB.ItemDB.items;

import java.util.Scanner;

public class ItemControl {


    public boolean addItem(String itemName, String description,int userId)
    {
        try {
            ItemEntity item = new ItemEntity();
            item.setName(itemName);
            item.setDesc(description);
            item.setItemId(items.size());
            item.setUserID(userId);
            items.add(item);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyItem(int itemID)
    {
        if(itemID >= items.size()) return false;
        try {
            ItemEntity item = items.get(itemID);
            System.out.println("Item Description");
            System.out.println(item.getDesc());
            System.out.println("======================");
            System.out.println("Enter new Description");
            Scanner scanner = new Scanner(System.in);
            item.setDesc(scanner.next());
            scanner.close();
            items.add(itemID, item);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteItem(int itemID)
    {
        if(itemID >= items.size()) return false;
        try {
            items.remove(itemID);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}