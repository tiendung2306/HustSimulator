package area.C2;

import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;
import npc.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class C2_hall extends Map {
    Tile background;
    GamePanel gamePanel;
    Npc teacher1;
    Tile spawn_point;


    public C2_hall(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * background.image.getHeight() / (50 * background.getHeight()));
    }
    
    private void SetOriginalSize(){

        width = background.getWidth();
        height = background.getHeight();
    }

    private void ReSize(double scale){
        background.setWidth((int)(background.getWidth() * scale));
        background.setHeight((int)(background.getHeight() * scale));

        spawn_point.resize(scale);

        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = background.getWidth();
        height = background.getHeight();

        SetPos();

    }

    private void SetPos(){
        playerX = spawn_point.getLeftX();
        playerY = spawn_point.getTopY();

        teacher1 = new Npc(gamePanel, (int)(width * 1.0 / 2), (int)(height * 1.0 / 2), (int)(gamePanel.player.boundingBox.getWidth() * 2 / 3), (int)(gamePanel.player.boundingBox.getHeight()));

    }

    private void TileLoad() {
        tileContainer = new Tile[5];

        try {
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/C2_hall.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "", null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        spawn_point = new Tile(new Rectangle(120 , 569 , 35 , 53), "", "", null, null);

    }

    public void open(){
        loadMap(gamePanel);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        teacher1.operation(g2);
        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
