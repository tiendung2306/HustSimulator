package area;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.Animation_player;
import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;

public class Section_1 extends Map {
    public Tile hallway_entry;
    Tile spawn_point;

    public Section_1(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        SetDefaultValues();
    }

    private void SetDefaultValues() {
        TileLoad();
        ObjectLoad("Section1");
        objectSort();
        SetOriginalSize();
        reSizeMap();
    }

    private void SetOriginalSize() {
        background.setWidth(background.image.getWidth());
        background.setHeight(background.image.getHeight());

        width = background.getWidth();
        height = background.getHeight();
    }

    private void ReSize(double scale) {
        background.setWidth((int) (background.getWidth() * scale));
        background.setHeight((int) (background.getHeight() * scale));

        spawn_point.resize(scale);

        map_exchange_effect.resize(GamePanel.screenWidth / (2 * map_exchange_effect.getWidth()));

        for (int i = 0; i < numTileContainer; i++) {
            tileContainer[i].resize(scale);

        }

        width = background.getWidth();
        height = background.getHeight();

        SetPlayerPos();

    }

    private void SetPlayerPos() {
        playerX = spawn_point.LeftX;
        playerY = spawn_point.TopY;
    }

    private void TileLoad() {
        tileContainer = new Tile[250];

        try {
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/Section1_demo.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "",
                    null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // C9 = new Tile(new Rectangle(101, 1720, 793, 389), "C9", "Obstacle", null,
        // null);

        hallway_entry = new Tile(new Rectangle(880, 1092, 36, 159), "C2_Hallway_entry_stair", "Teleport", null, null);

        spawn_point = new Tile(new Rectangle(1009, 1210, 35, 60), "spawn_point", "", null, null);

        // addTile(C9);

        addTile(hallway_entry);

        addTile(new Tile(new Rectangle(731, 168, 1386, 372), "C1", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(711, 288, 21, 300), "C1", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(404, 287, 307, 325), "C1", "Obstacle", null, null));

        addTile(new Tile(new Rectangle(219, 684, 414, 879), "C2", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(558, 462, 77, 224), "C1_C2_link", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(548, 1544, 99, 379), "C9_C2_link", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(634, 1584, 23, 85), "C9_C2_link_stair_entry", "Teleport", null, null));

        addTile(new Tile(new Rectangle(636, 957, 79, 574), "C2_Hallway", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(702, 1067, 141, 211), "C2_Hallway", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(843, 1060, 85, 34), "Block", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(843, 1251, 84, 31), "Block", "Obstacle", null, null));

        addTile(new Tile(new Rectangle(635, 957, 79, 573), "C2_Hallway", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(636, 1069, 206, 210), "C2_Hallway", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(844, 1058, 27, 35), "Block", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(851, 1063, 78, 29), "Block", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(844, 1251, 84, 31), "Block", "Obstacle", null, null));

        addTile(new Tile(new Rectangle(1842 , 675 , 531 , 1557), "Barrier", "Obstacle", null, null));
        
        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type1/frame ", 4, 0.8,
                new Rectangle((int) (GamePanel.screenWidth / 4),
                        (int) (GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4),
                        (int) (GamePanel.screenWidth / 2), (int) (GamePanel.screenWidth / 2)));

        // Rectangle[] tmp1 = {new Rectangle(32,1757,795,165),new
        // Rectangle(172,1649,690,111),new Rectangle(12,1624,161,151)};
        // Rectangle[] tmp2 = {new Rectangle(537,2037,167,39),new
        // Rectangle(31,2036,141,8),new Rectangle(30,2019,794,20),new
        // Rectangle(30,1920,797,101)};
        // Object tmp = new Object(this, "C9", "C9", new Rectangle(9, 1619, 855, 462),
        // tmp1, tmp2);
        // addObject(tmp);
    }

    public void open() {
        reSizeMap();
        loadMap(gamePanel);
    }

    @Override
    public void reSizeMap() {
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 2605 / (60 * background.getHeight()));
    }

    public void close() {
        Main.popGameState();
    }

}
