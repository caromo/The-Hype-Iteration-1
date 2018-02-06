package sample;

public class Item extends tileObject{
    private int itemID;

    public Item(int id) {
        super(1);
        itemID = id;

    }

    public void classify() {
        Item[] arr = holding.tile.occupy.player.getInventory().getItems();
        Item[][] equipable = new Item[2][];
        Equipment eq = new Equipment(getID());
        int W, A, R;
        W = A = R = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(getID() == eq.isWeapon)
            {
                equipable[0][W++] = arr[i];
            }
            else if(getID() == eq.isArmor)
            {
                equipable[1][A++] = arr[i];
            }
            else if(getID() == eq.isRing)
            {
                equipable[2][R++] = arr[i];
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

}
