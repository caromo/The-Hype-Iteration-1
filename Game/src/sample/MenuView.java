package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class MenuView extends ListView{

    private Player player;
    private GraphicsContext gc;
    private Canvas canvas;
    private ArrayList<ListView> menuItems;
    private boolean open;
    private int currentOpenInd;
    public MenuView(Player player, GraphicsContext gc, Canvas canvas) {
        super(player, gc, canvas);
        this.player = player;

        menuItems = new ArrayList<ListView>();
        menuItems.add(new InventoryView(player, gc, canvas));
        menuItems.add(new StatusView(player, gc, canvas));
        setNumOfEntries(2);
        currentOpenInd = 0;
        open = false;
    }

    public void render() {
        if(!isOpen()) { return; }
        if(getVisible()) {
            renderMenu();
            renderCursor();
        } else {
            menuItems.get(currentOpenInd).render();
        }
    }

    private void renderMenu() {
        for(int i = 0; i < menuItems.size(); i++) {
            renderTextEntry(menuItems.get(i).toString(), i);
        }
        //renderTextEntry();
    }

    public void Up() {
        if(!isOpen()) {
            return;
        } else if(isOpen() && !getVisible()){
            menuItems.get(currentOpenInd).Up();
        } else {//Menu currently focus
            cursorUp();
        }
    }
    public void Down() {
        if(!isOpen()) {
            return;
        } else if(isOpen() && !getVisible()){
            menuItems.get(currentOpenInd).Down();
        } else {//Menu currently focus
            cursorDown();
        }

    }
    public void Escape() {

        if(!isOpen()) {//Menu Not Open, open
            setOpen(true);
            setVisible(true);
        } else if(isOpen() && !getVisible()){//Sub Menu Open, close sub menu
            menuItems.get(currentOpenInd).setVisible(false);
            setVisible(true);
        } else {//Menu currently focus
            setOpen(false);
            setVisible(false);
        }
        //setOpen(false);
    }

    public void Enter() {
        if(!isOpen()) {
            return;
        } else if(isOpen() && !getVisible()) {
            menuItems.get(currentOpenInd).Enter();
        } else {
            menuItems.get(getSelectedItemIndex()).setVisible(true);
            currentOpenInd = getSelectedItemIndex();
            setVisible(false);
        }
    }


    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }


}
