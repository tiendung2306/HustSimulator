package section_selection;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.MouseInfo;

import main.GamePanel;
import section_selection.shape.Shape;

public class Section_selection {
    BufferedImage background;
    Area_container section_array[][];
    GamePanel gamePanel;
    

    public Section_selection(GamePanel gamePanel){
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
        section_array = new Area_container[20][20];
        try {
            BufferedReader source = new BufferedReader(new InputStreamReader(new FileInputStream("src/txt/areas.txt")));
            while (true) {
                Section section;
                Vector<Shape> hitboxs = new Vector<Shape>();
                String tag = source.readLine();
                boolean next = true;
                while (next) {
                    String line = source.readLine();
                    String values[] = line.split(" ");
                    switch (values[0]) {
                        case "Rec":
                            hitboxs.add(new Shape(Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])));
                            break;
                    
                        case "Boder":
                            section = new Section(this, tag, hitboxs);
                            for(int i = Integer.parseInt(values[1]); i <= Integer.parseInt(values[2]); i++)
                                for(int j = Integer.parseInt(values[3]); j <= Integer.parseInt(values[4]); j++){
                                    if(section_array[i][j] == null)
                                        section_array[i][j] = new Area_container();
                                    section_array[i][j].add(section);
                                }
                            next = false;
                            break;
                    }

                }
                String line = source.readLine();
                if(line != "*")
                    break;
            }

            source.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // for(Section a : area_array[4][5].getContainer()){
        //     System.out.println(a.tag);
        // }

    }


    private void HoverCheck(Graphics graphics){
        double mouseX = (int)MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = (int)MouseInfo.getPointerInfo().getLocation().getY();

        int col = (int)(mouseX / (gamePanel.screenWidth / 10));
        int row = (int)(mouseY / (gamePanel.screenHeight / 10));

        mouseX = (mouseX / gamePanel.screenWidth) * background.getWidth();
        mouseY = (mouseY / gamePanel.screenHeight) * background.getHeight();

        if (section_array[col][row] != null) {
            for(Section section : section_array[col][row].getContainer())
                if(section.HoverCheck((int)mouseX, (int)mouseY)){
                    section.OnHover(graphics);
                }
        }
    }

    public void operation(Graphics graphics){
        graphics.drawImage(background, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight,null);
        HoverCheck(graphics);
    }
}




class Area_container{
    Vector<Section> container = new Vector<Section>();

    public Area_container(){

    }

    protected void add(Section section){
        container.add(section);
    }

    protected Vector<Section> getContainer(){
        return container;
    }
}