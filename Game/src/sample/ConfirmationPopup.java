package sample;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//Displays a yes/no confirmation window
public class ConfirmationPopup {
    private int x, y, width, height;
    private GraphicsContext gc;
    private String confirmationString;
    private boolean yesSelected;
    private boolean active;

    public ConfirmationPopup(Canvas canvas, String confirmationString) {
        this.gc = canvas.getGraphicsContext2D();
        this.confirmationString = confirmationString;
        x = 200; y = 200;
        width = 400; height = 200;
        yesSelected = true;
        active = false;



    }

    public void render() {
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, width, height);
        gc.setFill(Color.BLACK);
        gc.fillText(confirmationString, x+50, y+50);
        renderButton("Yes", x+50, y+100, true);
        renderButton("No", x+150, y+100, false);
    }



    public void renderButton(String s, int x, int y, boolean selection) {
        if(yesSelected == selection) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.GRAY);
        }

        gc.fillRect(x, y, 80, 40);
        gc.setFill(Color.BLACK);
        gc.fillText(s, x+20, y+25);
    }

    public void Left() {
        yesSelected = true;
    }
    public void Right() {
        yesSelected = false;
    }

    public boolean currentSelection() {
        return yesSelected;
    }

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

}
