package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class StatusView extends ListView{


    public StatusView(Player player, GraphicsContext gc, Canvas canvas) {
        super(player, gc, canvas);

    }

    public void render() {

    }

    public String toString() {
        return "Status View";
    }
}
