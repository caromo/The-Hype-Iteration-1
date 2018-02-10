package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class PlayerController implements EventHandler<KeyEvent> {
    private Map map;
    private Player player;
    public PlayerController(Map map) {
        this.map = map;
        player = map.getPlayer();
    }

    public void handle(KeyEvent event) {
        Point p = new Point(player.getPosition());

        //p.x = player.getPosition().x;
        //p.y = player.getPosition().y;

        switch(event.getCode()) {
            case UP:
                p.y--;
                map.movePlayer(p);
                break;
            case RIGHT:
                p.x++;
                map.movePlayer(p);
                break;
            case DOWN:
                p.y++;
                map.movePlayer(p);
                break;
            case LEFT:
                p.x--;
                map.movePlayer(p);
                break;
        }
    }
}
