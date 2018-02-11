package sample;

import java.util.HashMap;

public class EquipmentCodex {
	private HashMap<Integer, Integer> eCodex;
	private HashMap<Integer,String> nameMap;
	private HashMap<Integer, String> descriptionCodex;
	
	public EquipmentCodex() {
		eCodex = new HashMap(10, 2);
		descriptionCodex = new HashMap(10,2);
		nameMap = new HashMap<>();
		
		setEquip(100, 5);
		setDescription(100, "Some old rags");
		nameMap.put(100,"Old Dregs");
		
		setEquip(200, 5);
		setDescription(200, "Your bare fists");
		nameMap.put(200,"Bare Fists");
		
		setEquip(300, 10);
		setDescription(300, "A mysterious ring");
		nameMap.put(300,"Old Trinket");
		
		setEquip(110, 10);
		setDescription(110, "A piece of armor that has seen many battles");
		nameMap.put(110,"Worn Armor");
		
		setEquip(210, 10);
		setDescription(210, "A sword that has clearly seen better days");
		nameMap.put(210,"Worn Sword");
		
		setEquip(310, 10);
		setDescription(310, "A simple Pendant");
		nameMap.put(310,"Pendent");
	}
	
	public int getEquipment(int key) {
		return eCodex.get(key);	
	}

	public String getName(int EQID) { return nameMap.get(EQID); }
	
	public String getDescription(int key) {
		return descriptionCodex.get(key);
	}
	
	public void setEquip(int key, int value) {
		eCodex.put(key, value);
	}
	
	public void setDescription(int key, String value) {
		descriptionCodex.put(key, value);
	}

}
