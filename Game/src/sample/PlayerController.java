package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class PlayerController implements EventHandler<KeyEvent> {
    private Map map;
    private Player player;
    private boolean paused;
    public PlayerController(Map map) {
        this.map = map;
        player = map.getPlayer();
        paused = false;
    }

    public void handle(KeyEvent event) {
        Point p = new Point(player.getPosition());

        //p.x = player.getPosition().x;
        //p.y = player.getPosition().y;
        if(paused) { return; }
        switch(event.getCode()) {
            case UP:
                p.y--;
                map.movePlayer(p);
                break;
            case NUMPAD8:
                p.y--;
                map.movePlayer(p);
                break;
            case RIGHT:
                p.x++;
                map.movePlayer(p);
                break;
            case NUMPAD6:
                p.x++;
                map.movePlayer(p);
                break;
            case DOWN:
                p.y++;
                map.movePlayer(p);
                break;
            case NUMPAD2:
                p.y++;
                map.movePlayer(p);
                break;
            case LEFT:
                p.x--;
                map.movePlayer(p);
                break;
            case NUMPAD4:
                p.x--;
                map.movePlayer(p);
                break;
            case NUMPAD7: //NW
                p.x--; p.y++;
                map.movePlayer(p);
                break;
            case NUMPAD9: //NE
                p.x++; p.y++;
                map.movePlayer(p);
                break;
            case NUMPAD3: //SE
                p.x++; p.y--;
                map.movePlayer(p);
                break;
            case NUMPAD1: //SW
                p.x--; p.y--;
                map.movePlayer(p);
                break;
            case D:
                player.takeDamage(5);
                break;
            case H:
                player.heal(5);
                break;
            case E:
                player.gainExp(5);
                break;

        }
    }

    public void setGamePaused(boolean paused) {
        this.paused = paused;
    }
}
