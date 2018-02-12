package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;

public class ListView {

    private Player player;
    private GraphicsContext gc;
    private Canvas canvas;
    private boolean visible;
    private boolean open;

    private int entryHeight;
    private int entryWidth;
    private int scrollOffset;
    private int cursorPos;
    private int numOfEntries;
    private int maxEntriesDisplayed;

    private Image cursorImg;
    private Image arrow;
    public ListView(Player player, Canvas canvas) {
        this.player = player;
        this.gc = canvas.getGraphicsContext2D();
        this.canvas = canvas;
        visible = false;
        entryHeight = 100;
        entryWidth = 400;
        cursorPos = 0;
        scrollOffset = 0;
        maxEntriesDisplayed = 8;

        File file = new File(System.getProperty("user.dir") + "\\src\\sample\\sprites\\cursor2.png");
        cursorImg = new Image(file.toURI().toString());
        file = new File(System.getProperty("user.dir") + "\\src\\sample\\sprites\\arrow.png");
        arrow = new Image(file.toURI().toString());
    }

    public void renderCursor() {


        gc.drawImage(cursorImg, -5, cursorPos*getEntryHeight()-5, getEntryWidth(), getEntryHeight()+10);
        gc.drawImage(arrow, getEntryWidth(), cursorPos*getEntryHeight()+20, 100, 60);


    }



    public void renderTextEntry(String s, int ind) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, ind*getEntryHeight()+5, getEntryWidth()-5, getEntryHeight());
        renderEntryBackground(ind);
        gc.setFill(Color.BLACK);
        gc.fillText(s, 70, ind*getEntryHeight()+55);
    }

    public void renderEntryBackground(int ind) {
        File file = new File(System.getProperty("user.dir") + "\\src\\sample\\sprites\\menuBackground4.png");
        Image image = new Image(file.toURI().toString());
        gc.drawImage(image, -5, ind*getEntryHeight()-5, getEntryWidth(), getEntryHeight()+10);
    }

    public void cursorDown() {
        if(cursorPos < maxEntriesDisplayed-1 && cursorPos < numOfEntries-1) {
            cursorPos++;
            return;
        }
        if(cursorPos+scrollOffset < numOfEntries-1) {
            scrollOffset++;
        }

    }
    public void cursorUp() {
        if(cursorPos > 0) {
            cursorPos--;
            return;
        }
        if(scrollOffset > 0) {
            scrollOffset--;
        }
    }

    //Returns the index of the item currently selected by the cursor
    public int getSelectedItemIndex() {
        return cursorPos+scrollOffset;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public boolean getVisible() {
        return visible;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public boolean getOpen() {
        return open;
    }

    public int getNumOfEntries() {
        return numOfEntries;
    }
    public void setNumOfEntries(int num) {
        numOfEntries = num;
    }

    //Returns number of entries that should be displayed
    public int getMaxEntriesDisplayed() {
        return Math.min(maxEntriesDisplayed, getNumOfEntries());
    }
    public int getEntryHeight() {
        return entryHeight;
    }
    public int getEntryWidth() {
        return entryWidth;
    }
    public int getScrollOffset() {
        return scrollOffset;
    }
    public int getCursorPos() {
        return cursorPos;
    }

    public void render() {

    }
    public void Up() {

    }
    public void Down() {

    }
    public void Left() {

    }
    public void Right() {

    }
    public void Enter() {

    }
    public void Escape() {

    }

    public String toString() {
        return "ListItem";
    }

}
