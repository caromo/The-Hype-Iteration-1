package sample;
import javafx.scene.layout.TilePane;


public class tile extends GameObject{
    private boolean passable;
    private Holding contents;
    private TilePane tile;
    protected int displayID;
    public void createTile(){
        this.tile = new TilePane();
    }
    public boolean getPassable(){
        return passable;
    }

    public int getdisplayID()
    {
        return super.getdisplayID();
    }




}
