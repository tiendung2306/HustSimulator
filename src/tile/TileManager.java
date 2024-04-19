package tile;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

public class TileManager {

    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] typeTile;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        tile = new Tile[60];
        typeTile = new int[gamePanel.maxMapCol][gamePanel.maxMapRow];
        getTileImage();
    }

    public void loadMap(String filePath) {
        try {
            // Khai báo 1 biến để nhập file
            InputStream is = getClass().getResourceAsStream(filePath);
            // System.out.println("1");
            // Khai báo biến để đọc file vừa nhập
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            // Vòng lặp để đọc file và tách xâu thành các số để đưa vào mảng 2 chiều
            // mapTileNum
            while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
                String line = br.readLine();

                while (col < gamePanel.maxScreenCol) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    typeTile[col][row] = num;
                    col++;
                }
                if (col == gamePanel.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception ignored) {

        }

    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new FileInputStream("res/tile/no_thing.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new FileInputStream("res/tile/ban_hs.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new FileInputStream("res/tile/ban_gv.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new FileInputStream("res/tile/may_tinh_hs.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new FileInputStream("res/tile/may_tinh_gv.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new FileInputStream("res/tile/ban_thu_vien.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(new FileInputStream("res/tile/ghe_thu_vien.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(new FileInputStream("res/tile/tu_sach01.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(new FileInputStream("res/tile/tu_sach02.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(new FileInputStream("res/tile/tu_sach03.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(new FileInputStream("res/tile/xe_hoi_trang.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(new FileInputStream("res/tile/xe_tai_do.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(new FileInputStream("res/tile/qua_bong.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(new FileInputStream("res/tile/cua_thu_vien.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(new FileInputStream("res/tile/cua_ra_vao.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(new FileInputStream("res/tile/tuong_va_cua_svd01.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(new FileInputStream("res/tile/tuong_va_cua_svd02.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(new FileInputStream("res/tile/backgroud_classroom.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(new FileInputStream("res/tile/backgroud_svd.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(new FileInputStream("res/tile/background_library.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(new FileInputStream("res/tile/background_myroom.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(new FileInputStream("res/tile/am_dun_nuoc.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(new FileInputStream("res/tile/bep_tu.png"));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(new FileInputStream("res/tile/chair_my_room.png"));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(new FileInputStream("res/tile/cho_nau_an.png"));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(new FileInputStream("res/tile/door_my_room.png"));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(new FileInputStream("res/tile/my_bed.png"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(new FileInputStream("res/tile/table_my_room.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(new FileInputStream("res/tile/tu_do_my_room.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(new FileInputStream("res/tile/tu_lanh.png"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(new FileInputStream("res/tile/tu_quan_ao.png"));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(new FileInputStream("res/tile/dan_pc.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(new FileInputStream("res/tile/D7 map.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, Tile tile) {
        int mapX = tile.getLeftX();
        int mapY = tile.getTopY();
        int width = tile.getWidth();
        int height = tile.getHeight();
        int screenX = mapX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        int screenY = mapY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
        g2.drawImage(tile.image, screenX, screenY, width, height, null);
        g2.drawRect(screenX, screenY, width, height);

    }

    public void drawRect(Graphics2D g2, int mapX, int mapY, int width, int height) {
        int screenX = mapX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        int screenY = mapY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
        g2.drawRect(screenX, screenY, width, height);
    }
}
