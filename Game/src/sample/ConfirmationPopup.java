package sample;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;

//Displays a yes/no confirmation window
public class ConfirmationPopup {
    private int x, y, width, height;
    private GraphicsContext gc;
    private String confirmationString;
    private boolean yesSelected;
    private boolean active;
    private Image background;

    public ConfirmationPopup(Canvas canvas, String confirmationString) {
        this.gc = canvas.getGraphicsContext2D();
        this.confirmationString = confirmationString;
        x = 200; y = 200;
        width = 400; height = 200;
        yesSelected = true;
        active = false;

        File file = new File(System.getProperty("user.dir") + "\\src\\sample\\sprites\\popupBackground.png");
        background = new Image(file.toURI().toString());

    }

    public void render() {
        gc.drawImage(background, x, y, width, height);
        gc.setFill(Color.BLACK);
        gc.fillText(confirmationString, x+95, y+50);
        renderButton("Yes", x+86, y+113, true);
        renderButton("No", x+247, y+113, false);
    }



    public void renderButton(String s, int x, int y, boolean selection) {
        if(yesSelected == selection) {
            gc.setFill(new Color(.55, .33, .03, 1));
            gc.fillRect(x, y, 82, 42);
        }


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
