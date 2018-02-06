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
                if(main.getMenuActive()) {
                    main.getMenuView().getInventoryView().cursorUp();
                } else {
                    view.moveCameraUp();
                }
                break;
            case RIGHT:
                view.moveCameraRight();
                break;
            case DOWN:
                if(main.getMenuActive()) {
                    main.getMenuView().getInventoryView().cursorDown();
                } else {
                    view.moveCameraDown();
                }
                break;
            case LEFT:
                view.moveCameraLeft();
                break;
            case ESCAPE:
                main.toggleMenu();
                break;
            case ENTER:
                if(main.getMenuActive()) {
                    main.getPlayer().getInventory().getItem(main.getMenuView().getInventoryView().getSelectedItemIndex()).printID();
                }
        }
        //do stuff
    }
}