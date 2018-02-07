package sample;

public class Weapon extends Equipment {
    protected boolean isBow;
    protected boolean isSword;
    protected Sword[] sw;
    protected Bow[] bw;
    private Weapon[] weapons;


    public Weapon(int id) {
        super(id);
    }
    public void weapType()
    {
        int S, B;
        S = B = 0;
        for(int i = 0; i < weapons.length; i++)
        if(isBow)
        {
            this.bw[B++] = (Bow) weapons[i];
        }
        else if(isSword)
        {
            this.sw[S++] = (Sword) weapons[i];
        }
    }
    public void updateWeapons()
    {
        this.weapons = (Weapon[])super.Warr;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }
}
