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
		
		setEquip(110, 10);
		setDescription(110, "A piece of armor that has seen many battles");
		
		setEquip(210, 10);
		setDescription(210, "A sword that has clearly seen better days");
		
		setEquip(310, 10);
		setDescription(310, "A simple Pendant");
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
