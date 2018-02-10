package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;


public class HUDView {
    private GraphicsContext gc;
    private Canvas canvas;
    private Player player;

    public HUDView(Canvas canvas, Player player) {
        gc = canvas.getGraphicsContext2D();
        this.canvas = canvas;
        this.player = player;
    }

    public void render() {
        renderHealthBar();
    }

    private void renderHealthBar() {
        //Background
        gc.setFill(Color.GRAY);
        gc.fillRect(canvas.getWidth()-220, 15, 200, 20);

        float healthPercentage = (float)player.getHealth()/(float)player.getMaxHealth();

        //Healthbar
        gc.setFill(Color.RED);
        gc.fillRect(canvas.getWidth()-220, 15, 200*healthPercentage, 20);
    }


}
