package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent>
{
    private View view;
    private Main main;
    public int x, y;
    public KeyHandler(View view, Main main) {
        this.view = view;
        this.main = main;
        x = 0; y = 0;
    }
    public void handle(KeyEvent event)
    {
        switch(event.getCode()) {
            case UP:
                view.Up();
                break;
            case RIGHT:
                view.Right();
                break;
            case DOWN:
                view.Down();
                break;
            case LEFT:
                view.Left();
                break;
            case ESCAPE:
                view.Escape();
                break;
            case ENTER:
                view.Enter();
                break;
            case P:
                view.P();
                break;
        }
    }
}
