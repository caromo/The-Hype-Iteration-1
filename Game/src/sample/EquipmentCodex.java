package sample;

import java.util.HashMap;

public class EquipmentCodex {
	private HashMap<Integer, Integer> eCodex;
	private HashMap<Integer, String> descriptionCodex;
	
	public EquipmentCodex() {
		eCodex = new HashMap(10, 2);
		descriptionCodex = new HashMap(10,2);
		
		setEquip(100, 5);
		setDescription(100, "Some old rags");
		
		setEquip(200, 5);
		setDescription(200, "Yor bare fists");
		
		setEquip(300, 10);
		setDescription(300, "A mysterious ring");
		
		setEquip(101, 10);
		setDescription(101, "An old piece of armor");
		
		setEquip(201, 10);
		setDescription(201, "A rusty Sword");
		
		setEquip(301, 15);
		setDescription(301, "A ring from an old Witch");
	}
	
	public int getEquipment(int key) {
		return eCodex.get(key);	
	}
	
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
