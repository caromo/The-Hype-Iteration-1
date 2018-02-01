package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class View {
    private GraphicsContext gc;
    private Canvas canvas;
    private int x, y;
    public View(GraphicsContext gc, Canvas canvas) {
        this.gc = gc;
        this.canvas = canvas;
        x = 50; y = 50;
    }

    public void render(int x, int y) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.BLUE);
        gc.fillRect(this.x+x, this.y+y, 50, 50);
        this.x += x;
        this.y += y;

        gc = canvas.getGraphicsContext2D();
    }
}
