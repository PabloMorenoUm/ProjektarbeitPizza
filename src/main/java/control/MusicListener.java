package control;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Listener-Klasse, die eine .mp3-Datei in einem eigenen Thread abspielt und den 'Play/Stop'-Button funktionsfähig macht.
 */
public class MusicListener implements ActionListener {
    private Player player;
    private Thread thread;

    /**
     * Konstruktor
     */
    public MusicListener() {
        thread = new Thread(runnable);
    }

    /**
     * Funktionalität des 'Play/Stop'-Buttons
     * @param e ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(thread.isAlive()){
            if(player != null){
                player.close();
            }
        } else {
            thread = new Thread(runnable);
            thread.start();
        }
    }

    /**
     * Eigene Schnittstelle, die die .mp3 abspielt.
     */
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try{
                FileInputStream fileInputStream = new FileInputStream("2021_04_18_HelloWorld_Audio - 19.04.21, 21.mp3");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                player.play();
            } catch (FileNotFoundException | JavaLayerException fileNotFoundException){
                fileNotFoundException.printStackTrace();
            }
        }
    };
}
