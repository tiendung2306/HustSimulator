package Content;

import main.GamePanel;
import main.Main;
import tile.Tile;
import time.TimeSystem;

public class Chapter3 extends Chapter{

    long prevTime = 0;
    public boolean isAtLibrary = false;
    public Chapter3(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.ui = gamePanel.ui;
        this.inventory = gamePanel.inventory;
        this.collision = gamePanel.collision;
        this.phone = gamePanel.phone;
        this.missionDescription = gamePanel.missionDescription;
        currentTimeline = 0;
        completedAct = 0;
    }

    void nextTimeline() {
        ++currentTimeline;
        completedAct = 0;
    }

    void Timeline0() {
        if (completedAct == 0)
            Dialogue("Great day to go to the library");
        if (completedAct == 1) {
            Dialogue("Practice makes perfect");
            missionDescription.setMissionDescription("Tới thư viện");
            isAtLibrary = false;
        }
        if (completedAct == 2){
            if (isAtLibrary){
                gamePanel.library.addTile(gamePanel.library.npcGirl);
                ++completedAct;
                isAtLibrary = false;
            }
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 3 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500){
            ui.setReelsCharacter("Surprise Meme");
            Main.pushGameState("Reels");
            ++completedAct;
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 4 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 3000){
            if (Main.topGameState().equals("Reels"))
                Main.popGameState();
            ++completedAct;
        }
        if (completedAct == 5){
            ui.setReelsCharacter("Girl Reading Book");
            Main.pushGameState("Reels");
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            ++completedAct;
        }
        if (completedAct == 6 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 3000){
            if (Main.topGameState().equals("Reels"))
                Main.popGameState();
            ++completedAct;
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 7 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500){
            Dialogue("Ăn cướp!!!");
        }
        if (completedAct == 8){
            Dialogue("Nàng đã cướp mất trái tim ta rồi!");
            missionDescription.setMissionDescription("Lại tán đi!");
        }
        if (completedAct == 9){
            if (collision.interactItem.Name.equals("NPC Girl"))
            {
                ui.setDialogueCharacter("Main Character");
                ui.setDialogueBackground("Library");
                Dialogue("N...nàng ăn cơm chưa?");
            }
        }
        if (completedAct == 10) {
            ui.setDialogueCharacter("NPC Girl");
            Dialogue("???");
        }
        if (completedAct == 11){
            ui.setDialogueCharacter("Main Character");
            Dialogue("Hôm nay chẳng có mưa rơi");
        }
        if (completedAct == 12){
            Dialogue("Cho anh xin phép mời nàng ôn thi!");
        }
        if (completedAct == 13){
            ui.setDialogueCharacter("NPC Girl");
            Dialogue("???");
        }
        if (completedAct == 14){
            Dialogue("Thằng dở hơi");
        }
        if (completedAct == 15){
            ui.setDialogueCharacter("Main Character");
            Dialogue("Ơ kìa, nàng chạy đi đâu đấy?");
            if (gamePanel.library.tileContainer[gamePanel.library.numTileContainer - 1] == gamePanel.library.npcGirl) {
                gamePanel.library.deleteTile(gamePanel.library.numTileContainer - 1);
                gamePanel.player.ButtonInteract = false;
            }
        }
        if (completedAct == 16){
            nextTimeline();
        }
    }

    void Timeline1() {
        if (completedAct == 0){
            ui.setDialogueCharacter("Empty");
            Dialogue("Phải chăng nàng ngại?");
        }
        if (completedAct == 1){
            Dialogue("Nàng ấy ở đâu được nhỉ?");
        }
        if (completedAct == 2){
            collision.interactItem = new Tile();
            missionDescription.setMissionDescription("Tìm cô ấy đi, tình yêu cuộc đời đấy! (Có thể là ở Hồ Tiền)");
            //gamePanel.section_3.addTile(gamePanel.section_3.npcGirl);
            ++completedAct;
        }
        if (completedAct == 3){
            nextTimeline();
        }
    }
    void Timeline2(){
        if (completedAct == 0){
            if (collision.interactItem.Name.equals("NPC Girl"))
            {
                ui.setReelsCharacter("Cat Giving Flower");
                Main.pushGameState("Reels");
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
                ++completedAct;
            }
        }
        if (completedAct == 1 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 3000){
            if (Main.topGameState().equals("Reels"))
                Main.popGameState();
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            ++completedAct;
        }
        if (completedAct == 2 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 300){
            ui.setDialogueCharacter("Main Character");
            ui.setDialogueBackground("Lake");
            Dialogue("Nàng thì đẹp tựa đóa hoa");
        }
        if (completedAct == 3){
            Dialogue("Ta A Giải tích thật là hợp nhau!");
        }
        if (completedAct == 4){
            Dialogue("Cho ta làm quen nhé.");
        }
        if (completedAct == 5){
            ui.setDialogueCharacter("NPC Girl");
            Dialogue("Không.");
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 6 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 300){
            ui.setDialogueCharacter("Empty");
            Dialogue("Ta biết nàng ấy thích ta, nhưng lại cố tỏ ra vô tình. Quả là cô gái thú vị!");
        }
        if (completedAct == 7){
            Dialogue("Thôi được rồi.");
        }
        if (completedAct == 8){
            Dialogue("Hôm nay tới đây là đủ rồi");
        }
        if (completedAct == 9){
            ui.setDialogueBackground("Empty");
            missionDescription.setMissionDescription("Di chuyển về nhà và ngủ đi");
            ++completedAct;
        }
        if (completedAct == 10){
            if (collision.interactItem.Name.equals("My Bed"))
                nextTimeline();
        }
    }
    void Timeline3(){
        Dialogue("Hoàn thành Chapter 3");
    }
    public void update() {
        if (!Main.topGameState().equals("GamePlay") && !Main.topGameState().equals("Inventory")
                && !Main.topGameState().equals("Dialogue") && !Main.topGameState().equals("Dialogue") && !Main.topGameState().equals("Reels"))
            return;
        switch (currentTimeline) {
            case 0: {
                Timeline0();
                break;
            }
            case 1: {
                Timeline1();
                break;
            }
            case 2: {
                Timeline2();
                break;
            }
            case 3: {
                Timeline3();
                break;
            }
        }
    }

    void Dialogue(String str) {
        if (Main.topGameState().equals("GamePlay")) {
            ui.currentDialog = str;
            Main.pushGameState("Dialogue");
            ui.i = 0;
            ui.timer.setDelay(30);
            ui.isFinishDialogue = false;
            ui.timer.start();
        }
    }
}
