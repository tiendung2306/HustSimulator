package LoadSaveGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
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

    String timeNormalization(long time) {
        long hour = time / 3600;
        long mins = (time - hour * 3600) / 60;
        String hourString, minsString;
        hourString = Long.toString(hour);
        if (hourString.length() == 1)
            hourString = "0" + hourString;
        minsString = Long.toString(mins);
        if (minsString.length() == 1)
            minsString = "0" + minsString;
        return hourString + "h" + minsString + "p";
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
        // System.out.println(TimeSystem.savedElapsedTime);
    }

    public void saveGameSlot(int slotID) {
        readFileLoadGame();
        if (slotID == 1) {
            if (gamePanel.currentChapter == gamePanel.chapter1)
                currChapterSlot1 = "chap 1";
            if (gamePanel.currentChapter == gamePanel.chapter2)
                currChapterSlot1 = "chap 2";
            if (gamePanel.currentChapter == gamePanel.chapter3)
            currChapterSlot1 = "chap 3";

            totalPlayTimeSlot1 = timeNormalization(
                    TimeSystem.currentSystemTime / 1000000000 + TimeSystem.savedElapsedTime);
            String tempDate = TimeSystem.getCurrentDate();
            dateSlot1 = "";
            for (int i = 0; i <= 9; i++) {
                dateSlot1 += String.valueOf(String.valueOf(tempDate.charAt(i)));
            }
            timeSlot1 = String.valueOf(tempDate.charAt(11)) + String.valueOf(tempDate.charAt(12)) + "h"
                    + String.valueOf(tempDate.charAt(14)) + String.valueOf(tempDate.charAt(15))
                    + "p";
        }
        if (slotID == 2) {
            if (gamePanel.currentChapter == gamePanel.chapter1)
                currChapterSlot2 = "chap 1";
            if (gamePanel.currentChapter == gamePanel.chapter2)
                currChapterSlot2 = "chap 2";
            if (gamePanel.currentChapter == gamePanel.chapter3)
            currChapterSlot2 = "chap 3";
            totalPlayTimeSlot2 = timeNormalization(
                    TimeSystem.currentSystemTime / 1000000000 + TimeSystem.savedElapsedTime);
            String tempDate = TimeSystem.getCurrentDate();
            dateSlot2 = "";
            for (int i = 0; i <= 9; i++) {
                dateSlot2 += String.valueOf(tempDate.charAt(i));
            }
            timeSlot2 = String.valueOf(tempDate.charAt(11)) + String.valueOf(tempDate.charAt(12)) + "h"
                    + String.valueOf(tempDate.charAt(14)) + String.valueOf(tempDate.charAt(15))
                    + "p";
        }
        if (slotID == 3) {
            if (gamePanel.currentChapter == gamePanel.chapter1)
                currChapterSlot3 = "chap 1";
            if (gamePanel.currentChapter == gamePanel.chapter2)
                currChapterSlot3 = "chap 2";
            if (gamePanel.currentChapter == gamePanel.chapter3)
            currChapterSlot3 = "chap 3";
            totalPlayTimeSlot3 = timeNormalization(
                TimeSystem.currentSystemTime / 1000000000 + TimeSystem.savedElapsedTime);
            String tempDate = TimeSystem.getCurrentDate();
            dateSlot3 = "";
            for (int i = 0; i <= 9; i++) {
                dateSlot3 += String.valueOf(tempDate.charAt(i));
            }
            timeSlot3 = String.valueOf(tempDate.charAt(11)) + String.valueOf(tempDate.charAt(12)) + "h"
                    + String.valueOf(tempDate.charAt(14)) + String.valueOf(tempDate.charAt(15))
                    + "p";
        }
        writeFileSaveGame();
    }

    public void writeFileSaveGame() {
        try (BufferedWriter source = new BufferedWriter(new FileWriter("src/txt/loadGame.txt"))) {
            // ghi du lieu save slot 1
            source.write("rec1\n");
            source.write(currChapterSlot1 + "\n");
            source.write("time " + totalPlayTimeSlot1 + "\n");
            source.write("date " + timeSlot1 + " " + dateSlot1 + "\n");
            source.write("end\n");
            // ghi du lieu save slot 2
            source.write("rec2\n");
            source.write(currChapterSlot2 + "\n");
            source.write("time " + totalPlayTimeSlot2 + "\n");
            source.write("date " + timeSlot2 + " " + dateSlot2 + "\n");
            source.write("end\n");
            // ghi du lieu save slot 3
            source.write("rec3\n");
            source.write(currChapterSlot3 + "\n");
            source.write("time " + totalPlayTimeSlot3 + "\n");
            source.write("date " + timeSlot3 + " " + dateSlot3 + "\n");
            source.write("end\n");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
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
                                        currChapterSlot1 = "chap 1";
                                    else if (Integer.parseInt(values[1]) == 2)
                                        currChapterSlot1 = "chap 2";
                                    else if (Integer.parseInt(values[1]) == 3)
                                        currChapterSlot1 = "chap 3";
                                } else if (cnt == 2) {
                                    if (Integer.parseInt(values[1]) == 1)
                                        currChapterSlot2 = "chap 1";
                                    else if (Integer.parseInt(values[1]) == 2)
                                        currChapterSlot2 = "chap 2";
                                    else if (Integer.parseInt(values[1]) == 3)
                                        currChapterSlot2 = "chap 3";
                                } else if (cnt == 3) {
                                    if (Integer.parseInt(values[1]) == 1)
                                        currChapterSlot3 = "chap 1";
                                    else if (Integer.parseInt(values[1]) == 2)
                                        currChapterSlot3 = "chap 2";
                                    else if (Integer.parseInt(values[1]) == 3)
                                        currChapterSlot3 = "chap 3";
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
