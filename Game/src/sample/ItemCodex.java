package sample;

import java.util.HashMap;

public class ItemCodex {
    private HashMap<Integer,Integer> itemMap;
    private HashMap<Integer,String> nameMap;

    ItemCodex() {
        itemMap = new HashMap<>();
        itemMap.put(1,0);
        itemMap.put(2,0);
        itemMap.put(3,0);
        itemMap.put(4,5);
        itemMap.put(5,20);
        itemMap.put(6,50);
        itemMap.put(7,100);
        itemMap.put(8,250);

        nameMap = new HashMap<>();
        nameMap.put(1,"Armor");
        nameMap.put(2,"Weapon");
        nameMap.put(3,"Ring");
        nameMap.put(4,"Weak Potion");
        nameMap.put(5,"Basic Potion");
        nameMap.put(6,"Hi-Potion");
        nameMap.put(7,"Mega-Potion");
        nameMap.put(8,"Liquid Gold");
    }

    public void useItem(Player player, Item i){
        int itID = i.getID();
        if (i instanceof Equipment) {
            player.equipGear((Equipment)i);
        }
        else if (i.isOneShot()){
            player.acquireItem(i);
        }
        else {
            player.heal(itemMap.get(itID));
        }
    }

    public String getName(int itemID){
        return nameMap.get(itemID);
    }
}
