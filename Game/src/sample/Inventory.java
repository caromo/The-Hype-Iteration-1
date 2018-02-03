/*
Member Responsible: Daniel
Reason for existence: To hold the player’s items and allow the player to manage and interact with those items.
 */
import java.util.ArrayList;
import java.util.Comparator;

package sample;

public class Inventory {
    private final int MAX_SIZE = 100;
    private ArrayList<Item> items = new ArrayList<Item>(MAX_SIZE);
    public Inventory() {};

    // Made to work with default sort with Object type Item
    private class CustomCompare implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            int result = 0;
            if (a.getID() == b.getID()) return 0;
            else if (a.getID() < b.getID()) return 1;
            else if (a.getID() > b.getID()) return -1;
        }
    }

    // Operation addItem(itemID:int)
    // Adds item to inventory based off it's ID
    public void addItem(int id) {
        if (items.size() == MAX_SIZE) {
            // Notify the user that inventory is full
            return;
        }
        else {
            items.add(new Item(id));
            return;
        }
    }

    // Operation getItem()
    // Returns an array of items for view to iterrate through
    public Items[] getItems() {
        Item[] arr = items.toArray();
        return arr;
    }

    // Operation tossItem(index:int)
    // Removes item to inventory based off it's index in the array
    public static void tossItem(int index) {
        if (index >= items.size() || index < 0) {
            // Internal notice that item does not exist
        }
        else {
            items.remove(index);
        }
        return;
    }

    // Operation sort()
    // Sorts the arrayList
    public static void sort() {
        items.sort(CustomCompare);
        return;
    }

    // Operation useItem(itemID:int)
    // Calls use on item based off it's index in the arraylist and indicates and removs it from invntory
    public static void useItem(int index) {
        if (index >= items.size() || index < 0) {
            // Internal notice that item does not exist
        }
        else {
            items.get(index).useItem();
            items.remove(index);
        }
        return;
    }

    public static void printInventory() {
        for(int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i).getID());
            }
    }
}
