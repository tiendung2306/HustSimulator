package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Toturial extends JPanel {

    private BufferedImage background;

    private String check = null;

    public Toturial() {
        getImage();
    }
    public void getImage() {
        try {
            background = ImageIO.read(new FileInputStream("res/MainmenuImage/NextMainMenuMo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Init() {
        check = "";
    }
    public void update() {

    }
    public void draw(Graphics2D g2) {
        g2.drawImage(background, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);

        super.paintComponent(g2);
    }
}
