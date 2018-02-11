package sample;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;

public class Sprites {
    private ArrayList<Image> itemSprites;
    private ArrayList<Image> terrainSprites;
    private ArrayList<Image> AESprites;
    private Image mapTransitionSprite;


    private String workingDir;
    public Sprites() {
        workingDir = System.getProperty("user.dir")+"\\Game";
        //System.out.println(workingDir);
        itemSprites = new ArrayList<Image>();
        terrainSprites = new ArrayList<Image>();
        AESprites = new ArrayList<Image>();

        initializeSprites();
    }

    private void initializeSprites() {
        //Load item textures

        itemSprites.add(getImage(workingDir + "\\src\\sample\\sprites\\potion2.png"));
        itemSprites.add(getImage(workingDir + "\\src\\sample\\sprites\\sword.png"));

        //Load terrain textures

        terrainSprites.add(getImage(workingDir + "\\src\\sample\\sprites\\grass.png"));
        terrainSprites.add(getImage(workingDir + "\\src\\sample\\sprites\\water.png"));
        terrainSprites.add(getImage(workingDir + "\\src\\sample\\sprites\\mountains.png"));

        AESprites.add(getImage(workingDir + "\\src\\sample\\sprites\\health.png"));
        AESprites.add(getImage(workingDir + "\\src\\sample\\sprites\\crying-cat-face.png"));
        AESprites.add(getImage(workingDir + "\\src\\sample\\sprites\\star.png"));

        mapTransitionSprite = getImage(workingDir + "\\src\\sample\\sprites\\door.png");

        //playerImg = getImage(workingDir + "\\src\\sample\\sprites\\pikachu.png");


    }

    public Image getTileObjectSprite(int SN, int spec) {


        if(SN == 1) {//AEHealing
            return AESprites.get(0);
        } else if(SN == 2) {//AEDamage
            return AESprites.get(1);
        } else if(SN == 3) {//AEExperience
            return AESprites.get(2);
        } else if(SN == 4) {//Item
            return getItemImage(spec);
        } else {//Map transition
            return mapTransitionSprite;
        }
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
