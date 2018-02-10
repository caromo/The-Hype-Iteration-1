package sample;

//import javax.sound.sampled.AudioInputStream;
import java.util.ArrayList;
//import javax.sound.sampled.AudioSystem;
import java.io.InputStream;
import javax.sound.sampled.*;


public class MusicManager implements LineListener  {

    private ArrayList<String> files;
    private static AudioInputStream stream;
    protected AudioSystem x;
    private Clip clip;

    public MusicManager(String... files)
    {
        create(getFiles());
        for(String file : files)
        {
            add("AudioFiles/" + file + ".wav");
        }

    }


    public void play(String fileName) {
        try {

            Line.Info linfo = new Line.Info(Clip.class);
            Line line = AudioSystem.getLine(linfo);
            setClip((Clip) line);
            getClip().addLineListener(this);
            setStream(AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("AudioFiles/" + fileName)));
            getClip().open(getStream());
            getClip().start();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public AudioInputStream getStream(){
        return stream;
    }

    public static void setStream(AudioInputStream stream) {
        MusicManager.stream = stream;
    }

//    @Override
//    public void run() {
//
//    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public void create(ArrayList<String> files) {
        this.files = new ArrayList<String>();
    }
    public void add(String file){
        this.files.add(file);
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    @Override
    public void update(LineEvent event) {

    }
}
