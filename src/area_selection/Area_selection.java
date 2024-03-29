package area_selection;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.MouseInfo;

import main.GamePanel;

public class Area_selection {
    BufferedImage background;
    Area_container area_array[][];
    GamePanel gamePanel;
    

    public Area_selection(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        LoadImage();
        LoadMap();
    }

    private void LoadImage(){
        try {
            background = ImageIO.read(new FileInputStream("res/tile/Area_selection_map.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }  
    }

    private void LoadMap(){
        area_array = new Area_container[20][20];
        try {
            BufferedReader source = new BufferedReader(new InputStreamReader(new FileInputStream("src/txt/areas.txt")));
            String line = source.readLine();
            while (line != null) {
                String values[] = line.split(" ");
                String tag = values[0];
                int x = Integer.parseInt(values[1]), y = Integer.parseInt(values[2]), width = Integer.parseInt(values[3]), height = Integer.parseInt(values[4]);
                int col1 = Integer.parseInt(values[5]), col2 = Integer.parseInt(values[6]);
                int row1 = Integer.parseInt(values[7]), row2 = Integer.parseInt(values[8]);

                Area new_Area = new Area(this, tag, new Rectangle(x, y, width, height));
                // System.out.println(col1);
                // System.out.println(col2);

                // System.out.println(row1);
                // System.out.println(row2);

                for(int i = col1; i <= col2; i++)
                    for(int j = row1; j <= row2; j++){
                        if(area_array[i][j] == null){
                            area_array[i][j] =  new Area_container();
                        }
                        area_array[i][j].add(new_Area);
                    }
                line = source.readLine();
            }

            source.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        for(Area a : area_array[4][5].getContainer()){
            System.out.println(a.tag);
        }

    }


    private void HoverCheck(){
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();

        int col = (int)(mouseX / (gamePanel.screenWidth / 10));
        int row = (int)(mouseY / (gamePanel.screenHeight / 10));

        mouseX = (mouseX / gamePanel.screenWidth) * background.getWidth();
        mouseY = (mouseY / gamePanel.screenHeight) * background.getHeight();

        if (area_array[col][row] != null) {
            for(Area area : area_array[col][row].getContainer())
                if(area.HoverCheck(mouseX, mouseY))
                    area.OnHover();
        }
    }

    public void operation(Graphics graphics){
        HoverCheck();
        graphics.drawImage(background, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight,null);
    }
}




class Area_container{
    Vector<Area> container = new Vector<Area>();

    public Area_container(){

    }

    protected void add(Area area){
        container.add(area);
    }

    protected Vector<Area> getContainer(){
        return container;
    }
}