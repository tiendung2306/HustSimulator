package area;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.Animation_player;
import main.GamePanel;
import main.Main;
import map.Map;
import tile.Object;
import tile.Tile;



public class Section_1 extends Map {
    public Tile background, C1, C2, C9, hall, hallway_entry;
    Tile spawn_point;


    public Section_1(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 2605 / (60 * background.getHeight()));
    }
    
    private void SetOriginalSize(){
        background.setWidth(background.image.getWidth());
        background.setHeight(background.image.getHeight());

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

        SetPlayerPos();

    }

    private void SetPlayerPos(){
        playerX = spawn_point.LeftX;
        playerY = spawn_point.TopY;
    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/Section1_demo.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "", null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }


        // C9 = new Tile(new Rectangle(101, 1720, 793, 389), "C9", "Obstacle", null, null);
        C2 = new Tile(new Rectangle(305, 754, 402, 965), "C2", "Obstacle", null, null);
        C1 = new Tile(new Rectangle(472, 238, 1716, 373), "C1", "Obstacle", null, null);

        hall = new Tile(new Rectangle(696 , 1027 , 86 , 574), "C2_Hallway_entry_stair", "Obstacle", null, null);
        hallway_entry = new Tile(new Rectangle(781 , 1137 , 203 , 211), "C2_Hallway_entry_stair", "Teleport", null, null);

        spawn_point = new Tile(new Rectangle(1009 , 1210 , 35 , 60), "spawn_point", "", null, null);

        // addTile(C9);
        addTile(C2);
        addTile(C1);

        addTile(hall);
        addTile(hallway_entry);

        addTile(new Tile(new Rectangle(615 , 1626 , 89 , 366), "C9_C2_link", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(616 , 1739 , 97 , 253), "C9_C2_link", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(705 , 1655 , 21 , 84), "C9_C2_link_stair_entry", "Teleport", null, null));

        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type1/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));

        
        Rectangle[] tmp1 = {new Rectangle(81,1692,161,154),new Rectangle(235,1722,695,107),new Rectangle(101,1815,795,207)};
        Rectangle[] tmp2 = {new Rectangle(102,1988,794,126),new Rectangle(604,2050,169,102)};
        Object tmp = new Object(this, "C9", "C9", new Rectangle(79, 1693, 858, 468), tmp1, tmp2);
        addObject(tmp);
    }

    public void open(){
        loadMap(gamePanel);
    }

    public void close(){
        Main.popGameState();
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        boolean is_player_display = false;
        for(Object object : objectContainer){
            if(is_player_display == false){
                if(object.getTop() <= gamePanel.player.getHitArea().y + gamePanel.player.getHitArea().height){
                    // gamePanel.player.draw(g2);
                    is_player_display = true;
                }
            }
            object.operation(g2);
        }

        if(is_player_display == false)
            gamePanel.player.draw(g2);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
