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
    public static void main(String[] args) {
        Player p = new Player();
        tileObject item = new Item(5);
        tileObject damage = new healingEffect(2,5, 1);

        tile t = new tile(damage);
        p.occupy = new Occupy(p, t);
        t.holding = new Holding(t, damage);
//        Item x = new Item(2);
//        x.giveItem();
        ((healingEffect) damage).startH();
//        ((Item) item).giveItem();

        p.getInventory().printInventory();

        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "The H Y P E" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );
//        tile t = new tile(new MapTransition());
        Player player = new Player();
        player.setPosition(0,0);
//        t.setPosition(0,0);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        view = new View(gc, canvas);
        keyHandler = new KeyHandler();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(keyHandler);
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {

            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                view.render(keyHandler.x, keyHandler.y);


            }
        }.start();

        theStage.show();
    }


}
