package sample;

public abstract class Equipment extends Item {

    private int EquipmentID;

    // NOTE: ARMOR Equipment will start with ID 100, WEAPON Equipment will start with ID 200, and RING Equipment will start with ID 300
    // (eg. A sword's ID would be 201, a whip's ID would be 202, etc.)
    public Equipment(int ItemID, int equipmentID) {
        super(4,ItemID);
        super.setOneShot(false);
        EquipmentID = equipmentID;
    }

    public int getEquipmentID() {
        return EquipmentID;
    }

    public abstract int applyEffect();

    public abstract int supplyBenefit();
}
