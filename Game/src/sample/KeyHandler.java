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
        switch(event.getCode()) {
            case UP:
                y--;
                break;
            case RIGHT:
                x++;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
        }
        //do stuff
    }
}