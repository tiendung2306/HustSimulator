package phong_hoc;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Classroom01 extends JPanel {
    GamePanel gp;
    Array_tile arrayTile=new Array_tile();
    int mapTileNum [][];   // Mảng 2 chiều để lữu các số trong file


    public Classroom01(GamePanel gp) {
        this.gp = gp;
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        this.arrayTile.getTileImage();
        loadMap("src/phong_hoc/phong_hoc.txt");
    }


    //Phương thức đọc dữ liệu trong file.txt
    public void loadMap(String filePath) {
        try {
            //Khai báo 1 biến để nhập file
            InputStream is = getClass().getResourceAsStream(filePath);
            //Khai báo biến để đọc pfile vừa nhập
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            //Vòng lặp để đọc file và tách xâu thnahf các số để đưa vào mảng 2 chiều mapTileNum
            while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();

                while(col<gp.maxScreenCol) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol) {
                    col =0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }

    }



    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        int col =0;
        int row = 0;
        int x=0;
        int y=0;

        while(col < gp.maxScreenCol && row <gp.maxScreenRow) {
            int tileNum= mapTileNum[col][row];
            //Lệnh để vẽ 1 ô
            g2.drawImage(arrayTile.tile[tileNum].image,x,y,gp.tileSize, gp.tileSize,null);
            col++;
            x+=gp.tileSize;
            if(col == gp.maxScreenCol) {
                col=0;
                x=0;
                row++;
                y+=gp.tileSize;
            }
        }
        g2.drawImage(arrayTile.tile[4].image,25* gp.scale,4*gp.scale,50*gp.scale,16*gp.scale,null);
        g2.drawImage(arrayTile.tile[4].image,98*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
        g2.drawImage(arrayTile.tile[4].image,174*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
        g2.drawImage(arrayTile.tile[9].image,0,77*gp.scale,256*gp.scale, 3*gp.scale,null);
        g2.drawImage(arrayTile.tile[6].image,16*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
        g2.drawImage(arrayTile.tile[6].image,204*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,25*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,60*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,95*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,130*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,165*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,25*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,60*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,95*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,130*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[7].image,165*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
        g2.drawImage(arrayTile.tile[8].image,210*gp.scale,134*gp.scale,24*gp.scale, 58*gp.scale,null);
        g2.drawImage(arrayTile.tile[5].image,83*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);
        g2.drawImage(arrayTile.tile[5].image,140*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);

    }
}