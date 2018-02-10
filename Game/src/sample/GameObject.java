package sample;
import javafx.application.Application;
import java.awt.Point;


public abstract class GameObject {
    private int x; //x coordinate location on the map
    private int y; //y coordinate location on the map
    protected static int displayID;
    public abstract Point getPosition();


    public int getdisplayID()
    {
        return displayID;
    } //get decal




}
