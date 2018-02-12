package sample;

import java.io.*;
import java.io.File;
import java.time.Duration;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {

    //private String workingDir =

    String path = System.getProperty("user.dir") + "\\Game\\src\\sample\\music\\mainMenuMusic.mp3";

    Media mainMenuMusic = new Media(new File(path).toURI().toString());
    MediaPlayer mainMenuMusicPlayer = new MediaPlayer(mainMenuMusic);


    public void playMainMenuMusic() {
        mainMenuMusicPlayer.setStartTime(new javafx.util.Duration(22000));
        mainMenuMusicPlayer.play();
    }

    public void stopMainMenuMusic() {
        mainMenuMusicPlayer.stop();
    }



}
