package animation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import sound.Sound;
import main.GamePanel;

public class Animation_player extends Thread{
    GamePanel gamePanel;
    public BufferedImage[] frames;
    double total_loop_time;
    Rectangle play_area;
    double one_loop_time;
    double pre_loop_time = -1.0;
    int index = 0;

    String state = "run";
    
    public Animation_player(GamePanel gamePanel, String frames_path, int total_frames , double total_loop_time, Rectangle play_area){
        this.gamePanel = gamePanel;
        this.total_loop_time = total_loop_time;
        this.play_area = play_area;
        one_loop_time = 1.0 / (total_frames / total_loop_time);
        System.out.println(one_loop_time);
        this.frames = new BufferedImage[total_frames];
        frames_load(frames_path, total_frames);
    }

    private void frames_load(String frames_path, int total_frames){
        for(int i = 1; i <= total_frames; i++){
            String path = frames_path + "(" + i + ").png";
            try{
                frames[i - 1] = ImageIO.read(new FileInputStream(path));
            }
            catch(IOException e){
                e.printStackTrace();
            }        
        }
    }

    private void update(){
        // System.out.println((System.nanoTime() - pre_loop_time) / 1000000000);
        if((System.nanoTime() - pre_loop_time) / 1000000000 > one_loop_time){
            pre_loop_time = System.nanoTime() ;
            if(index == frames.length - 1)
                index = 0;
            else
                index += 1;
        }
    }

    public void operation(Graphics2D graphics2d){
        if(state == "run"){
            if(pre_loop_time == -1.0)
            pre_loop_time = System.nanoTime();
            update();
            graphics2d.drawImage(frames[index], 300, 100, 400, 400, null);
            // graphics2d.drawImage(frames[index], play_area.x, play_area.y, play_area.width, play_area.height, null);
            // System.out.println(play_area.width);
        }
    }
}
