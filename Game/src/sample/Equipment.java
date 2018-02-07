package sample;

public class Equipment extends Item {
    private Weapon wea;
    private Armor arm;
    private ring  rin;
    protected int type;
    protected int isWeapon;
    protected int isArmor;
    protected int isRing;
    protected Item[] storage;
    protected Weapon[] Warr;
    protected Armor[] Aarr;
    protected ring[] Rarr;

    public Equipment(int id) {
        super(id);
    }
    public void classify() {

        int W, A, R;
        W = A = R = 0;
        for(int i = 0; i < storage.length; i++)
        {
            if(getType() == isWeapon)
            {
                Warr[W++] = (Weapon) storage[i];
            }
            else if(getType() == isArmor)
            {
                Aarr[A++] = (Armor) storage[i];
            }
            else if(getType() == isRing)
            {
                Rarr[R++] = (ring) storage[i];
            }
        }


    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void equipWeapon(int pos){
        this.wea = Warr[pos];
    }
    public void equipArmor(int pos){
        this.arm = Aarr[pos];
    }
    public void equipRing(int pos){
        this.rin = Rarr[pos];
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
