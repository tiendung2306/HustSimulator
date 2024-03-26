//package tile;
//
//import main.GamePanel;
//
//import java.awt.*;
//
//public class Oto_di_duoc extends Tile{
//    GamePanel gamePanel;
//    TileManager tileManager;
//    public Oto_di_duoc(GamePanel gamePanel) {
//        this.gamePanel=gamePanel;
//        tileManager = new TileManager(gamePanel);
//    }
//
//    public void setDefaultValues() {
//        LeftX=15;
//        BottomY=111;
//        speed = 2;
//    }
//
//    public void update() {
//        LeftX+= speed;
//        BottomY +=speed
//    }
//    public  void draw(Graphics2D g2) {
//        g2.drawImage(tileManager.tile[18].image,LeftX* gamePanel.scale,RightX*gamePanel.scale,65*gamePanel.scale,33*gamePanel.scale,null);
//    }
//}
