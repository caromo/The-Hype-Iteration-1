package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

/*Decals needed for view:
Grass, Water, Mountains
Player, Enemy
Potion, Sword, ...
Healing, Damage, XP AreaEffect
MapTransition
 */

public class View {
    private GraphicsContext gc;
    private Canvas canvas;
    private Player player;

    private int cameraX, cameraY;
    private String workingDir;
    Color[] items;
    private Image[] itemSprites;
    private Image[] terrainSprites;
    private Image playerImg;

    private int mapWidth, mapHeight;
    private int tileSize;

    private MenuView menu;
    public View(GraphicsContext gc, Canvas canvas, Player player, Stage mainStage, Scene mainScene) {

        this.gc = gc;
        this.canvas = canvas;
        this.player = player;
        menu = new MenuView(player, gc, canvas, mainStage, mainScene);

        cameraX = 0; cameraY = 0;
        mapWidth = 100; mapHeight = 100;
        tileSize = 50; //width/height of tiles in pixels

        //Get working directory to load textures from
        workingDir = System.getProperty("user.dir");

        initializeSprites();

    }

    //Load image arrays with sprite assets
    private void initializeSprites() {
        //Load item textures
        itemSprites = new Image[100];
        itemSprites[0] = getImage(workingDir + "\\src\\sample\\sprites\\potion2.png");
        itemSprites[1] = getImage(workingDir + "\\src\\sample\\sprites\\sword.png");

        //Load terrain textures
        terrainSprites = new Image[3];
        terrainSprites[0] = getImage(workingDir + "\\src\\sample\\sprites\\grass.png");
        terrainSprites[1] = getImage(workingDir + "\\src\\sample\\sprites\\water.png");
        terrainSprites[2] = getImage(workingDir + "\\src\\sample\\sprites\\lava.png");
    }

    public void render(tile[][] map, Player p) {
        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        renderMap(map, p);
        renderGrid(map);
        menu.render();
        gc = canvas.getGraphicsContext2D();
    }

    //Render Order: GroundType -> tileObeject -> player/enemy
    private void renderMap(tile[][] map, Player p) {
        //Get map dimensions
        mapWidth = map.length;
        mapHeight = map[0].length;

        //Draw background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //Iterate through map, setting appropriate color for each tile, then draw rect
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                int tileID = map[i][j].getScenario();
                if(tileID == 0) {//Terrain
                    gc.drawImage(terrainSprites[((Terrain) map[i][j].holding.object).getTerrainType()], (i*tileSize)+cameraX, (j*tileSize)+cameraY, tileSize, tileSize);
                } else if(tileID == 1) {//AEHealing
                    gc.setFill(Color.GREEN);
                    gc.fillRect((i*tileSize)+5, (j*tileSize)+5, tileSize-5, tileSize-5);

                } else if(tileID == 2) {//AEDamage
                    gc.setFill(Color.GREEN);
                    gc.fillRect((i*tileSize)+5, (j*tileSize)+5, tileSize-5, tileSize-5);

                } else if(tileID == 3) {//AEExperience
                    gc.setFill(Color.GREEN);
                    gc.fillRect((i*tileSize)+5, (j*tileSize)+5, tileSize-5, tileSize-5);

                } else if(tileID == 4) {//Item
                    gc.drawImage(getImage(workingDir + "\\src\\sample\\sprites\\grass.png"), (i*tileSize)+cameraX, (j*tileSize)+cameraY);
                    gc.drawImage(itemSprites[((Item)map[i][j].holding.object).getID()], (i*tileSize)+5+cameraX, (j*tileSize)+5+cameraY, tileSize, tileSize);
                } else {//MapTransition

                }
            }
        }


        //Draw player

    }



    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }

    private void renderGrid(tile[][] map) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        for(int i = 0; i < map.length+1; i++) {
            gc.strokeLine(0, i*tileSize+cameraY, canvas.getWidth(), i*tileSize+cameraY);
            gc.strokeLine(i*tileSize+cameraX, 0, i*tileSize+cameraX, canvas.getHeight());
        }
    }

    public void Up() {
        if(menu.isOpen()) {
            menu.Up();
        } else {
            moveCameraUp();
        }
    }
    public void Down() {
        if(menu.isOpen()) {
            menu.Down();
        } else {
            moveCameraDown();
        }
    }
    public void Right() {
        if(menu.isOpen()) { return; }
        moveCameraRight();
    }
    public void Left() {
        if(menu.isOpen()) { return; }
        moveCameraLeft();
    }
    public void Escape() {
        menu.Escape();
    }
    public void Enter() {
        menu.Enter();
    }
    public void P() { menu.openGameMenu(); }

    public void moveCameraUp() {
        if(cameraY >= 0) {//Top edge of board already in view
            return;
        }
        cameraY+=tileSize;
    }
    public void moveCameraDown() {
        if(canvas.getHeight()-cameraY >= mapHeight*tileSize) {//Bottom edge of board already in view
            return;
        }
        cameraY-=tileSize;
    }
    public void moveCameraLeft() {//Loft edge of board already in view
        if(cameraX >= 0) {
            return;
        }
        cameraX+=tileSize;
    }
    public void moveCameraRight() {
        if(canvas.getWidth()-cameraX >= mapWidth*tileSize) {//Right edge of board already in view
            return;
        }
        cameraX-=tileSize;
    }


}
