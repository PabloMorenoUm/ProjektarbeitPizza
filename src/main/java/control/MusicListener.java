package control;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MusicListener implements ActionListener {
    private Player player;
    private Thread thread;

    public MusicListener() {
        thread = new Thread(runnable);
    }

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
