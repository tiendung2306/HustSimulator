package map;

import main.GamePanel;
import main.Main;
import tile.ExtraTile;
import tile.Tile;
import tile.Object;

import animation.*;

import java.awt.Graphics2D;
import java.io.*;
import java.util.Vector;

public class Map {
    public GamePanel gamePanel;
    public int mapIndex;
    public int maxMapCol, maxMapRow;
    public int numExtraTile;
    public int width, height;
    public int org_width, org_height;
    public int numTileContainer;
    public int playerX, playerY;
    public Tile [] tileContainer;
    public ExtraTile[] extraTile;
    public Vector <Object> objectContainer =  new Vector <Object>();
    public Animation_player map_exchange_effect;

    
    public void addTile(Tile tile){
        tileContainer[numTileContainer++] = tile;
    }

    public void addObject(Object object){
        objectContainer.add(object);
    }

    public void addExtraTile(String src){
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
    public void deleteTile(int index){
        --numTileContainer;
        for (int i = index; i < numTileContainer; ++i)
            tileContainer[i] = tileContainer[i + 1];
    }
    public void loadMap(GamePanel gamePanel){
        gamePanel.currentMap = this;
        if(map_exchange_effect != null){
            map_exchange_effect.setState("run");
            map_exchange_effect.setTimer(1.0);
            Main.pushGameState("Loading");
        }
        // gamePanel.mapWidth = (int) (maxMapCol * 16 * GamePanel.scale);
        // gamePanel.mapHeight = (int) (maxMapRow * 16 * GamePanel.scale);
        gamePanel.player.setMapX(playerX);
        gamePanel.player.setMapY(playerY);
    }
    public void reSizeMap(GamePanel gamePanel) {
        // gamePanel.mapWidth = (int) (maxMapCol * 16 * GamePanel.scale);
        // gamePanel.mapHeight = (int) (maxMapRow * 16 * GamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        
    }

}
