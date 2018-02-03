package sample;

public class Player extends GameObject {
    private int Health;
    private int Experince;
    private Inventory inventory;
    private position pos;
    protected Occupy occupy;
    public Player(int health, int experince){
        setHealth(health);
        setExperince(experince);
    }

    public int getHealth() {
        return Health;
    }

    public int getExperince(){
        return Experince;
    }

    public void setHealth(int health) {
        this.Health = health;
    }

    public void setExperince(int experince) {
        this.Experince = experince;
    }

    public Inventory getInventory(){
        return inventory;
    }
    public GameObject.position getPosition()
    {
        return super.getPosition();
    }

    public void setPosition(int x, int y) //for testing purposing only
    {
        super.setPos(x,y);
    }
    public void changePosition(position pos, int x, int y)
    {
        pos.x = pos.x + x;
        pos.y = pos.y + y;
    }



}
