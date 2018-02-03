package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent>
{
    private View view;
    public int x, y;
    public KeyHandler(View view) {
        this.view = view;
        x = 0; y = 0;
    }
    public void handle(KeyEvent event)
    {
        switch(event.getCode()) {
            case UP:
                view.moveCameraUp();
                break;
            case RIGHT:
                view.moveCameraRight();
                break;
            case DOWN:
                view.moveCameraDown();
                break;
            case LEFT:
                view.moveCameraLeft();
                break;
        }
        //do stuff
    }
}