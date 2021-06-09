package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Hilfsklasse, um ein Titelbild einzubinden. Sofern die Bilddatei nicht zu finden ist, wird ein Fehler ausgeworfen.
 */
public class ImageLabel extends JLabel{

    public ImageLabel(String imageURL) {
        super();
        File bild = new File(imageURL);
        BufferedImage img;
        try {
            img = ImageIO.read(bild);
            ImageIcon icon = new ImageIcon(img);
            this.setIcon(icon);

        } catch (Exception e) {
            e.printStackTrace();
            //throw e;
        }
    }
}
