package sample;

public class Item extends tileObject{
    private int itemID;
    public int ScenarioID;

    public Item(int SN, int id) {
        super(SN);
        itemID = id;
    }

    //Places this item in the player's inventory
    public void giveItem() {
        //Accesses the player inventory through holding->tile->occupy->getInventory.addItem()

        holding.tile.occupy.player.getInventory().addItem(this);
        holding.remove();
    }

    public void useItem() {

    }

    public int getID() {
        return itemID;
    }

    public void printID() {
        System.out.println(itemID);
    }

    public void use() {}

    @Override
    public int getEffect() {
        return itemID;
    }
}
