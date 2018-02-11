package sample;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;

public class Sprites {
    private ArrayList<Image> itemSprites;
    private ArrayList<Image> terrainSprites;
    private Image playerImg;

    private String workingDir;
    public Sprites() {
        workingDir = System.getProperty("user.dir");
        //System.out.println(workingDir);
        itemSprites = new ArrayList<Image>();
        terrainSprites = new ArrayList<Image>();
        initializeSprites();
    }

    private void initializeSprites() {
        //Load item textures

        itemSprites.add(getImage(workingDir + "/Game/src/sample/sprites/potion2.png"));
        itemSprites.add(getImage(workingDir + "/Game/src/sample/sprites/sword.png"));

        //Load terrain textures

        terrainSprites.add(getImage(workingDir + "/Game/src/sample/sprites/grass.png"));
        terrainSprites.add(getImage(workingDir + "/Game/src/sample/sprites/water.png"));
        terrainSprites.add(getImage(workingDir + "/Game/src/sample/sprites/mountains.png"));

        //playerImg = getImage(workingDir + "/src/sample/sprites/pikachu.png");


    }

    public Image getItemImage(int itemID) {
        if(itemID >= itemSprites.size()) {
            return itemSprites.get(0);
        }
        return itemSprites.get(itemID);
    }

    public Image getTerrainImage(char type) {
        if(type == 'G') {
            return terrainSprites.get(0);
        } else if(type == 'W') {
            return terrainSprites.get(1);
        } else {
            return terrainSprites.get(2);
        }
    }

    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }


}
