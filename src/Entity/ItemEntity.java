package Entity;

import Control.ItemControl;

public class ItemEntity {
    int itemId;
    String name;
    String desc;
    int userID;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public ItemEntity()
    {

    }

    public ItemEntity(String name, String desc,int userID)
    {
        ItemControl item = new ItemControl();
        item.addItem(name, desc,userID);
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
