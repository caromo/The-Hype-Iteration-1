package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.WindowEvent;

public class QuitGame extends ListView {
    private ConfirmationPopup cp;
    public QuitGame(Player player, Canvas canvas) {
        super(player, canvas);
        cp = new ConfirmationPopup(canvas, "Are you sure");
    }

    public void render() {
        renderTextEntry("Do you want to Exit Game?", 0);
        if(cp.getActive()) {
            cp.render();
        }
    }
    public void Enter() {
        if(!cp.getActive()) {
            cp.setActive(true);
        }else {
            if(cp.currentSelection()) {
                System.exit(0);
            } else {
                cp.setActive(false);
            }
        }

    }

    public void Left() {
        if(cp.getActive()) {
            cp.Left();
        }
    }
    public void Right() {
        if(cp.getActive()) {
            cp.Right();
        }
    }

    public String toString() {
        return "Quit Game";
    }
}
