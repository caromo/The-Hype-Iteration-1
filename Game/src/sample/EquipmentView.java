package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//Responsible for displaying the players equipment and allowing them to equip/unequip items
public class EquipmentView extends ListView {
    private Player player;
    private Canvas canvas;
    private GraphicsContext gc;
    private EquipmentCodex eqc;
    private int numOfEntries;
    public EquipmentView(Player player, Canvas canvas) {
        super(player, canvas);
        this.player = player;
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        eqc = new EquipmentCodex();


    }

    public void render() {
        setNumOfEntries(player.getEquipment().length);
        if(!getVisible()) {
            return;
        }
        for(int i = 0; i < getMaxEntriesDisplayed(); i++) {
            renderEntry(i);
        }
        renderCursor();

    }

    private void renderEntry(int ind) {
        Equipment eq = player.getEquipment()[ind];
        if(eq == null) {
            return;
        }
        System.out.println(eqc.getName(eq.getEquipmentID()));
        renderTextEntry(eqc.getName(eq.getEquipmentID()), ind);

    }

    //Tells player to remove selected gear
    public void Enter() {
        player.unequipGear(getCursorPos());
        System.out.println(player.getEquipment()[getCursorPos()].getEquipmentID());
    }

    public void Up() {
        cursorUp();
    }
    public void Down() {
        cursorDown();
    }

    public String toString() {
        return "Equipment";
    }
}
