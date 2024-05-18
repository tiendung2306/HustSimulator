package area.C2;

import main.GamePanel;
import map.Map;
import tile.Tile;
import npc.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import animation.Animation_player;

import java.io.*;


public class C2_hall extends Map {
    Tile layer1, layer2;
    GamePanel gamePanel;
    Npc teacher1, security_man;
    Tile spawn_point;


    public C2_hall(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * layer1.image.getHeight() / (50 * layer1.getHeight()));
    }
    
    private void SetOriginalSize(){

        width = layer1.getWidth();
        height = layer1.getHeight();
    }

    private void ReSize(double scale){
        layer1.setWidth((int)(layer1.getWidth() * scale));
        layer1.setHeight((int)(layer1.getHeight() * scale));

        layer2.setWidth((int)(layer2.getWidth() * scale));
        layer2.setHeight((int)(layer2.getHeight() * scale));

        spawn_point.resize(scale);

        map_exchange_effect.resize(GamePanel.screenWidth / (2 * map_exchange_effect.getWidth()));

        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);
        }
                
        width = layer1.getWidth();
        height = layer1.getHeight();

        SetPos();

    }

    private void SetPos(){
        playerX = spawn_point.getLeftX();
        playerY = spawn_point.getTopY();


    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage layer1_img = ImageIO.read(new FileInputStream("res/tile/C2_hall_layer (1).png"));
            layer1 = new Tile(new Rectangle(0, 0, layer1_img.getWidth(), layer1_img.getHeight()), "layer1", "", null, layer1_img);
            BufferedImage layer2_img = ImageIO.read(new FileInputStream("res/tile/C2_hall_layer (2).png"));
            layer2 = new Tile(new Rectangle(0, 0, layer2_img.getWidth(), layer2_img.getHeight()), "layer2", "", null, layer2_img);

        } catch (IOException e) {
            e.printStackTrace();
        }

        spawn_point = new Tile(new Rectangle(120 , 569 , 35 , 53), "", "", null, null);

        addTile(new Tile(new Rectangle(215 , 324 , 570 , 30), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(215 , 355 , 35 , 47), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(287 , 355 , 34 , 46), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(358 , 355 , 35 , 46), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(431 , 355 , 35 , 47), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(502 , 355 , 34 , 47), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(574 , 355 , 34 , 48), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(646 , 355 , 34 , 47), "Desk", "Interact", null, null));
        addTile(new Tile(new Rectangle(718 , 354 , 35 , 48), "Desk", "Interact", null, null));


        addTile(new Tile(new Rectangle(206 , 391 , 6 , 178), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(278 , 390 , 6 , 179), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(351 , 391 , 4 , 178), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(423 , 391 , 5 , 178), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(494 , 391 , 5 , 181), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(565 , 392 , 5 , 178), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(638 , 391 , 5 , 179), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(710 , 391 , 5 , 179), "Barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(780 , 391 , 6 , 177), "Barrier", "Obstacle", null, null));

        addTile(new Tile(new Rectangle(88 , 620 , 110 , 4), "C2_hall_exit", "Teleport", null, null));

        teacher1 = new Npc(gamePanel, new Rectangle( 309 , 299 , 24 , 34), "teacher1");
        security_man = new Npc(gamePanel, new Rectangle( 190 , 270 , 21 , 53), "security_man");

        addTile(teacher1);
        addTile(security_man);

        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type3/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));

    }

    public void open(){
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * layer1.image.getHeight() / (50 * layer1.getHeight()));
        loadMap(gamePanel);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, layer1);
        teacher1.operation(g2);
        security_man.operation(g2);
        gamePanel.tileManager.draw(g2, layer2);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
