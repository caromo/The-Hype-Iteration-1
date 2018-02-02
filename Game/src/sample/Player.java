package sample;

public class Player extends GameObject {
    private int Health;
    private int Experince;
    private Inventory inventory;
    private position pos;

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

    public void changePosition(position pos, int x, int y)
    {
        pos.x = pos.x + x;
        pos.y = pos.y + y;
    }



}
