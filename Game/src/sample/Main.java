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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;

public class Main extends Application {
    private View view;
    private KeyHandler keyHandler;
    private Player player;
    private Map map;
    private MenuView menuView;
    private MainMenu mainMenu;
    private boolean menuActive;

    private Stage mainStage;
    private Scene mainScene;

    public static void main(String[] args) {

        Player p = new Player();

        tileObject item = new Item(4,5);
        tileObject damage = new expEffect(2,5, 1);

        tile t = new tile(damage);
        p.occupy = new Occupy(p, t);
        t.holding = new Holding(t, damage);

        ((expEffect) damage).startexp();
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
        map = new Map();
        player = new Player();
        mainMenu = new MainMenu(player, gc, canvas, mainStage, mainScene);
        view = new View(gc, canvas, player, mainMenu);
        keyHandler = new KeyHandler(view, this);
        menuView = new MenuView(player, gc, canvas);


        for (int i = 0; i < 15; i++) {
            player.getInventory().addItembyID(i);
        }

        mainMenu.openMainMenu();

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(keyHandler);
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                //double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                view.render(map.getState(), player);
            }
        }.start();
        theStage.show();
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
