package animation;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;

import entity.Player;
import main.GamePanel;
import time.TimeSystem;

public class Animation_player{

    GamePanel gamePanel;
    BufferedImage[] frames;
    int index = 0;

    public Rectangle play_area;

    double total_loop_time;
    double one_loop_time;
    double pre_loop_time = -1.0;

    double start_time;
    double lasted_time = -1.0;

    boolean Switch = true;
    Player player;

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

        if((TimeSystem.getCurrentSystemTimeInMilliseconds() - pre_loop_time) / 1000 > one_loop_time)  {
            pre_loop_time = TimeSystem.getCurrentSystemTimeInMilliseconds() ;
            if(index == frames.length - 1)
                index = 0;
            else
                index += 1;

        }
        if (lasted_time > 0){

            if((TimeSystem.getCurrentSystemTimeInMilliseconds() - start_time) / 1000 > lasted_time)  {
                
                state = "stop";
                Switch = true;
                lasted_time = -1.0;

                
            }
        }
    }

    public void resize(double scale){
        play_area.x = (int)(play_area.x * scale);
        play_area.y = (int)(play_area.y * scale);
        play_area.width = (int)(play_area.width * scale);
        play_area.height = (int)(play_area.height * scale);
    }

    public void setTimer(double lasted_time){
        this.lasted_time = lasted_time;
    }

    public void setState(String state){
        this.state = state;
    }

    public boolean isRunning(){
        if(state == "run")
            return true;

        else
            return false;
    }

    public int getWidth(){
        return play_area.width;
    }

    public int getHeight(){
        return play_area.height;
    }

    public void setPlayarea(Rectangle play_area){
        this.play_area = play_area;
    }

    public void operation(Graphics graphics) {
        
        if(Switch){
            state = "run";
            start_time = TimeSystem.getCurrentSystemTimeInMilliseconds();
            Switch = false;
        }

        if(pre_loop_time == -1.0) {
            pre_loop_time = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }

        update();

        graphics.drawImage(frames[index], play_area.x, play_area.y, play_area.width, play_area.height, null);
    }

}
