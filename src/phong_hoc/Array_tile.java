package phong_hoc;

import javax.imageio.ImageIO;

import tile.Tile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Array_tile {
    Tile[] tile;
    public Array_tile() {
        tile = new Tile[50];
    }

    public void getTileImage() {
        // try {
        //     tile[0]= new Tile();
        //     tile[0].image = ImageIO.read(new FileInputStream("res/tile/tuong01.png"));

        //     tile[1]= new Tile();
        //     tile[1].image = ImageIO.read(new FileInputStream("res/tile/tuong02.png"));

        //     tile[2]= new Tile();
        //     tile[2].image = ImageIO.read(new FileInputStream("res/tile/san01.png"));

        //     tile[3]= new Tile();
        //     tile[3].image = ImageIO.read(new FileInputStream("res/tile/san02.png"));

        //     tile[4]= new Tile();
        //     tile[4].image = ImageIO.read(new FileInputStream("res/tile/dieu_hoa.png"));

        //     tile[5]= new Tile();
        //     tile[5].image = ImageIO.read(new FileInputStream("res/tile/cua_so.png"));

        //     tile[6]= new Tile();
        //     tile[6].image = ImageIO.read(new FileInputStream("res/tile/cua_ra_vao.png"));

        //     tile[7]= new Tile();
        //     tile[7].image = ImageIO.read(new FileInputStream("res/tile/ban_hs.png"));

        //     tile[8]= new Tile();
        //     tile[8].image = ImageIO.read(new FileInputStream("res/tile/ban_gv.png"));

        //     tile[9]= new Tile();
        //     tile[9].image = ImageIO.read(new FileInputStream("res/tile/ngan_tuong_voi_san.png"));

        //     tile[10]= new Tile();
        //     tile[10].image = ImageIO.read(new FileInputStream("res/tile/may_tinh_hs.png"));

        //     tile[11]= new Tile();
        //     tile[11].image = ImageIO.read(new FileInputStream("res/tile/may_tinh_gv.png"));

        //     tile[12]= new Tile();
        //     tile[12].image = ImageIO.read(new FileInputStream("res/tile/tuong03.png"));

        //     tile[13]= new Tile();
        //     tile[13].image = ImageIO.read(new FileInputStream("res/tile/ban_thu_vien.png"));

        //     tile[14]= new Tile();
        //     tile[14].image = ImageIO.read(new FileInputStream("res/tile/ghe_thu_vien.png"));

        //     tile[15]= new Tile();
        //     tile[15].image = ImageIO.read(new FileInputStream("res/tile/san03.png"));

        //     tile[16]= new Tile();
        //     tile[16].image = ImageIO.read(new FileInputStream("res/tile/dong_ho.png"));

        //     tile[17]= new Tile();
        //     tile[17].image = ImageIO.read(new FileInputStream("res/tile/tu_sach01.png"));

        //     tile[18]= new Tile();
        //     tile[18].image = ImageIO.read(new FileInputStream("res/tile/tu_sach02.png"));

        //     tile[19]= new Tile();
        //     tile[19].image = ImageIO.read(new FileInputStream("res/tile/tu_sach03.png"));

        //     tile[20]= new Tile();
        //     tile[20].image = ImageIO.read(new FileInputStream("res/tile/tranh_treo_tuong.png"));

        //     tile[21]= new Tile();
        //     tile[21].image = ImageIO.read(new FileInputStream("res/tile/cua_thu_vien.png"));

        //     tile[22]= new Tile();
        //     tile[22].image = ImageIO.read(new FileInputStream("res/tile/via_he.png"));

        //     tile[23]= new Tile();
        //     tile[23].image = ImageIO.read(new FileInputStream("res/tile/san_bong.png"));

        //     tile[24]= new Tile();
        //     tile[24].image = ImageIO.read(new FileInputStream("res/tile/duong_giao_thong.png"));

        //     tile[25]= new Tile();
        //     tile[25].image = ImageIO.read(new FileInputStream("res/tile/hang_rao.png"));

        //     tile[26]= new Tile();
        //     tile[26].image = ImageIO.read(new FileInputStream("res/tile/san_chay_va_co.png"));

        //     tile[27]= new Tile();
        //     tile[27].image = ImageIO.read(new FileInputStream("res/tile/xe_hoi_trang.png"));

        //     tile[28]= new Tile();
        //     tile[28].image = ImageIO.read(new FileInputStream("res/tile/xe_tai_do.png"));

        //     tile[29]= new Tile();
        //     tile[29].image = ImageIO.read(new FileInputStream("res/tile/Tuong_svd.png"));

        //     tile[30]= new Tile();
        //     tile[30].image = ImageIO.read(new FileInputStream("res/tile/cua_svd01.png"));

        //     tile[31]= new Tile();
        //     tile[31].image = ImageIO.read(new FileInputStream("res/tile/cua_svd02.png"));

        //     tile[32]= new Tile();
        //     tile[32].image = ImageIO.read(new FileInputStream("res/tile/qua_bong.png"));

        //     tile[33]= new Tile();
        //     tile[33].image = ImageIO.read(new FileInputStream("res/tile/co_svd.png"));


        // }catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
