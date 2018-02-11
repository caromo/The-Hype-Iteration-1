package sample;
import javafx.application.Application;
import java.awt.Point;


public abstract class GameObject {
    protected static int displayID;
    public abstract Point getPosition();

    public int getdisplayID()
    {
        return displayID;
    } //get decal
}
