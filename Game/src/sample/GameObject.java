package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public abstract class GameObject {
    private int x; //x coordinate location on the map
    private int y; //y coordinate location on the map
    protected static int displayID;
    protected class position {
        int x = getX();
        int y = getY();

        int  getX(){ //get x coordinate
        return x;
            }

        int getY(){
        return y;
        } //get y coordinate
    }
    private position pos;



    public position getPosition(){
        return pos;
    }

    public int getdisplayID()
    {
        return displayID;
    } //get decal



}
