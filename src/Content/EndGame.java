package Content;

import Mouse.MouseManager;
import main.GamePanel;
import main.Main;
import sound.SoundManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class EndGame {
    public BufferedImage endGame,ok1,ok2,ok3;
    GamePanel gamePanel;
    public Boolean checkSoundEndGame = true;
    public EndGame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
    }
    public void getImage() {
        try {
            endGame = ImageIO.read(new FileInputStream("res/congratulation/end_game.png"));
            ok1 = ImageIO.read(new FileInputStream("res/tile/no_thing.png"));
            ok2 = ImageIO.read(new FileInputStream("res/congratulation/ok.png"));
            ok3 = ImageIO.read(new FileInputStream("res/tile/no_thing.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.scale(1,1);
            g2.drawImage(endGame, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
            g2.drawImage(ok1, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
    }

    public void MouseClick() {
        if(MouseManager.lastReleasedX>= (int) (300 * Main.ex) && MouseManager.lastReleasedX <= (int) (455 * Main.ex) && MouseManager.lastReleasedY >= (int) (471 * Main.ey) && MouseManager.lastReleasedY <=  (int) (512 * Main.ey)) {
            Main.emptyGameState();
            Main.pushGameState("MainMenu");
            SoundManager.playSound("click");
            SoundManager.stopAllSound();
        }
    }

    public void HoverCheck() {
        if(gamePanel.mouseManager.mouseCurrentX() >= (int) (300 * Main.ex) && gamePanel.mouseManager.mouseCurrentX() <= (int) (455 * Main.ex) && gamePanel.mouseManager.mouseCurrentY() >= (int) (471 * Main.ey) && gamePanel.mouseManager.mouseCurrentY() <=  (int) (512 * Main.ey)) {
            ok1 = ok2;
        }
        else  {
            ok1 = ok3;
        }
    }
}
