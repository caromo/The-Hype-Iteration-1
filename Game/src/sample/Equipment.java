package sample;

public abstract class Equipment extends Item {

    private int EquipmentID;

    // NOTE: ARMOR Equipment will start with ID 100, WEAPON Equipment will start with ID 200, and RING Equipment will start with ID 300
    // (eg. A sword's ID would be 201, a whip's ID would be 202, etc.)
    public Equipment(int ItemID, int equipmentID) {
        super(ItemID);
        EquipmentID = equipmentID;
    }

    public int getEquipmentID() {
        return EquipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        EquipmentID = equipmentID;
    }

    public abstract int supplyBenefit();
}
