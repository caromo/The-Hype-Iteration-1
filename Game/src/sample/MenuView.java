package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MenuView {

    private Player player;
    private GraphicsContext gc;
    private Canvas canvas;
    private InventoryView inventoryView;
    public MenuView(Player player, GraphicsContext gc, Canvas canvas) {
        this.player = player;
        inventoryView = new InventoryView(player, gc, canvas);
    }

    public void render() {
        inventoryView.render();
    }

    public InventoryView getInventoryView()  {
        return inventoryView;
    }


}
