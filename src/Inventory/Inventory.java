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
    public Tile infoItem = new Tile();

    int slotX, slotY;
    boolean reverse = false;
    int step = 0;
    public int currentIndex = 0;
    public boolean isGettingInformation = false;
    public boolean isUsingItem = false;

    public Inventory(GamePanel gamePanel) {
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

    public void setPopMenu() {
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

    public void ScreenResize() {
        GetInventoryInfo();
        setBoundingBox();
    }
    public void setBoundingBox() {
        BoundingBox = new Rectangle[3][3];
        for (int x = 0; x < 3; ++x)
            for (int y = 0; y < 3; ++y) {
                BoundingBox[x][y] = new Rectangle();
                BoundingBox[x][y].width = (int) (19 * GamePanel.scale);
                BoundingBox[x][y].height = (int) (19 * GamePanel.scale);
            }
        BoundingBox[0][0].x = (int) (123 * GamePanel.scale);
        BoundingBox[0][0].y = (int) (63 * GamePanel.scale);

        BoundingBox[1][0].x = (int) (155 * GamePanel.scale + GamePanel.scale / 3);
        BoundingBox[1][0].y = (int) (63 * GamePanel.scale);

        BoundingBox[2][0].x = (int) (188 * GamePanel.scale);
        BoundingBox[2][0].y = (int) (63 * GamePanel.scale);

        BoundingBox[0][1].x = (int) (123 * GamePanel.scale);
        BoundingBox[0][1].y = (int) (95 * GamePanel.scale + GamePanel.scale / 3);

        BoundingBox[1][1].x = (int) (155 * GamePanel.scale + GamePanel.scale / 3);
        BoundingBox[1][1].y = (int) (95 * GamePanel.scale + GamePanel.scale / 3);

        BoundingBox[2][1].x = (int) (188 * GamePanel.scale);
        BoundingBox[2][1].y = (int) (95 * GamePanel.scale + GamePanel.scale / 3);

        BoundingBox[0][2].x = (int) (123 * GamePanel.scale);
        BoundingBox[0][2].y = (int) (128 * GamePanel.scale);

        BoundingBox[1][2].x = (int) (155 * GamePanel.scale + GamePanel.scale / 3);
        BoundingBox[1][2].y = (int) (128 * GamePanel.scale);

        BoundingBox[2][2].x = (int) (188 * GamePanel.scale);
        BoundingBox[2][2].y = (int) (128 * GamePanel.scale);
    }

    public void GetInventoryInfo() {

        inventoryBag = new InventoryComponent();
        inventoryBag.BoundingBox.x = (int) (70 * GamePanel.scale);
        inventoryBag.BoundingBox.y = 0;
        inventoryBag.BoundingBox.width = (int) (250 * GamePanel.scale);
        inventoryBag.BoundingBox.height = (int) (250 * GamePanel.scale);

        inventoryPlayer = new InventoryComponent();
        inventoryPlayer.BoundingBox.x = (int) (-33 * GamePanel.scale);
        inventoryPlayer.BoundingBox.y = (int) (20 * GamePanel.scale);
        inventoryPlayer.BoundingBox.width = (int) (150 * GamePanel.scale);
        inventoryPlayer.BoundingBox.height = (int) (150 * GamePanel.scale);

        inventoryTask = new InventoryComponent();
        inventoryTask.BoundingBox.x = (int) (89 * GamePanel.scale);
        inventoryTask.BoundingBox.y = (int) (-15 * GamePanel.scale);
        inventoryTask.BoundingBox.width = (int) (150 * GamePanel.scale);
        inventoryTask.BoundingBox.height = (int) (150 * GamePanel.scale);

        rightArrow = new InventoryComponent();
        rightArrow.BoundingBox.x = (int) (228 * GamePanel.scale);
        rightArrow.BoundingBox.y = (int) (96 * GamePanel.scale);
        rightArrow.BoundingBox.width = (int) (20 * GamePanel.scale);
        rightArrow.BoundingBox.height = (int) (17 * GamePanel.scale);

        leftArrow = new InventoryComponent();
        leftArrow.BoundingBox.x = (int) (82 * GamePanel.scale);
        leftArrow.BoundingBox.y = (int) (96 * GamePanel.scale);
        leftArrow.BoundingBox.width = (int) (20 * GamePanel.scale);
        leftArrow.BoundingBox.height = (int) (17 * GamePanel.scale);

        backArrow = new InventoryComponent();
        backArrow.BoundingBox.x = (int) (101 * GamePanel.scale);
        backArrow.BoundingBox.y = (int) (19 * GamePanel.scale);
        backArrow.BoundingBox.width = (int) (14 * GamePanel.scale);
        backArrow.BoundingBox.height = (int) (11 * GamePanel.scale);

        informationBoard = new InventoryComponent();
        informationBoard.BoundingBox.x = (int) (24 * GamePanel.scale);
        informationBoard.BoundingBox.y = (int) (40 * GamePanel.scale);
        informationBoard.BoundingBox.width = (int) (200 * GamePanel.scale);
        informationBoard.BoundingBox.height = (int) (110 * GamePanel.scale);

        informationBoardBackArrow = new InventoryComponent();
        informationBoardBackArrow.BoundingBox.x = (int) (39 * GamePanel.scale);
        informationBoardBackArrow.BoundingBox.y = (int) (49 * GamePanel.scale);
        informationBoardBackArrow.BoundingBox.width = (int) (12 * GamePanel.scale);
        informationBoardBackArrow.BoundingBox.height = (int) (8 * GamePanel.scale);

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

    public void update() {
        if (!Main.topGameState().equals("Inventory")) {
            currentIndex = 0;
            isGettingInformation = false;
            return;
        }
        if (isUsingItem && usingItem.Name.equals("Iphone 1000000 ProMax")) {
            gamePanel.phone.isDrawPhone = true;
            gamePanel.phone.setPhoneState("Screen Saver");
            Main.popGameState();
        }
        isUsingItem = false;
        usingItem = new Tile();
        if (isGettingInformation) {
            if (isLeftClick(informationBoardBackArrow))
                isGettingInformation = false;
            return;
        }
        if (isLeftClick(backArrow)) {
            Main.popGameState();
            return;
        }
        ++step;
        if (step == 6) {
            if (!reverse) {
                leftArrow.BoundingBox.x -= (int)(GamePanel.scale);
                rightArrow.BoundingBox.x += (int) GamePanel.scale;
                if (rightArrow.BoundingBox.x >= 233 * GamePanel.scale) {
                    reverse = true;
                }
            } else {
                leftArrow.BoundingBox.x += (int) GamePanel.scale;
                rightArrow.BoundingBox.x -= (int) GamePanel.scale;
                if (rightArrow.BoundingBox.x <= 230 * GamePanel.scale) {
                    reverse = false;
                }
            }
            step = 0;
        }
        if (currentIndex < 2 && isLeftClick(rightArrow))
            ++currentIndex;
        if (currentIndex > 0 && isLeftClick(leftArrow))
            --currentIndex;
        if (MouseManager.isRightMouseClick || MouseManager.isLeftMouseClick) {
            for (int x = 0; x < 3; ++x)
                for (int y = 0; y < 3; ++y) {
                    if (MouseManager.lastReleasedX >= BoundingBox[x][y].x
                            && MouseManager.lastReleasedX <= BoundingBox[x][y].x + BoundingBox[x][y].width
                            && MouseManager.lastReleasedY >= BoundingBox[x][y].y
                            && MouseManager.lastReleasedY <= BoundingBox[x][y].y + BoundingBox[x][y].height) {
                        MouseManager.isRightMouseClick = false;
                        MouseManager.isLeftMouseClick = false;
                        slotX = x;
                        slotY = y;

                        if (!pages[currentIndex].slot[x][y].Name.equals("Empty"))
                            popMenu.show(gamePanel, MouseManager.lastReleasedX, MouseManager.lastReleasedY);
                    }
                }
        }
    }

    public void draw(Graphics2D g2) {
        if (Main.topGameState().equals("Inventory")) {
            Color myColor = new Color(45, 39, 39, 190);
            g2.setColor(myColor);
            g2.fillRect(0, 0, (int) GamePanel.screenWidth, (int) GamePanel.screenHeight);
            inventoryUI.draw(g2, inventoryBag);
            inventoryUI.draw(g2, inventoryTask);
            inventoryUI.draw(g2, inventoryPlayer);
            if (currentIndex < 2)
                inventoryUI.draw(g2, rightArrow);
            if (currentIndex > 0)
                inventoryUI.draw(g2, leftArrow);
            for (int i = 0; i < 3; ++i)
                for (int j = 0; j < 3; ++j) {
                    if (!pages[currentIndex].slot[i][j].Name.equals("Empty")) {
                        inventoryUI.drawIcon(g2, BoundingBox[i][j], pages[currentIndex].slot[i][j]);
                    }
                }
            if (isGettingInformation) {
                g2.fillRect(0, 0, (int) GamePanel.screenWidth, (int) GamePanel.screenHeight);
                showInformation(g2, pages[currentIndex].slot[slotX][slotY]);
            }
        }
    }

    public Boolean isExist(String itemName) {
        for (int pageIndex = 0; pageIndex < 3; ++pageIndex)
            for (int y = 0; y < 3; ++y)
                for (int x = 0; x < 3; ++x) {
                    if (pages[pageIndex].slot[x][y].Name.equals(itemName)) {
                        return true;
                    }
                }
        return false;
    }

    public void pushToInventory(Tile tile) {
        for (int pageIndex = 0; pageIndex < 3; ++pageIndex)
            for (int y = 0; y < 3; ++y)
                for (int x = 0; x < 3; ++x) {
                    if (pages[pageIndex].slot[x][y].Name.equals(tile.Name)) {
                        ++pages[pageIndex].slot[x][y].numOwn;
                        return;
                    }
                }
        for (int pageIndex = 0; pageIndex < 3; ++pageIndex)
            for (int y = 0; y < 3; ++y)
                for (int x = 0; x < 3; ++x) {
                    if (pages[pageIndex].slot[x][y].Name.equals("Empty")) {
                        pages[pageIndex].slot[x][y] = tile;
                        pages[pageIndex].slot[x][y].numOwn = 1;
                        return;
                    }
                }
    }

    public void dropFromInventory(int pageIndex, int x, int y) {
        if (!pages[pageIndex].slot[x][y].Name.equals("Empty")) {
            --pages[pageIndex].slot[x][y].numOwn;
            Tile tile = new Tile(gamePanel.player.getMapX(),
                    gamePanel.player.getMapX() + pages[pageIndex].slot[x][y].getWidth(),
                    (int) (gamePanel.player.getMapY() + 16 * GamePanel.scale),
                    (int) (gamePanel.player.getMapY() + 16 * GamePanel.scale + pages[pageIndex].slot[x][y].getHeight()),
                    pages[pageIndex].slot[x][y].Name, pages[pageIndex].slot[x][y].Type,
                    pages[pageIndex].slot[x][y].Description, pages[pageIndex].slot[x][y].image,pages[pageIndex].slot[x][y].imageEffcet);
            gamePanel.currentMap.addTile(tile);
            if (pages[pageIndex].slot[x][y].numOwn == 0) {
                pages[pageIndex].slot[x][y].Name = "Empty";
            }
        }
    }

    public void deleteFromInventory(int pageIndex, int x, int y) {
        if (!pages[pageIndex].slot[x][y].Name.equals("Empty")) {
            --pages[pageIndex].slot[x][y].numOwn;
            pages[pageIndex].slot[x][y].Name = "Empty";
        }
    }

    void showInformation(Graphics2D g2, Tile tile) {
        inventoryUI.draw(g2, informationBoard);
        inventoryUI.draw(g2, informationBoardBackArrow);
        Rectangle rect = new Rectangle((int) (43 * GamePanel.scale), (int) (81 * GamePanel.scale), (int) (50 * GamePanel.scale), (int) (50 * GamePanel.scale));
        inventoryUI.drawIcon(g2, rect, tile);
        int FontSize = (int)(10 * GamePanel.scale);
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        g2.drawString(tile.Name, (int) (67 * GamePanel.scale), (int) (56 * GamePanel.scale));
        FontSize = (int) (8 * GamePanel.scale);
        int FontPixel = (int) (4 * GamePanel.scale);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        int x = (int) (110 * GamePanel.scale);
        int y = (int) (77 * GamePanel.scale);
        String str = "";
        int strSize = 0;
        for (int i = 0; i < tile.Description.length(); ++i) {
            strSize += FontPixel;
            if (tile.Description.charAt(i) == ' ') {
                for (int j = i + 1; j <= tile.Description.length(); ++j)
                    if (j == tile.Description.length() || tile.Description.charAt(j) == ' ') {
                        if (strSize + (j - i - 1) * FontPixel >= informationBoard.BoundingBox.width / 3 * 2
                                - 32 * GamePanel.scale) {
                            g2.drawString(str, x, y);
                            str = "";
                            y += 40;
                            strSize = 0;
                        }
                        break;
                    }
                if (strSize > 0)
                    str += ' ';
            } else
                str += tile.Description.charAt(i);
        }
        if (strSize > 0)
            g2.drawString(str, x, y);
    }

    boolean isLeftClick(InventoryComponent comp) {
        if (MouseManager.isLeftMouseClick && MouseManager.lastReleasedX >= comp.BoundingBox.x
                && MouseManager.lastReleasedX <= comp.BoundingBox.x + comp.BoundingBox.width
                && MouseManager.lastReleasedY >= comp.BoundingBox.y
                && MouseManager.lastReleasedY <= comp.BoundingBox.y + comp.BoundingBox.height) {
            MouseManager.isLeftMouseClick = false;
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Use": {
                isUsingItem = true;
                usingItem.copyTile(pages[currentIndex].slot[slotX][slotY]);
                break;
            }
            case "Drop": {
                dropFromInventory(currentIndex, slotX, slotY);
                break;
            }
            case "Info": {
                isGettingInformation = true;
                infoItem = pages[currentIndex].slot[slotX][slotY];
                break;
            }
        }
    }
}
