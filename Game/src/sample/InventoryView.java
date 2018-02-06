package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Math.min;

public class InventoryView {


    private Player player;
    private GraphicsContext gc;
    private Canvas canvas;
    private int entryHeight;
    private int entryWidth;
    private int scrollOffset;
    private int cursorPos;
    private int numOfEntries;
    public InventoryView(Player player, GraphicsContext gc, Canvas canvas) {
        this.player = player;
        this.gc = gc;
        this.canvas = canvas;
        entryHeight = 100;
        entryWidth = 400;
        cursorPos = 0;
        scrollOffset = 0;
    }

    public void render() {
        numOfEntries = min(player.getInventory().getNumOfItems(), (int) canvas.getHeight()/entryHeight);
        for(int i = 0; i < numOfEntries; i++) {
            renderEntry(i);
        }
        renderCursor();
        renderScrollBar();
    }

    private void renderEntry(int ind) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, ind*entryHeight, entryWidth, entryHeight);
        Item item = player.getInventory().getItem(ind);
        if(item == null) {
            return;
        }
        gc.setFill(Color.BLACK);
        gc.fillText("ItemID: " + Integer.toString(player.getInventory().getItem(ind+scrollOffset).getID()), 50, ind*entryHeight+50);



    }

    private void renderCursor() {
        gc.setLineWidth(10);
        gc.setStroke(Color.BLUE);
        gc.strokeLine(0, cursorPos*entryHeight, entryWidth-10, cursorPos*entryHeight);
        gc.strokeLine(0, (cursorPos+1)*entryHeight, entryWidth-10, (cursorPos+1)*entryHeight);
        gc.strokeLine(0, cursorPos*entryHeight, 0, (cursorPos+1)*entryHeight);
        gc.strokeLine(entryWidth-10, cursorPos*entryHeight, entryWidth-10, (cursorPos+1)*entryHeight);
    }

    private void renderScrollBar() {
        //Calculate how large the scroll bar should be
        float barHeight = (float)numOfEntries/(float)player.getInventory().getNumOfItems();
        //Calculate how far from the time the scroll bar should start
        float barDistFromTop = (float)scrollOffset/(float)(player.getInventory().getNumOfItems());

        //Render scroll bar background
        gc.setFill(Color.GRAY);
        gc.fillRect(entryWidth-5, 0, 10, canvas.getHeight());

        //Render actual scroll bar
        gc.setFill(Color.BLACK);
        gc.fillRect(entryWidth-5, barDistFromTop*canvas.getHeight(), 10, barHeight*canvas.getHeight());
    }

    public void cursorDown() {
        if(cursorPos < numOfEntries-1) {
            cursorPos++;
            return;
        }
        if(cursorPos+scrollOffset < player.getInventory().getNumOfItems()-1) {
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


}
