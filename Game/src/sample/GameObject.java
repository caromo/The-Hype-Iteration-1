package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.Point;


public abstract class GameObject {
    public Point position;
    protected static int displayID;

    public Point getPosition(){
        return position;
    }

    public void setPos(int x, int y) {
        this.position.setLocation(x,y);
    }

    public int getdisplayID()
    {
        return displayID;
    } //get decal



}
