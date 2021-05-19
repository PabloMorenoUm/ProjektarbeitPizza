package view;

import javax.swing.*;


public class ImageLabel extends JLabel{

    public ImageLabel(String imageURL) {
        super();
        try {
            ImageIcon icon = new ImageIcon(imageURL);
            this.setIcon(icon);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }




}
