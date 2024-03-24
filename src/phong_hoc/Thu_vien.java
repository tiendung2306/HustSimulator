package phong_hoc;

import main.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Thu_vien{
    GamePanel gp;
    Array_tile arrayTile=new Array_tile();
    int mapTileNum3 [][];   // Mảng 2 chiều để lữu các số trong file


    public Thu_vien(GamePanel gp) {
        this.gp = gp;
        mapTileNum3 = new int[gp.maxScreenCol][gp.maxScreenRow];
        this.arrayTile.getTileImage();
        loadMap("/map/thu_vien.txt");
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
                    mapTileNum3[col][row] = num;
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
            int tileNum= mapTileNum3[col][row];
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

        g2.drawImage(arrayTile.tile[21].image,94* gp.scale,13*gp.scale,92*gp.scale,35*gp.scale,null);
        g2.drawImage(arrayTile.tile[20].image,16* gp.scale,2*gp.scale,46*gp.scale,26*gp.scale,null);
        g2.drawImage(arrayTile.tile[16].image,209* gp.scale,1*gp.scale,29*gp.scale,29*gp.scale,null);
        g2.drawImage(arrayTile.tile[17].image,33* gp.scale,35*gp.scale,78*gp.scale,59*gp.scale,null);
        g2.drawImage(arrayTile.tile[18].image,0* gp.scale,54*gp.scale,15*gp.scale,130*gp.scale,null);
        g2.drawImage(arrayTile.tile[19].image,33* gp.scale,128*gp.scale,81*gp.scale,61*gp.scale,null);
        g2.drawImage(arrayTile.tile[13].image,145* gp.scale,65*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(arrayTile.tile[13].image,145* gp.scale,113*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(arrayTile.tile[13].image,145* gp.scale,160*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(arrayTile.tile[13].image,210* gp.scale,65*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(arrayTile.tile[13].image,210* gp.scale,113*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(arrayTile.tile[13].image,210* gp.scale,160*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(arrayTile.tile[14].image,170* gp.scale,73*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(arrayTile.tile[14].image,170* gp.scale,121*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(arrayTile.tile[14].image,170* gp.scale,169*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(arrayTile.tile[14].image,234* gp.scale,73*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(arrayTile.tile[14].image,234* gp.scale,121*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(arrayTile.tile[14].image,234* gp.scale,169*gp.scale,28*gp.scale,28*gp.scale,null);
    }
}
