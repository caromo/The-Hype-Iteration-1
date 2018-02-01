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
    private Image img;
//    private class position {
//        int x = getX();
//        int y = getY();
//    }

    public int  getX(){ //get x coordinate
        return x;
    }
    public int getY(){
        return y;
    } //get y coordinate

    public Image getDecal()
    {
        return img;
    }

//    public getPosition(){
//        return position;
//    }
}
