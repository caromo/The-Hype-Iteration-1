package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;


public class SaveGameView extends ListView {
    private Player player;
    private GraphicsContext gc;
    private Canvas canvas;
    private Main main;
    private ConfirmationPopup cp;
    public SaveGameView(Player player, Canvas canvas, Main main) {
        super(player, canvas);
        this.player = player;
        this.gc = canvas.getGraphicsContext2D();
        this.canvas = canvas;
        this.main = main;

        cp = new ConfirmationPopup(canvas, "Are you sure you want to save your game?");
    }

    public void render() {
        renderTextEntry("Do you want to Save Game?", 0);

        cp.render();
    }

    public void Enter() {
        if(!cp.getActive()) {
            cp.setActive(true);
        }else {
            if(cp.currentSelection()) {
                main.saveGame();
                this.setVisible(false);
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

    public String toString() { return "Save Game"; }

}
