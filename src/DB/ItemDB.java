package DB;

import Entity.ItemEntity;
import Entity.PostEntity;

import java.util.Vector;

public class ItemDB {
    public static Vector<ItemEntity> items = new Vector<ItemEntity>();
    public static void View()
    {
        for (ItemEntity Item : items) {
            System.out.print("Item ID: ");
            System.out.println(Item.getItemId());

            System.out.print("Item Name: ");
            System.out.println(Item.getName());

            System.out.print("Item Description: ");
            System.out.println(Item.getDesc());
        }
    }
    public static void View(int userID)
    {
        for (ItemEntity Item : items) {
            if(Item.getUserID()==userID) {
                System.out.print("Item ID: ");
                System.out.println(Item.getItemId());

                System.out.print("Item Name: ");
                System.out.println(Item.getName());

                System.out.print("Item Description: ");
                System.out.println(Item.getDesc());
            }
        }
    }

}
