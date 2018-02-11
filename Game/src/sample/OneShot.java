package sample;

abstract class OneShot extends Item {

    private int OneShotID;

    public OneShot(int ItemID, int OneShotID) {
        super(4,ItemID);
        this.OneShotID = OneShotID;
    }

    public int getEquipmentID() {
        return OneShotID;
    }

    public void setEquipmentID(int equipmentID) {
        OneShotID = OneShotID;
    }

    public int getOneShotID() {
        return OneShotID;
    }

    public abstract boolean active();
    public abstract void setAmount(int x);//sets the amount of effect
    public abstract void setDur(int x);//sets how long the effect lasts

    public abstract int supplyBenefit();
}
