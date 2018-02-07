package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

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
    private int cameraX, cameraY;
    private String workingDir;
    Color[] items;
    private Image[] itemSprites;
    private Image[] terrainSprites;
    private int tileSize;
    public View(GraphicsContext gc, Canvas canvas) {

        this.gc = gc;
        this.canvas = canvas;
        cameraX = 0; cameraY = 0;
        tileSize = 50;

        workingDir = System.getProperty("user.dir");
        itemSprites = new Image[100];
        itemSprites[0] = getImage(workingDir + "\\src\\sample\\sprites\\potion2.png");
        itemSprites[1] = getImage(workingDir + "\\src\\sample\\sprites\\sword.png");

        terrainSprites = new Image[3];
        terrainSprites[0] = getImage(workingDir + "\\src\\sample\\sprites\\grass.png");
        terrainSprites[1] = getImage(workingDir + "\\src\\sample\\sprites\\water.png");

        items = new Color[10];
        items[0] = Color.BLUE;
        items[1] = Color.GREEN;
        items[2] = Color.YELLOW;

    }

    public void render(tile[][] map, Player p) {
        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());



        renderMap(map, p);
        renderGrid(map);
        gc = canvas.getGraphicsContext2D();
    }

    //Render Order: GroundType -> tileObeject -> player/enemy
    private void renderMap(tile[][] map, Player p) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //Iterate through map, setting appropriate color for each tile, then draw rect
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                gc.drawImage(itemSprites[1], (3*tileSize)+5+cameraX, (3*tileSize)+5+cameraY, tileSize, tileSize);

                int tileID = map[i][j].getScenario();
                if(tileID == 0) {//Empty
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
        gc.setLineWidth(4);
        for(int i = 0; i < map.length+1; i++) {
            gc.strokeLine(0, i*tileSize+cameraY, canvas.getWidth(), i*tileSize+cameraY);
            gc.strokeLine(i*tileSize+cameraX, 0, i*tileSize+cameraX, canvas.getHeight());
        }
    }

    public void moveCameraUp() {
        cameraY+=tileSize;
    }
    public void moveCameraDown() {
        cameraY-=tileSize;
    }
    public void moveCameraLeft() {
        cameraX+=tileSize;
    }
    public void moveCameraRight() {
        cameraX-=tileSize;
    }
}
