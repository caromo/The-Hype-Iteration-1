package sample;

/*
Member Responsible: Daniel
Reason for existence: To hold the player’s items and allow the player to manage and interact with those items.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private final int MAX_SIZE = 100;
    private ArrayList<Item> items = new ArrayList<>(MAX_SIZE);
    public Inventory() {}

    private int compareID(Item a, Item b) {
        if (a.getID() < b.getID()) return 1;
        else if (a.getID() > b.getID()) return -1;
        else return 0;
    }

    // Operation addItem(itemID:int)
    // Adds item to inventory based off it's ID
    public void addItembyID(int id) {
        if (items.size() == MAX_SIZE) {
            // Notify the user that inventory is full
            return;
        }
        else {
            items.add(new Item(4,id));
            return;
        }
    }

    public void addItem(Item i) {
        if (items.size() == MAX_SIZE) {
            // Notify the user that inventory is full
            return;
        }
        else {
            items.add(i);
            return;
        }
    }

    // Operation getItem()
    // Returns an array of items for view to iterate through
    public Item[] getItems() {
        Item[] arr = {};
        items.toArray(arr);
        return arr;
    }

    public Item getItem(int ind) {
        if(ind < items.size()) {
            return items.get(ind);
        }
        return null;
    }

    public int getNumOfItems() {
        return items.size();
    }


    // Operation tossItem(index:int)
    // Removes item to inventory based off it's index in the array
    public void tossItem(int index) {
        if (index >= items.size() || index < 0) {
            // Internal notice that item does not exist
        }
        else { items.remove(index);  }
        return;
    }

    // Operation sort()
    // Sorts the arrayList
    public void sort() {
        Collections.sort(items,this::compareID);
        return;
    }

    // Operation useItem(itemID:int)
    // Calls use on item based off it's index in the arraylist and indicates and removes it from inventory
    public void useItem(int index) {
        if (index >= items.size() || index < 0) {
            // Internal notice that item does not exist
        }
        else {
            items.get(index).useItem();
            items.remove(index);
        }
        return;
    }

    public void printInventory() {
        for(int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getID());
        }
    }
}
