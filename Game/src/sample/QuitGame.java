package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.WindowEvent;

public class QuitGame extends ListView {

    public QuitGame(Player player, GraphicsContext gc, Canvas canvas) {
        super(player, gc, canvas);
    }

    public void render() {
        renderTextEntry("Do you want to Exit Game?", 0);
    }
    public void Enter() {
        System.exit(0);
    }

    public String toString() {
        return "Quit Game";
    }
}
