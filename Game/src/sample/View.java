package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

import java.io.File;
import java.nio.file.Paths;

public class View {
    private GraphicsContext gc;
    private Canvas canvas;
    private int x, y;
    private String workingDir;
    Color[] items;
    Image[] itemSprites;
    private int tileSize;
    public View(GraphicsContext gc, Canvas canvas) {

        this.gc = gc;
        this.canvas = canvas;
        x = 2; y = 2;
        tileSize = 50;

        workingDir = System.getProperty("user.dir");
        itemSprites = new Image[100];
        itemSprites[0] = getImage(workingDir + "\\src\\sample\\sprites\\healthPotion.png");

        items = new Color[10];
        items[0] = Color.BLUE;
        items[1] = Color.GREEN;
        items[2] = Color.YELLOW;

    }

    public void render(tile[][] map, Player p) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //gc.setFill(Color.BLUE);
        //gc.fillRect(this.x+x, this.y+y, 50, 50);
        

        renderMap(map, p);
        renderGrid(map);
        gc = canvas.getGraphicsContext2D();
    }

    private void renderMap(tile[][] map, Player p) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //Iterate through map, setting appropriate color for each tile, then draw rect
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int tileID = map[i][j].getScenario();
                if(tileID == 0) {//Empty
                    //gc.setFill(Color.WHITE);
                    gc.drawImage(getImage(workingDir + "\\src\\sample\\sprites\\grass.png"), (i*tileSize), (j*tileSize), tileSize, tileSize);
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
                    gc.drawImage(getImage(workingDir + "\\src\\sample\\sprites\\grass.png"), (i*tileSize), (j*tileSize));
                    gc.drawImage(itemSprites[((Item)map[i][j].holding.object).getID()], (i*tileSize)+5, (j*tileSize)+5, tileSize, tileSize);
                }
            }
        }

        gc.drawImage(getImage(workingDir + "\\src\\sample\\sprites\\pikachu.png"), (x*tileSize), (y*tileSize), tileSize, tileSize);

        //Draw player

    }

    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }

    private void renderGrid(tile[][] map) {
        gc.setFill(Color.BLACK);
        gc.setLineWidth(5);
        for(int i = 0; i < map.length+1; i++) {
            gc.strokeLine(0, i*tileSize, canvas.getWidth(), i*tileSize);
            gc.strokeLine(i*tileSize, 0, i*tileSize, canvas.getHeight());
        }
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
