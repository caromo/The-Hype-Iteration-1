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
    }

    public void renderCursor() {
        gc.setLineWidth(10);
        gc.setStroke(Color.BLUE);
        gc.strokeLine(0, cursorPos*entryHeight, entryWidth-10, cursorPos*entryHeight);
        gc.strokeLine(0, (cursorPos+1)*entryHeight, entryWidth-10, (cursorPos+1)*entryHeight);
        gc.strokeLine(0, cursorPos*entryHeight, 0, (cursorPos+1)*entryHeight);
        gc.strokeLine(entryWidth-10, cursorPos*entryHeight, entryWidth-10, (cursorPos+1)*entryHeight);
    }

    public void renderTextEntry(String s, int ind) {
        //gc.setFill(Color.WHITE);
        //gc.fillRect(0, ind*getEntryHeight(), getEntryWidth(), getEntryHeight());
        renderEntryBackground(ind);
        gc.setFill(Color.BLACK);
        gc.fillText(s, 50, ind*getEntryHeight()+50);
    }

    public void renderEntryBackground(int ind) {
        File file = new File(System.getProperty("user.dir") + "\\src\\sample\\sprites\\menuBackground2.png");
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
    public int getMaxEntriesDisplayed() {
        return maxEntriesDisplayed;
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
