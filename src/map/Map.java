package map;

import main.GamePanel;
import tile.ExtraTile;
import tile.Tile;

import java.io.*;

public class Map {
    GamePanel gamePanel;
    public int mapIndex;
    public int maxMapCol, maxMapRow;
    public int numExtraTile;
    public int numTileContainer;
    public int playerX, playerY;
    public Tile [] tileContainer;
    public ExtraTile[] extraTile;
    public void addTile(Tile tile){
        tileContainer[numTileContainer++] = tile;
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
        gamePanel.mapWidth = (int) (maxMapCol * 16 * GamePanel.scale);
        gamePanel.mapHeight = (int) (maxMapRow * 16 * GamePanel.scale);
        gamePanel.player.setMapX(playerX);
        gamePanel.player.setMapY(playerY);
    }
    public void reSizeMap(GamePanel gamePanel) {
        gamePanel.mapWidth = (int) (maxMapCol * 16 * GamePanel.scale);
        gamePanel.mapHeight = (int) (maxMapRow * 16 * GamePanel.scale);
    }
}
