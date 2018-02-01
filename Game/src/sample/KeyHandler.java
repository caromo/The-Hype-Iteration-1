package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent>
{
    public int x, y;
    public KeyHandler() {
        x = 0; y = 0;
    }
    public void handle(KeyEvent event)
    {
        System.out.println("KeyPressed");
        switch(event.getCode()) {
            case UP:
                y = -1;
                x = 0;
                break;
            case RIGHT:
                x = 1;
                y = 0;
                break;
            case DOWN:
                y = 1;
                x = 0;
                break;
            case LEFT:
                x = -1;
                y = 0;
                break;
        }
        //do stuff
    }
}