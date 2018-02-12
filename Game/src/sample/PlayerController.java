package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class PlayerController implements EventHandler<KeyEvent> {
    private Map map;
    private Player player;
    private boolean paused;
    private View view;
    public PlayerController(Map map, View view) {
        this.map = map;
        this.view = view;
        player = map.getPlayer();
        paused = false;
    }

    public void handle(KeyEvent event) {
        Point p = new Point(player.getPosition());
        if(paused) { return; }
        switch(event.getCode()) {
            case UP:
                p.y--;
                view.Up();
                map.movePlayer(p);
                break;
            case NUMPAD8:
                p.y--;
                view.Up();
                map.movePlayer(p);
                break;
            case RIGHT:
                p.x++;
                view.Right();
                map.movePlayer(p);
                break;
            case NUMPAD6:
                p.x++;
                view.Right();
                map.movePlayer(p);
                break;
            case DOWN:
                p.y++;
                view.Down();
                map.movePlayer(p);
                break;
            case NUMPAD2:
                p.y++;
                view.Down();
                map.movePlayer(p);
                break;
            case LEFT:
                p.x--;
                view.Left();
                map.movePlayer(p);
                break;
            case NUMPAD4:
                p.x--;
                view.Left();
                map.movePlayer(p);
                break;
            case NUMPAD7: //NW
                p.x--; p.y--;
                view.Left(); view.Up();
                map.movePlayer(p);
                break;
            case NUMPAD9: //NE
                p.x++; p.y--;
                view.Right(); view.Up();
                map.movePlayer(p);
                break;
            case NUMPAD3: //SE
                p.x++; p.y++;
                view.Right(); view.Down();
                map.movePlayer(p);
                break;
            case NUMPAD1: //SW
                p.x--; p.y++;
                view.Left(); view.Down();
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
