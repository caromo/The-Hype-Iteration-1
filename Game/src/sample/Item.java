package sample;

public class Item extends tileObject{
    private int itemID;

    public Item(int id) {
        super(4);
        itemID = id;

    }


    public void printID() {
        System.out.println(itemID);
    }

    //Places this item in the player's inventory
    public void giveItem() {
        //Accesses the player inventory through holding->tile->occupy->getInventory.addItem()

        holding.tile.occupy.player.getInventory().addItem(itemID);
        holding.remove();
    }



    public int getID() {
        return itemID;
    }
}
