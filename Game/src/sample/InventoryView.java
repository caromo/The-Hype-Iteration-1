package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Math.min;

public class InventoryView extends ListView{

    private Player player;
    private Canvas canvas;
    private GraphicsContext gc;
    public InventoryView(Player player, GraphicsContext gc, Canvas canvas) {
        super(player, gc, canvas);
        this.player = player;
        this.canvas = canvas;
        this.gc = gc;

    }

    @Override
    public void render() {
        setNumOfEntries(player.getInventory().getNumOfItems());
        if(!getVisible()) {
            return;
        }
        for(int i = 0; i < getMaxEntriesDisplayed(); i++) {
            renderEntry(i);
        }
        renderCursor();
        renderScrollBar();
    }


    private void renderEntry(int ind) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, ind*getEntryHeight(), getEntryWidth(), getEntryHeight());
        Item item = player.getInventory().getItem(ind);
        if(item == null) {
            return;
        }
        gc.setFill(Color.BLACK);
        gc.fillText("ItemID: " + Integer.toString(player.getInventory().getItem(ind+getScrollOffset()).getID()), 50, ind*getEntryHeight()+50);



    }

    public void renderScrollBar() {
        //Calculate how large the scroll bar should be
        float barHeight = (float)getMaxEntriesDisplayed()/(float)player.getInventory().getNumOfItems();
        //Calculate how far from the time the scroll bar should start
        float barDistFromTop = (float)getScrollOffset()/(float)(player.getInventory().getNumOfItems());

        //Render scroll bar background
        gc.setFill(Color.GRAY);
        gc.fillRect(getEntryWidth()-5, 0, 10, canvas.getHeight());

        //Render actual scroll bar
        gc.setFill(Color.BLACK);
        gc.fillRect(getEntryWidth()-5, barDistFromTop*canvas.getHeight(), 10, barHeight*canvas.getHeight());
    }

    public void Enter() {
        System.out.println(player.getInventory().getItem(getSelectedItemIndex()).getID());
    }
    public void Up() {
        cursorUp();
    }
    public void Down() {
        cursorDown();
    }

    public String toString() {
        return "Inventory";
    }


}
