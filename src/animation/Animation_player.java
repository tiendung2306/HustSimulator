package animation;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;
import sound.Sound;
import main.GamePanel;

public class Animation_player{

    GamePanel gamePanel;
    BufferedImage[] frames;
    double total_loop_time;
    Rectangle play_area;
    double one_loop_time;
    double pre_loop_time = -1.0;
    int index = 0;

    String state = "run";
    
    /**
     * Create a animation player that will play your animation, to use this, your have to call 
     * the method animation_player.operation() in your gamepanel loop method
     * @param gamePanel the specified gamepanel to be drawn on
     * @param frames_path the file path to the frames of your animation from your ProjectFolder. For example, if your frames 
     * path is ProjectFolder -> MainGame -> Resouce -> MyAnimation -> FrameNumber(1) and so on, the para 
     * will be "MainGame/Resouce/MyAnimation/FrameNumber"
     * @param total_frames the number of total frames
     * @param total_loop_time the amount of time your animation last (in seconds)
     * @param play_area the area the animation will play on the gamepanel (a rectangle)
    */
    public Animation_player(GamePanel gamePanel, String frames_path, int total_frames , double total_loop_time, Rectangle play_area){
        
        this.gamePanel = gamePanel;
        this.total_loop_time = total_loop_time;
        this.play_area = play_area;
        one_loop_time = 1.0 / (total_frames / total_loop_time);        
        frames_load(frames_path, total_frames);

    }

    private void frames_load(String frames_path, int total_frames)  {

        frames = new BufferedImage[total_frames];
        for(int i = 1; i <= total_frames; i++)  {

            String path = frames_path + "(" + i + ").png";
            try {
                frames[i - 1] = ImageIO.read(new FileInputStream(path));
            }
            catch(IOException e) {
                e.printStackTrace();
            }        

        }
    }

    private void update() {

        if((System.nanoTime() - pre_loop_time) / 1000000000 > one_loop_time)  {

            pre_loop_time = System.nanoTime() ;
            if(index == frames.length - 1)
                index = 0;
            else
                index += 1;

        }

    }

    public void operation(Graphics graphics) {
        
        if(state == "run")  {
            if(pre_loop_time == -1.0)
                pre_loop_time = System.nanoTime();

            update();

            graphics.drawImage(frames[index], play_area.x, play_area.y, play_area.width, play_area.height, null);
        }
    }

}
