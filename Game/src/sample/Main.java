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

public class Main extends Application {
    private View view;
    private KeyHandler keyHandler;
    private Player player;
    private Map map;
    private MenuView menuView;
    private boolean menuActive;
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "The H Y P E" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 800, 800 );
        root.getChildren().add( canvas );

        menuActive = false;

        GraphicsContext gc = canvas.getGraphicsContext2D();
        map = new Map();
        player = new Player();
        view = new View(gc, canvas);
        keyHandler = new KeyHandler(view, this);
        menuView = new MenuView(player, gc, canvas);

        for(int i = 0; i < 15; i++) {
            player.getInventory().addItembyID(i);
        }




        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(keyHandler);
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {

            public void handle(long currentNanoTime)
            {
                //double t = (currentNanoTime - startNanoTime) / 1000000000.0;



                view.render(map.getMap(), player);
                if(menuActive) {
                    menuView.render();
                }
                

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
}
