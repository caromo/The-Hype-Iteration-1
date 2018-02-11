package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class MenuView extends ListView{

    private Player player;
    private GraphicsContext gc;
    private Canvas canvas;
    private ArrayList<ListView> menuItems;
    private boolean open;
    private int currentOpenInd;

    private Stage mainStage;
    private Scene mainScene, startingScene, characterCreationScene, gameOverScene;

    public MenuView(Player player, Canvas canvas, Main main) {
        super(player, canvas);
        this.player = player;

        this.gc = canvas.getGraphicsContext2D();

        //Adds menu options to list
        menuItems = new ArrayList<ListView>();
        menuItems.add(new InventoryView(player, canvas));
        menuItems.add(new EquipmentView(player, canvas));
        menuItems.add(new StatusView(player, canvas));
        menuItems.add(new SaveGameView(player, canvas, main));
        menuItems.add(new QuitGame(player, canvas));

        setNumOfEntries(menuItems.size());
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

    public void Left() {
        if(!isOpen()) {
            return;
        } else if(isOpen() && !getVisible()){
            menuItems.get(currentOpenInd).Left();
        }
    }
    public void Right() {
        if(!isOpen()) {
            return;
        } else if(isOpen() && !getVisible()){
            menuItems.get(currentOpenInd).Right();
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
