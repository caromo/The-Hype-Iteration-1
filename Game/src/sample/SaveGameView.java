package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;


public class SaveGameView extends ListView {
    private Player player;
    private GraphicsContext gc;
    private Canvas canvas;
    private Main main;
    public SaveGameView(Player player, Canvas canvas, Main main) {
        super(player, canvas);
        this.player = player;
        this.gc = canvas.getGraphicsContext2D();
        this.canvas = canvas;
        this.main = main;
    }

    public void render() {
        renderTextEntry("Do you want to Save Game?", 0);
    }

    public void Enter() {
        main.saveGame();
    }

    public String toString() { return "Save Game"; }

}
