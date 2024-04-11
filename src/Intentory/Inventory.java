package Intentory;

import main.GamePanel;
import main.Main;
import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Inventory {
    InventoryPage[] pages;
    InventoryUI inventoryUI;
    GamePanel gamePanel;
    Rectangle[][] BoundingBox;
    InventoryComponent inventoryIcon, inventoryBag, inventoryPlayer, inventoryTask;
    public Inventory(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        pages = new InventoryPage[3];
        inventoryUI = new InventoryUI(gamePanel);
        for (int i = 0; i < 3; ++i) {
            pages[i] = new InventoryPage();
        }
        GetInventoryInfo();
        setBoundingBox();
    }
    public void setBoundingBox(){
        BoundingBox = new Rectangle[3][3];
        for (int x = 0; x < 3; ++x)
            for (int y = 0; y < 3; ++y) {
                BoundingBox[x][y] = new Rectangle();
                BoundingBox[x][y].width = 19 * gamePanel.scale;
                BoundingBox[x][y].height = 19 * gamePanel.scale;
            }
        BoundingBox[0][0].x = 123 * gamePanel.scale;
        BoundingBox[0][0].y = 63 * gamePanel.scale;

        BoundingBox[1][0].x = 155 * gamePanel.scale + 1;
        BoundingBox[1][0].y = 63 * gamePanel.scale;

        BoundingBox[2][0].x = 188 * gamePanel.scale;
        BoundingBox[2][0].y = 63 * gamePanel.scale;

        BoundingBox[0][1].x = 123 * gamePanel.scale;
        BoundingBox[0][1].y = 95 * gamePanel.scale + 1;

        BoundingBox[1][1].x = 155 * gamePanel.scale + 1;
        BoundingBox[1][1].y = 95 * gamePanel.scale + 1;

        BoundingBox[2][1].x = 188 * gamePanel.scale;
        BoundingBox[2][1].y = 95 * gamePanel.scale + 1;

        BoundingBox[0][2].x = 123 * gamePanel.scale;
        BoundingBox[0][2].y = 128 * gamePanel.scale;

        BoundingBox[1][2].x = 155 * gamePanel.scale + 1;
        BoundingBox[1][2].y = 128 * gamePanel.scale;

        BoundingBox[2][2].x = 188 * gamePanel.scale;
        BoundingBox[2][2].y = 128 * gamePanel.scale;
    }
    public void GetInventoryInfo(){

        inventoryIcon = new InventoryComponent();
        inventoryIcon.BoundingBox.x = 0;
        inventoryIcon.BoundingBox.y = 0;
        inventoryIcon.BoundingBox.width = 20 * gamePanel.scale;
        inventoryIcon.BoundingBox.height = 15 * gamePanel.scale;

        inventoryBag = new InventoryComponent();
        inventoryBag.BoundingBox.x = 70 * gamePanel.scale;
        inventoryBag.BoundingBox.y = 0;
        inventoryBag.BoundingBox.width = 250 * gamePanel.scale;
        inventoryBag.BoundingBox.height = 250 * gamePanel.scale;

        inventoryPlayer = new InventoryComponent();
        inventoryPlayer.BoundingBox.x = -25 * gamePanel.scale;
        inventoryPlayer.BoundingBox.y = 20 * gamePanel.scale;
        inventoryPlayer.BoundingBox.width = 150 * gamePanel.scale;
        inventoryPlayer.BoundingBox.height = 150 * gamePanel.scale;

        inventoryTask = new InventoryComponent();
        inventoryTask.BoundingBox.x = 89 * gamePanel.scale;
        inventoryTask.BoundingBox.y = -15 * gamePanel.scale;
        inventoryTask.BoundingBox.width = 150 * gamePanel.scale;
        inventoryTask.BoundingBox.height = 150 * gamePanel.scale;


        try {
            inventoryIcon.image = ImageIO.read(new FileInputStream("res/inventory/InventoryIcon.png"));
            inventoryBag.image = ImageIO.read(new FileInputStream("res/inventory/Inventory.png"));
            inventoryTask.image = ImageIO.read(new FileInputStream("res/inventory/InventoryTask.png"));
            inventoryPlayer.image = ImageIO.read(new FileInputStream("res/player/character_stand_right (2).png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void pushToInventory(Tile tile){
        for (int pageIndex = 0; pageIndex < 3; ++pageIndex)
            for (int x = 0; x < 3; ++x)
                for (int y = 0; y < 3; ++y){
                    if (pages[pageIndex].slot[x][y].Name.equals(tile.Name)){
                        ++pages[pageIndex].slot[x][y].numOwn;
                        return;
                    }
                }
        for (int pageIndex = 0; pageIndex < 3; ++pageIndex)
            for (int x = 0; x < 3; ++x)
                for (int y = 0; y < 3; ++y){
                    if (pages[pageIndex].slot[x][y].Name.equals("Empty")){
                        pages[pageIndex].slot[x][y] = tile;
                        pages[pageIndex].slot[x][y].numOwn = 1;
                        return;
                    }
                }
    }
    public void popFromInventory(int pageIndex, int x, int y){
        if (!pages[pageIndex].slot[x][y].Name.equals("Empty")){
            --pages[pageIndex].slot[x][y].numOwn;
            Tile tile = new Tile(gamePanel.player.getMapX(), gamePanel.player.getMapX() + pages[pageIndex].slot[x][y].getWidth(), gamePanel.player.getMapY() + gamePanel.tileSize, gamePanel.player.getMapY() + gamePanel.tileSize + pages[pageIndex].slot[x][y].getHeight(), pages[pageIndex].slot[x][y].Name, pages[pageIndex].slot[x][y].Type, pages[pageIndex].slot[x][y].image);
            gamePanel.currentMap.addTile(tile);
            if (pages[pageIndex].slot[x][y].numOwn == 0) {
                pages[pageIndex].slot[x][y].Name = "Empty";
            }
        }
    }
    public void draw(Graphics2D g2){
        if (Main.topGameState().equals("GamePlay"))
            inventoryUI.draw(g2, inventoryIcon);
        if (Main.topGameState().equals("Inventory")) {
            Color myColor = new Color(45, 39, 39, 190);
            g2.setColor(myColor);
            g2.fillRect(0, 0, gamePanel.screenWidth, gamePanel.screenHeight);
            inventoryUI.draw(g2, inventoryBag);
            inventoryUI.draw(g2, inventoryTask);
            inventoryUI.draw(g2, inventoryPlayer);
            for (int i = 0; i < 3; ++i)
                for (int j = 0; j < 3; ++j) {
                    if (!pages[0].slot[i][j].Name.equals("Empty")){
                        inventoryUI.drawIcon(g2, BoundingBox[i][j], pages[0].slot[i][j]);
                    }
                }
        }
    }
}
