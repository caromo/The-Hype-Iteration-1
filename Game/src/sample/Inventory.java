package sample;

public class Inventory {
    private Item[] items;
    private int maxInventorySize;
    private int numOfItems;
    public Inventory() {
        maxInventorySize = 100;
        items = new Item[maxInventorySize];
        numOfItems = 0;
    }

    public void addItem(int id) {
        for(int i = 0; i < items.length; i++) {
            if(items[i] == null) {
                items[i] = new Item(id);
                numOfItems++;
                return;
            }
        }
    }

    public void printInventory() {
        for(int i = 0; i < items.length; i++) {
            if(items[i] != null) {
                System.out.println(items[i].getID());
            }
        }
    }

    public Item getItem(int ind) {
        if(ind < numOfItems) {
            return items[ind];
        }
        return null;
    }

    public int getNumOfItems() {
        return numOfItems;
    }
}
