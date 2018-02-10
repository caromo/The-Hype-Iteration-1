package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

import static java.lang.Character.isLetter;

public class Main extends Application {
    private View view;
    private KeyHandler keyHandler;
    private Player player;
    private Map map;
    private MenuView menuView;
    private MainMenu mainMenu;
    private PlayerController pc;
    private boolean menuActive;

    private Stage mainStage;
    private Scene mainScene;

    public static void main(String[] args) {

        Player p = new Player();

        tileObject item = new Item(4,5);
//        tileObject damage = new AreaEffect(1, 5);

        tile t = new tile(item);
        p.occupy = new Occupy(p, t);
        t.holding = new Holding(t, item);
        t.applyEffect();

//        ((expEffect) damage).startexp();
        p.getInventory().printInventory();
        launch(args);
    }

    @Override
    public void start(Stage theStage) {

        mainStage = theStage;
        mainStage.setTitle("The H Y P E");

        Group root = new Group();
        mainScene = new Scene(root);


        Canvas canvas = new Canvas(800, 800);
        root.getChildren().add(canvas);

        menuActive = false;

        GraphicsContext gc = canvas.getGraphicsContext2D();

        player = new Player();
        map = new Map(player);
        mainMenu = new MainMenu(player, gc, canvas, mainStage, mainScene);
        view = new View(gc, canvas, player, mainMenu);
        keyHandler = new KeyHandler(view, this);
        menuView = new MenuView(player, gc, canvas);
        pc = new PlayerController(map);
        loadGame();

        for (int i = 0; i < 15; i++) {
            player.getInventory().addItembyID(i);
        }

        mainMenu.openMainMenu();

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(keyHandler);
        mainScene.setOnKeyPressed(pc);
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                //double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                view.render(map.getState(), player);
            }
        }.start();
        theStage.show();
    }

    private void loadGame() {
        try {
            File playerFile = new File(System.getProperty("user.dir") + "/Save/Player.txt");
            BufferedReader br_player = new BufferedReader(new FileReader(playerFile));
            String mapID = br_player.readLine();

            //Second line of mapfile is the starting position of the player as a point. so read second line of code and call setstartingpoint() in map, it takes
            //a point as argument so just create a point and set the x and y value of it

            File mapFile = new File(System.getProperty("user.dir") + "/Save/Map/" + mapID +".txt");  //Sample directory


            BufferedReader br_map = new BufferedReader(new FileReader(mapFile));        //Size of map might be different, delimeted by space. Change for loop
            Scanner s_map = new Scanner(br_map.readLine());     //First line of map file
            String sMapSizeX = s_map.next();
            String sMapSizeY = s_map.next();
            int mapSizeX = Integer.parseInt(sMapSizeX);
            int mapSizeY = Integer.parseInt(sMapSizeY);

            s_map = new Scanner(br_map.readLine());

            Point tempPoint = new Point(Integer.parseInt(s_map.next()), Integer.parseInt(s_map.next()));        //Setting player position
            map.setStartingPoint(tempPoint);


            tile [][] tileTempArray = new tile [mapSizeX][mapSizeY];       //defining array with size mentioned on first line of map


            for (int i = 0; i < mapSizeX; i++) {
                String st = br_map.readLine();
                Scanner scanInput = new Scanner(st);

                for (int j = 0; j < mapSizeY; j++) {
                    String temp = scanInput.next();

                    if (!isLetter(temp.charAt(0))){
                        String equid = "" + temp.charAt(0) + temp.charAt(1) + temp.charAt(2);
                        String data = "" + temp.charAt(3) + temp.charAt(4);
                        System.out.println(equid + "" + data);      //testing
                        tileTempArray [i][j] = new tile();
                        tileTempArray[i][j].fill('g', 6, Integer.parseInt(equid), Integer.parseInt(data) );
                    }
                    else {
                        System.out.println(temp.charAt(0)+ "" + temp.charAt(1) +"" + temp.charAt(2) + "" + temp.charAt(3) + "" +temp.charAt(4));    //testing
                        tileTempArray [i][j] = new tile();
                        tileTempArray[i][j].fill(temp.charAt(0), (int) temp.charAt(1), (int) temp.charAt(2), 0);
                    }
                }
            }
            br_map.close();

            for(int i=1; i<12;i++){
                String playerInfo = br_player.readLine();
                Scanner s = new Scanner(playerInfo);
                System.out.println(playerInfo); //testing


                if (i==1){
                    map.setMapID(Integer.parseInt(mapID));
                    player.setPosition(Integer.parseInt(s.next()), Integer.parseInt(s.next()));
                }
                if(i==2) {
                    player.setHealth(Integer.parseInt(playerInfo));
                }
                if(i== 3) {
                    player.setAttackPoints(Integer.parseInt(playerInfo));
                }
                if(i== 4) {
                    player.setDefensePoints(Integer.parseInt(playerInfo));
                }
                if(i == 5) {
                    player.setExperience(Integer.parseInt(playerInfo));
                }
                if(i == 6) {
                    player.setExpToNextLvl(Integer.parseInt(playerInfo));
                }
                if (i == 7 ){
                    player.setLevel(Integer.parseInt(playerInfo));
                }
                if (i == 8){
                    //No spaces on item, first 3 numbers are item and the last two are attributes, this is the line 8,9,10 of playerfile. read it and depending if its a 100,200,300 do IF's to know whether they are armors, sword...
                    String tempVal = "" +playerInfo.charAt(0) + playerInfo.charAt(1) +playerInfo.charAt(2);
                    String tempVal2 = "" + playerInfo.charAt(3) + playerInfo.charAt(4);
                    player.equipGear(new Armor(Integer.parseInt(tempVal)/100, Integer.parseInt(tempVal), Integer.parseInt(tempVal2)));
                }
                if (i==9){
                    String tempVal = "" +playerInfo.charAt(0) + playerInfo.charAt(1) +playerInfo.charAt(2);
                    String tempVal2 = "" + playerInfo.charAt(3) + playerInfo.charAt(4);
                    player.equipGear(new Weapon(Integer.parseInt(tempVal)/100, Integer.parseInt(tempVal), Integer.parseInt(tempVal2)));
                }
                if (i==10){
                    String tempVal = "" +playerInfo.charAt(0) + playerInfo.charAt(1) +playerInfo.charAt(2);
                    String tempVal2 = "" + playerInfo.charAt(3) + playerInfo.charAt(4);
                    player.equipGear(new Ring(Integer.parseInt(tempVal)/100, Integer.parseInt(tempVal), Integer.parseInt(tempVal2)));
                }

                if (i == 11 ){
                    player.setName(playerInfo);
                }
            }

            //loads player inventory
            File inventoryFile = new File(System.getProperty("user.dir") + "/Save/inventory.txt");  //Sample directory
            BufferedReader br_inventory = new BufferedReader(new FileReader(inventoryFile));
            String s;
            while ((s= br_inventory.readLine()) != null )
            {
                Scanner scan = new Scanner(s);
                player.getInventory().addItembyID(Integer.parseInt(s));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleMenu() {
        menuActive = !menuActive;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public boolean getMenuActive() {
        return menuActive;
    }

    public Player getPlayer() {
        return player;
    }

    public Map getMap() {
        return map;
    }


    public void saveGame(Player player, Map map) {
        saveMap(map.getMapID(), map, player);
        try {
            PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/Save/Player.txt");
            PrintWriter iw = new PrintWriter(System.getProperty("user.dir") + "/Save/Inventory.txt");

            //write Player.txt file, format is "Game Index" on drive
            pw.println(map.getMapID());
            pw.println(player.getPosition().getX() + " " + player.getPosition().getY());
            pw.println(player.getHealth());
            pw.println(player.getAttackPoints());
            pw.println(player.getDefensePoints());
            pw.println(player.getExperience());
            pw.println(player.getExpToNextLvl());
            pw.println(player.getLevel());
            Equipment eq[] = player.getEquipment();
            pw.println(eq[0].getEquipmentID() + eq[0].supplyBenefit());
            pw.println(eq[1].getEquipmentID() + eq[1].supplyBenefit());
            pw.println(eq[2].getEquipmentID() + eq[2].supplyBenefit());
            pw.println(player.getName());


            pw.close();

            //write Inventory.txt one itemID per line
            Item[] temp = player.getInventory().getItems();
            for (int i = 0; i < player.getInventory().getNumOfItems(); i++) {
                iw.print(temp[i].getID());
                iw.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Saves the current Map
    public void saveMap(int MapID, Map map, Player player) {
                    int mapSizeX = map.getMapX();
                    int mapSizeY = map.getMapY();
                    tile[][] tmp = map.getState();


                    try {
                        //opens the map file based on MapID for writing
                        PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/Save" + "/Maps" + "/" + Integer.toString(MapID));

                        //write first line map size: X Y
                        pw.println(mapSizeX + " " + mapSizeY);
                        //write second line with startingPosition
                        pw.println(player.getPosition().getX() + " " + player.getPosition().getY());

                        //Iterating through the map printing tiles in 5 digits
                        for (int i = 0; i < mapSizeX; i++) {
                            for (int j = 0; j < mapSizeY; j++) {
                                pw.print(tmp[i][j].spill());
                                pw.print(" ");
                            }
                            pw.println();

            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*
    Creates the Save folder with default maps, player, and inventory
    Will overwrite itself every time new game is selected
     */
    private void newGame(String name) {

        //creates the players map folder
        Path path = Paths.get(System.getProperty("user.dir") + "/Save/");

        File sourceMapFolder = new File(System.getProperty("user.dir") + "/Default");
        File destinationMapFolder = new File(path.toString());

        //copys contents of default folder to player map folder
        copyFolder(sourceMapFolder, destinationMapFolder);

        //writes the players name to the last line of the file
        try {
            Files.write(Paths.get(System.getProperty("user.dir") + "/Save/Player.txt"), name.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // loadGame();

        // System.exit(0);
    }

    private static void copyFolder(File sourceFolder, File destinationFolder) {
        //Check if sourceFolder is a directory or file
        //If sourceFolder is file; then copy the file directly to new location
        if (sourceFolder.isDirectory()) {
            //Verify if destinationFolder is already present; If not then create it
            if (!destinationFolder.exists()) {
                destinationFolder.mkdir();
            }

            //Get all files from source directory
            String files[] = sourceFolder.list();

            //Iterate over all files and copy them to destinationFolder one by one
            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                File destFile = new File(destinationFolder, file);

                //Recursive function call
                copyFolder(srcFile, destFile);
            }
        } else {
            //Copy the file content from one place to another
            try {
                Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
