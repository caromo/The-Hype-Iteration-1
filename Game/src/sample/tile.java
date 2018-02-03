package sample;
import javafx.scene.layout.TilePane;


public class tile extends GameObject{
    private boolean passable;
    protected Holding holding;
    private TilePane tile;
    protected int displayID;
    private float x, y, wid, hei;
    private int Scenario;
    protected Occupy occupy;

    public tile(tileObject objType) {
        holding = new Holding(this, objType);
    }

    public boolean getPassable(){
        return passable;
    }

    public int getdisplayID()
    {
        return super.getdisplayID();
    }

    //Performs the action associated with the tileObject
    public void applyEffect() {
        if(holding == null) {//Empty tile

        }
        int scenario = holding.object.getScenario();
        if(scenario == 0)  {//Area effect

        } else if(scenario == 1) {//Item
            ((Item) holding.object).giveItem();
        }
    }


//apply effect


}
