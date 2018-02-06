package sample;

public class Equipment extends Item {
    private Weapon wea;
    private Armor arm;
    private ring  rin;
    protected int isWeapon;
    protected int isArmor;
    protected int isRing;
    protected Item[][] storage;

    public Equipment(int id) {
        super(id);
    }


    public void equipWeapon(int pos){
        this.wea = (Weapon)storage[0][pos];
    }
    public void equipArmor(int pos){
        this.arm = (Armor)storage[1][pos];
    }
    public void equipRing(int pos){
        this.rin = (ring)storage[2][pos];
    }
    public void returnWeapon(){
        this.wea = null;
    }
    public void returnArmor(){
        this.arm = null;
    }
    public void returnRing(){
        this.rin = null;
    }

    public Armor getArm() {
        return arm;
    }

    public void setArm(Armor arm) {
        this.arm = arm;
    }

    public Weapon getWea() {
        return wea;
    }

    public void setWea(Weapon wea) {
        this.wea = wea;
    }

    public ring getRin() {
        return rin;
    }

    public void setRin(ring rin) {
        this.rin = rin;
    }

}
