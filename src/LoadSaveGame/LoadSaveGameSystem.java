package LoadSaveGame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import main.GamePanel;
import time.TimeSystem;

public class LoadSaveGameSystem {
    GamePanel gamePanel;
    String currChapterSlot1, totalPlayTimeSlot1, dateSlot1, timeSlot1;
    String currChapterSlot2, totalPlayTimeSlot2, dateSlot2, timeSlot2;
    String currChapterSlot3, totalPlayTimeSlot3, dateSlot3, timeSlot3;

    public LoadSaveGameSystem(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    long timeNormalization(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10
                + time.charAt(4) - '0';
    }

    public void loadGameSlot(int slotId) {
        readFileLoadGame();
        if (slotId == 1) {
            gamePanel.loadChapter(currChapterSlot1);
            TimeSystem.savedElapsedTime = timeNormalization(totalPlayTimeSlot1);
            TimeSystem.currentPlayDate = dateSlot1;
        }
        if (slotId == 2) {
            gamePanel.loadChapter(currChapterSlot2);
            TimeSystem.savedElapsedTime = timeNormalization(totalPlayTimeSlot2);
            TimeSystem.currentPlayDate = dateSlot2;
        }
        if (slotId == 3) {
            gamePanel.loadChapter(currChapterSlot3);
            TimeSystem.savedElapsedTime = timeNormalization(totalPlayTimeSlot3);
            TimeSystem.currentPlayDate = dateSlot3;
        }
        System.out.println(TimeSystem.savedElapsedTime);
    }

    public void readFileLoadGame() {
        try {
            BufferedReader source = new BufferedReader(
                    new InputStreamReader(new FileInputStream("src/txt/loadGame.txt")));
            int cnt = 1;
            while (true) {
                String linebreak = source.readLine();
                if (linebreak.length() == 0) {
                    break;
                } else {
                    boolean next = true;
                    while (next) {
                        String line = source.readLine();
                        String values[] = line.split(" ");
                        switch (values[0]) {
                            case "chap":
                                if (cnt == 1) {
                                    if (Integer.parseInt(values[1]) == 1)
                                        currChapterSlot1 = "chap1";
                                    else if (Integer.parseInt(values[1]) == 2)
                                        currChapterSlot1 = "chap2";
                                    else if (Integer.parseInt(values[1]) == 3)
                                        currChapterSlot1 = "chap3";
                                } else if (cnt == 2) {
                                    if (Integer.parseInt(values[1]) == 1)
                                        currChapterSlot2 = "chap1";
                                    else if (Integer.parseInt(values[1]) == 2)
                                        currChapterSlot2 = "chap2";
                                    else if (Integer.parseInt(values[1]) == 3)
                                        currChapterSlot2 = "chap3";
                                } else if (cnt == 3) {
                                    if (Integer.parseInt(values[1]) == 1)
                                        currChapterSlot3 = "chap1";
                                    else if (Integer.parseInt(values[1]) == 2)
                                        currChapterSlot3 = "chap2";
                                    else if (Integer.parseInt(values[1]) == 3)
                                        currChapterSlot3 = "chap3";
                                }
                                break;
                            case "time":
                                if (cnt == 1) {
                                    totalPlayTimeSlot1 = values[1];
                                } else if (cnt == 2) {
                                    totalPlayTimeSlot2 = values[1];
                                } else if (cnt == 3) {
                                    totalPlayTimeSlot3 = values[1];
                                }
                                break;
                            case "date":
                                if (cnt == 1) {
                                    dateSlot1 = values[2];
                                    timeSlot1 = values[1];
                                } else if (cnt == 2) {
                                    dateSlot2 = values[2];
                                    timeSlot2 = values[1];
                                } else if (cnt == 3) {
                                    dateSlot3 = values[2];
                                    timeSlot3 = values[1];
                                }
                                break;
                            case "end":
                                next = false;
                                cnt++;
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
}
