package section_selection;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.String;
import java.util.Vector;

import javax.imageio.ImageIO;
import java.io.*;

import main.GamePanel;
import main.Main;
import section_selection.shape.*;

public class Section_selection {
    GamePanel gamePanel;
    BufferedImage background;
    Vector<Section> sections = new Vector<Section>();
    double scale_X, scale_Y;
    int bg_X, bg_Y;

    StatusPanel statusPanel = new StatusPanel(this);
    Button backButton = new Button(this);

    public Section_selection(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        LoadImage();
        LoadMap();
        LoadButton();
        Scale((double) GamePanel.screenHeight / background.getHeight(),
                (double) GamePanel.screenHeight / background.getHeight());
        // Scale(1.0 / 2, 1.0 / 2);

    }

    private void LoadImage() {
        try {
            background = ImageIO.read(new FileInputStream("res/tile/Area_selection_map.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void LoadButton(){
        backButton.add_Hitbox(new Shape(1, 114, 331, 147));
        backButton.set_Boder(new Shape(1, 114, 331, 147));
        backButton.set_Tag("BackButton");

    }

    private void LoadMap() {
        try {
            BufferedReader source = new BufferedReader(new InputStreamReader(new FileInputStream("src/txt/areas.txt")));
            while (true) {

                String tag = source.readLine();
                Section section = new Section(this);

                if (tag.length() == 0) {
                    break;
                } else {
                    sections.add(section);
                    section.set_Tag(tag);

                    boolean next = true;
                    while (next) {
                        String line = source.readLine();
                        String values[] = line.split(" ");
                        switch (values[0]) {
                            case "Rec":
                                section.add_Hitbox(new Shape(Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                                        Integer.parseInt(values[3]), Integer.parseInt(values[4])));
                                break;

                            case "Poly":
                                Vector<Point> points = new Vector<Point>();
                                for (int i = 1; i < values.length; i += 2) {
                                    points.add(new Point(Integer.parseInt(values[i]), Integer.parseInt(values[i + 1])));
                                }
                                section.add_Hitbox(new Shape(points));
                                break;

                            case "Des":
                                String description = "";
                                for (int i = 1; i < values.length; i += 1) {
                                    description += values[i];
                                    description += " ";
                                }
                                section.set_Description(description);
                                break;

                            case "Boder":
                                section.set_Boder(new Shape(Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                                        Integer.parseInt(values[3]), Integer.parseInt(values[4])));
                                next = false;
                                break;
                        }
                    }
                }

            }

            source.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void Scale(double scale_X, double scale_Y) {
        this.scale_X = scale_X;
        this.scale_Y = scale_Y;

        for (Section section : sections) {
            section.scale(scale_X, scale_Y);
        }

        statusPanel.scale(scale_X, scale_Y);
        backButton.scale(scale_X, scale_Y);

        bg_X = (int)((gamePanel.screenWidth - background.getWidth() * scale_X) / 2);
        bg_Y = 0;

    }

    private void HoverCheck(Graphics graphics) {

        for (Section section : sections)
            if (section.HoverCheck(gamePanel.mouseManager.mouseCurrentX(), gamePanel.mouseManager.mouseCurrentY())) {
                section.OnHover(graphics);
            }

        if(backButton.HoverCheck(gamePanel.mouseManager.mouseCurrentX(), gamePanel.mouseManager.mouseCurrentY()))
            backButton.OnHover(graphics);
    }

    private void display(Graphics graphics) {
        graphics.drawImage(background, bg_X, bg_Y, (int) (background.getWidth() * scale_X), (int) (background.getHeight() * scale_Y), null);

        // Test(graphics);
        // for(Section section : sections){
        // section.display(graphics);
        // }
    }

    // boolean run = true;
    // Text test = new Text("vpa", new Font("Ariel", Font.PLAIN, 30));

    // private void Test(Graphics graphics){
    // if(run){
    // System.out.println(graphics.getFont().getName());
    // }

    // }

    public void operation(Graphics graphics) {
        display(graphics);
        HoverCheck(graphics);
        statusPanel.display(graphics);
    }

    public void open(){
        Main.pushGameState("Map");
    }

    public void close(){
        Main.popGameState();
    }

}
