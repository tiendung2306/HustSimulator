package Inventory;

import Mouse.MouseManager;
import main.GamePanel;
import main.Main;
import tile.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Inventory implements ActionListener {
    InventoryPage[] pages;
    InventoryUI inventoryUI;
    GamePanel gamePanel;
    Rectangle[][] BoundingBox;
    InventoryComponent inventoryBag, inventoryPlayer, inventoryTask;
    InventoryComponent leftArrow, rightArrow, backArrow;
    InventoryComponent informationBoardBackArrow;
    InventoryComponent informationBoard;
    JPopupMenu popMenu;
    JMenuItem item1, item2, item3;

    public Tile usingItem = new Tile();

    int slotX, slotY;
    boolean reverse = false;
    int step = 0;
    public int currentIndex = 0;
    boolean isGettingInformation = false;
    public boolean isUsingItem = false;

    public Inventory(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        pages = new InventoryPage[3];
        inventoryUI = new InventoryUI(gamePanel);
        for (int i = 0; i < 3; ++i) {
            pages[i] = new InventoryPage();
        }
        setPopMenu();
        GetInventoryInfo();
        setBoundingBox();
    }
    public void setPopMenu(){
        popMenu = new JPopupMenu();

        item1 = new JMenuItem("Use");
        item1.addActionListener(this);
        item1.setActionCommand("Use");
        popMenu.add(item1);

        item2 = new JMenuItem("Drop");
        item2.addActionListener(this);
        item2.setActionCommand("Drop");
        popMenu.add(item2);

        item3 = new JMenuItem("Info");
        item3.addActionListener(this);
        item3.setActionCommand("Info");
        popMenu.add(item3);
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

        BoundingBox[1][0].x = 155 * gamePanel.scale + gamePanel.scale / 3;
        BoundingBox[1][0].y = 63 * gamePanel.scale;

        BoundingBox[2][0].x = 188 * gamePanel.scale;
        BoundingBox[2][0].y = 63 * gamePanel.scale;

        BoundingBox[0][1].x = 123 * gamePanel.scale;
        BoundingBox[0][1].y = 95 * gamePanel.scale + gamePanel.scale / 3;

        BoundingBox[1][1].x = 155 * gamePanel.scale + gamePanel.scale / 3;
        BoundingBox[1][1].y = 95 * gamePanel.scale + gamePanel.scale / 3;

        BoundingBox[2][1].x = 188 * gamePanel.scale;
        BoundingBox[2][1].y = 95 * gamePanel.scale + gamePanel.scale / 3;

        BoundingBox[0][2].x = 123 * gamePanel.scale;
        BoundingBox[0][2].y = 128 * gamePanel.scale;

        BoundingBox[1][2].x = 155 * gamePanel.scale + gamePanel.scale / 3;
        BoundingBox[1][2].y = 128 * gamePanel.scale;

        BoundingBox[2][2].x = 188 * gamePanel.scale;
        BoundingBox[2][2].y = 128 * gamePanel.scale;
    }
    public void GetInventoryInfo(){

        inventoryBag = new InventoryComponent();
        inventoryBag.BoundingBox.x = 70 * gamePanel.scale;
        inventoryBag.BoundingBox.y = 0;
        inventoryBag.BoundingBox.width = 250 * gamePanel.scale;
        inventoryBag.BoundingBox.height = 250 * gamePanel.scale;

        inventoryPlayer = new InventoryComponent();
        inventoryPlayer.BoundingBox.x = -33 * gamePanel.scale;
        inventoryPlayer.BoundingBox.y = 20 * gamePanel.scale;
        inventoryPlayer.BoundingBox.width = 150 * gamePanel.scale;
        inventoryPlayer.BoundingBox.height = 150 * gamePanel.scale;

        inventoryTask = new InventoryComponent();
        inventoryTask.BoundingBox.x = 89 * gamePanel.scale;
        inventoryTask.BoundingBox.y = -15 * gamePanel.scale;
        inventoryTask.BoundingBox.width = 150 * gamePanel.scale;
        inventoryTask.BoundingBox.height = 150 * gamePanel.scale;

        rightArrow = new InventoryComponent();
        rightArrow.BoundingBox.x = 228 * gamePanel.scale;
        rightArrow.BoundingBox.y = 96 * gamePanel.scale;
        rightArrow.BoundingBox.width = 20 * gamePanel.scale;
        rightArrow.BoundingBox.height = 17 * gamePanel.scale;

        leftArrow = new InventoryComponent();
        leftArrow.BoundingBox.x = 82 * gamePanel.scale;
        leftArrow.BoundingBox.y = 96 * gamePanel.scale;
        leftArrow.BoundingBox.width = 20 * gamePanel.scale;
        leftArrow.BoundingBox.height = 17 * gamePanel.scale;

        backArrow = new InventoryComponent();
        backArrow.BoundingBox.x = 101 * gamePanel.scale;
        backArrow.BoundingBox.y = 19 * gamePanel.scale;
        backArrow.BoundingBox.width = 14 * gamePanel.scale;
        backArrow.BoundingBox.height = 11 * gamePanel.scale;

        informationBoard = new InventoryComponent();
        informationBoard.BoundingBox.x = 24 * gamePanel.scale;
        informationBoard.BoundingBox.y = 40 * gamePanel.scale;
        informationBoard.BoundingBox.width = 200 * gamePanel.scale;
        informationBoard.BoundingBox.height = 110 * gamePanel.scale;

        informationBoardBackArrow = new InventoryComponent();
        informationBoardBackArrow.BoundingBox.x = 39 * gamePanel.scale;
        informationBoardBackArrow.BoundingBox.y = 49 * gamePanel.scale;
        informationBoardBackArrow.BoundingBox.width = 12 * gamePanel.scale;
        informationBoardBackArrow.BoundingBox.height = 8 * gamePanel.scale;


        try {
            inventoryBag.image = ImageIO.read(new FileInputStream("res/inventory/Inventory.png"));
            inventoryTask.image = ImageIO.read(new FileInputStream("res/inventory/InventoryTask.png"));
            inventoryPlayer.image = ImageIO.read(new FileInputStream("res/player/character_stand_right (2).png"));
            leftArrow.image = ImageIO.read(new FileInputStream("res/inventory/LeftArrow.png"));
            rightArrow.image = ImageIO.read(new FileInputStream("res/inventory/RightArrow.png"));
            informationBoard.image = ImageIO.read(new File("res/inventory/InformationBoard.png"));
            informationBoardBackArrow.image = ImageIO.read(new File("res/inventory/LeftArrow.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void pushToInventory(Tile tile){
        for (int pageIndex = 0; pageIndex < 3; ++pageIndex)
            for (int y = 0; y < 3; ++y)
                for (int x = 0; x < 3; ++x)
                {
                    if (pages[pageIndex].slot[x][y].Name.equals(tile.Name)){
                        ++pages[pageIndex].slot[x][y].numOwn;
                        return;
                    }
                }
        for (int pageIndex = 0; pageIndex < 3; ++pageIndex)
            for (int y = 0; y < 3; ++y)
                for (int x = 0; x < 3; ++x){
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
    public void update(){
        if (isGettingInformation)
        {
            if (isLeftClick(informationBoardBackArrow))
                isGettingInformation = false;
            return;
        }
        if (isLeftClick(backArrow)){
            Main.popGameState();
            return;
        }
        ++step;
        if (step == 6){
            if (!reverse) {
                leftArrow.BoundingBox.x -= gamePanel.scale;
                rightArrow.BoundingBox.x += gamePanel.scale;
                if (rightArrow.BoundingBox.x == 233 * gamePanel.scale){
                    reverse = true;
                }
            }
            else {
                leftArrow.BoundingBox.x += gamePanel.scale;
                rightArrow.BoundingBox.x -= gamePanel.scale;
                if (rightArrow.BoundingBox.x == 230 * gamePanel.scale){
                    reverse = false;
                }
            }
            step = 0;
        }
        if (currentIndex < 2 && isLeftClick(rightArrow))
            ++currentIndex;
        if (currentIndex > 0 && isLeftClick(leftArrow))
            --currentIndex;
        if (MouseManager.isRightMouseClick) {
            for (int x = 0; x < 3; ++x)
                for (int y = 0; y < 3; ++y){
                    if (MouseManager.lastReleasedX >= BoundingBox[x][y].x && MouseManager.lastReleasedX <= BoundingBox[x][y].x + BoundingBox[x][y].width
                     && MouseManager.lastReleasedY >= BoundingBox[x][y].y && MouseManager.lastReleasedY <= BoundingBox[x][y].y + BoundingBox[x][y].height){
                        MouseManager.isRightMouseClick = false;
                        slotX = x;
                        slotY = y;

                        if (!pages[currentIndex].slot[x][y].Name.equals("Empty"))
                            popMenu.show(gamePanel, MouseManager.lastReleasedX, MouseManager.lastReleasedY);
                    }
                }
        }
    }
    public void draw(Graphics2D g2){
        if (Main.topGameState().equals("Inventory")) {
            Color myColor = new Color(45, 39, 39, 190);
            g2.setColor(myColor);
            g2.fillRect(0, 0, gamePanel.screenWidth, gamePanel.screenHeight);
            inventoryUI.draw(g2, inventoryBag);
            inventoryUI.draw(g2, inventoryTask);
            inventoryUI.draw(g2, inventoryPlayer);
            if (currentIndex < 2)
                inventoryUI.draw(g2, rightArrow);
            if (currentIndex > 0)
                inventoryUI.draw(g2,leftArrow);
            for (int i = 0; i < 3; ++i)
                for (int j = 0; j < 3; ++j) {
                    if (!pages[currentIndex].slot[i][j].Name.equals("Empty")){
                        inventoryUI.drawIcon(g2, BoundingBox[i][j], pages[currentIndex].slot[i][j]);
                    }
                }
            if (isGettingInformation) {
                g2.fillRect(0, 0, gamePanel.screenWidth, gamePanel.screenHeight);
                showInformation(g2, pages[currentIndex].slot[slotX][slotY]);
            }
        }
    }
    void showInformation(Graphics2D g2, Tile tile){
        inventoryUI.draw(g2, informationBoard);
        inventoryUI.draw(g2,informationBoardBackArrow);
        g2.drawImage(tile.image, 43 * gamePanel.scale, 81 * gamePanel.scale, 50 * gamePanel.scale, 50 * gamePanel.scale, null);
        int FontSize = 30;
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        g2.drawString(tile.Name, 67 * gamePanel.scale, 56 * gamePanel.scale);
        FontSize = 25;
        int FontPixel = 11;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        int x = 110 * gamePanel.scale;
        int y = 77 * gamePanel.scale;
        String str = "";
        int strSize = 0;
        for (int i = 0; i < tile.Description.length(); ++i){
            strSize += FontPixel;
            if (tile.Description.charAt(i) == ' '){
                for (int j = i + 1; j <= tile.Description.length(); ++j)
                    if (j == tile.Description.length() || tile.Description.charAt(j) == ' '){
                        if (strSize + (j - i - 1) * FontPixel >= informationBoard.BoundingBox.width / 3 * 2 - gamePanel.tileSize * 2){
                            g2.drawString(str, x, y);
                            str = "";
                            y += 40;
                            strSize = 0;
                        }
                        break;
                    }
                if (strSize > 0)
                    str += ' ';
            } else str += tile.Description.charAt(i);
        }
        if (strSize > 0)
            g2.drawString(str, x, y);
    }
    boolean isLeftClick(InventoryComponent comp){
        if (MouseManager.isLeftMouseClick && MouseManager.lastReleasedX >= comp.BoundingBox.x && MouseManager.lastReleasedX <= comp.BoundingBox.x + comp.BoundingBox.width
                && MouseManager.lastReleasedY >= comp.BoundingBox.y && MouseManager.lastReleasedY <= comp.BoundingBox.y + comp.BoundingBox.height) {
            MouseManager.isLeftMouseClick = false;
            return true;
        }
        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Use": {
                isUsingItem = true;
                usingItem = pages[currentIndex].slot[slotX][slotY];
                break;
            }
            case "Drop": {
                popFromInventory(currentIndex,slotX, slotY);
                break;
            }
            case "Info": {
                isGettingInformation = true;
                break;
            }
        }
    }
}
