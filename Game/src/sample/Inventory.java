package sample;

public class Inventory {
    private Item[] items;
    private int maxInventorySize;

    public Inventory() {
        maxInventorySize = 100;
        items = new Item[maxInventorySize];

    }

    public void addItem(int id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = new Item(id);
                return;
            }
        }
    }

    public void printInventory() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(items[i].getID());
            }
        }
    }
}