package map;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import animation.Animation_player;
import main.GamePanel;
import main.Main;
import tile.ExtraTile;
import tile.Object;
import tile.Tile;

public class Map {
    public GamePanel gamePanel;
    public int mapIndex;
    public int numExtraTile;
    public int width, height;
    public int org_width, org_height;
    public int numTileContainer;
    public int playerX, playerY;
    public Tile[] tileContainer;
    public static int prevScale = (int) GamePanel.scale;
    public ExtraTile[] extraTile;
    public Vector<Object> objectContainer = new Vector<Object>();
    public Animation_player map_exchange_effect;
    public Tile background;

    public void addTile(Tile tile) {
        tileContainer[numTileContainer++] = tile;
    }

    public void addObject(Object object) {
        objectContainer.add(object);
    }

    public void ObjectLoad(String name) {
        try {
            String path = "src/txt/" + name + ".txt";
            BufferedReader source = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            while (true) {

                String line = source.readLine();

                if (line.equals("#"))
                    break;

                else if (line.equals("*")) {

                    Object object = new Object(this);

                    boolean next = true;
                    while (next) {
                        String value = source.readLine();
                        String values[] = value.split(" ");
                        switch (values[0]) {
                            case "Name":
                                object.setName(values[1]);
                                break;

                            case "Type":
                                object.setType(values[1]);
                                break;

                            case "Trans":
                                object.setTrans(Double.parseDouble(values[1]));
                                break;

                            case "Image":
                                switch (object.getType()) {
                                    case "non-animated":
                                        object.setImageBox(
                                                new Rectangle(Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                                                        Integer.parseInt(values[3]), Integer.parseInt(values[4])),
                                                0, 0);
                                        break;

                                    case "animated":
                                        object.setImageBox(
                                                new Rectangle(Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                                                        Integer.parseInt(values[3]), Integer.parseInt(values[4])),
                                                Integer.parseInt(values[5]), Double.parseDouble(values[6]));
                                        break;

                                    default:
                                        break;
                                }
                                break;

                            case "Body":
                                for (int i = 1; i < values.length; i += 4)
                                    object.addBodyHitbox(
                                            new Rectangle(Integer.parseInt(values[i]), Integer.parseInt(values[i + 1]),
                                                    Integer.parseInt(values[i + 2]), Integer.parseInt(values[i + 3])));
                                break;

                            case "Foot":
                                for (int i = 1; i < values.length; i += 4)
                                    object.addFootHitbox(
                                            new Rectangle(Integer.parseInt(values[i]), Integer.parseInt(values[i + 1]),
                                                    Integer.parseInt(values[i + 2]), Integer.parseInt(values[i + 3])));
                                next = false;
                                break;

                            default:
                                break;
                        }
                    }
                    addObject(object);
                }
            }
            source.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void objectSort(){
        Collections.sort(objectContainer, new Comparator<Object>() {
            @Override public int compare(Object object1, Object object2){
                if(object1.getBot() > object2.getBot())
                    return 1;
                else if (object1.getBot() == object2.getBot())
                    return 0;
                else 
                    return -1;
            }
        });
    }

    public void addExtraTile(String src) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
            String line = "";
            String[] tokens;

            while (line.isEmpty())
                line = reader.readLine();
            tokens = line.split(" ");
            numExtraTile = Integer.parseInt(tokens[0]);
            for (int i = 0; i < numExtraTile; ++i) {
                extraTile[i] = new ExtraTile();
                line = reader.readLine();
                tokens = line.split(" ");
                extraTile[i].Name = tokens[0];
                extraTile[i].Type = tokens[1];
                extraTile[i].numPoint = Integer.parseInt(tokens[2]);
                for (int j = 0; j < extraTile[i].numPoint; ++j) {
                    line = reader.readLine();
                    tokens = line.split(" ");
                    extraTile[i].x[j] = (int) (Integer.parseInt(tokens[0]) * GamePanel.scale);
                    extraTile[i].y[j] = (int) (Integer.parseInt(tokens[1]) * GamePanel.scale);
                }
                extraTile[i].x[extraTile[i].numPoint] = extraTile[i].x[0];
                extraTile[i].y[extraTile[i].numPoint] = extraTile[i].y[0];
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void deleteTile(int index) {
        --numTileContainer;
        for (int i = index; i < numTileContainer; ++i)
            tileContainer[i] = tileContainer[i + 1];
    }

    public void loadMap(GamePanel gamePanel) {
        gamePanel.currentMap = this;
        if (map_exchange_effect != null) {
            map_exchange_effect.setState("run");
            map_exchange_effect.setTimer(1.0);
            Main.pushGameState("Loading");
        }
        gamePanel.player.setMapX(playerX);
        gamePanel.player.setMapY(playerY);
        gamePanel.player.posUpdate();
        gamePanel.directionIndicator.resetArrow();

    }

    public void reSizeMap() {}

    public void floorDisplay(Graphics2D g2) {}

    public void TileDisplay(Graphics2D g2){}

    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);

        boolean is_player_display = false;
        for (Object object : objectContainer) {
            // System.out.println(object.name);
            if (is_player_display == false) {
                boolean is_player_behind = true;
                for (Tile footbox : object.getFoot())
                    if (footbox.getBottomY() <= gamePanel.player.getHitArea().y
                            + gamePanel.player.getHitArea().height) {
                        is_player_behind = false;
                        break;
                    }
                if (is_player_behind == true) {
                    TileDisplay(g2);
                    gamePanel.directionIndicator.drawArrow(g2);
                    gamePanel.player.draw(g2);
                    is_player_display = true;
                }
                object.operation(g2);
            }

            else
                object.operation(g2);
        }

        floorDisplay(g2);

        if (is_player_display == false) {
            TileDisplay(g2);
            gamePanel.directionIndicator.drawArrow(g2);
            gamePanel.player.draw(g2);
        }
    }

}
