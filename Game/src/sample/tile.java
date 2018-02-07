package sample;
import javafx.scene.layout.TilePane;
import java.awt.Point;


public class tile extends GameObject{
    private boolean passable;
    protected Holding holding;
    protected int displayID;
    private float x, y, wid, hei;
    private int Scenario;
    protected Occupy occupy;
    protected Point pos;

    public Point getPosition()
    {
        return pos;
    }

    public tile(tileObject objType) {
        holding = new Holding(this, objType);
       if(getPosition() == occupy.player.getPosition())
       {
           occupy = new Occupy(occupy.player, this);
       }

    }

    public boolean getPassable(){
        return passable;
    }

    public int getdisplayID()
    {
        return super.getdisplayID();
    }

    public int getScenario() {
        return Scenario;
    }

    //Performs the action associated with the tileObject
    public void applyEffect() {
        if(holding == null) {//Empty tile

        }
        int scenario = holding.object.getScenario();
        if(scenario == 0 && occupy.tile == this)  {//Area effect
            for(int i = 0; i < 10; i++) {
                occupy.player.setHealth(occupy.player.getHealth() - 1);
                System.out.format("%d", occupy.player.getHealth());
            }
        } else if(scenario == 1) {//Item
            ((Item) holding.object).giveItem();
        }
    }
    public void setPosition(int x, int y)
    {
        super.setPos(x,y);
    }


//apply effect


}
