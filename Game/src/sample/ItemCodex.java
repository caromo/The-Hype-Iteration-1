package sample;

import java.util.HashMap;

public class ItemCodex {
    private Player player;
    private HashMap<Integer,Integer> itemMap;

    ItemCodex(Player p) {
        player = p;
        itemMap.put(1,0);
        itemMap.put(2,0);
        itemMap.put(3,0);
        itemMap.put(4,5);
        itemMap.put(5,20);
        itemMap.put(6,50);
        itemMap.put(7,100);
        itemMap.put(8,250);
    }

    public void useItem(Item i){
        int itID = i.getID();
        if (itID <= 3 && itID > 0) {
            player.equipGear((Equipment)i);
        }
        else {
            player.heal(itemMap.get(itID));
        }
    }
}
