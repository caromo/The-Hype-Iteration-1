package sample;

public class Item extends tileObject{
    private int itemID;
    private int equip;

    public Item(int id) {
        super(1);
        itemID = id;

    }

    public void isEquipment() {
        Item[] arr = holding.tile.occupy.player.getInventory().getItems();
        Item[] equipable = new Item[];
        Equipment eq = new Equipment(getID());
        int W = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(getID() == equip)
            {
                equipable[W++] = arr[i];
            }

        }

        eq.storage = equipable;

    }

    //Places this item in the player's inventory
    public void giveItem() {
        //Accesses the player inventory through holding->tile->occupy->getInventory.addItem()

        holding.tile.occupy.player.getInventory().addItem(getID());
        holding.remove();
    }

    public void useItem() {

    }

    public int getID() {
        return itemID;
    }

    public void use() {}

}
