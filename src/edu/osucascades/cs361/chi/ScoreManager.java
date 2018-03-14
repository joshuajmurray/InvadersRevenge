package edu.osucascades.cs361.chi;

import processing.core.PApplet;

import java.io.FileWriter;
import java.io.IOException;

import static processing.core.PApplet.println;

public class ScoreManager {
    public static final String FILE_NAME = "highScore.txt";
    public static final String FULL_FILE_PATH = "./data/highScore.txt";

    private PApplet p;
    private String highScore = "";
    private int hiScore = 0;
    private String playerName = "";

    ScoreManager(PApplet currentP) {
        p = currentP;
    }

    public String readScoresFromFile() {
        try {
            highScore = getHighScore(p.loadStrings(FILE_NAME));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return highScore;
    }

     public String getHighScore(String[] arrayDataIn) {
        int arraySize = arrayDataIn.length;

        for (int i = 0; i < arraySize; i++) {
            int newScore = 0;
            String[] nameScoreSplit = arrayDataIn[i].split(" ");
            newScore = Integer.parseInt(nameScoreSplit[1]);
            if(newScore > hiScore) {
                hiScore = newScore;
                playerName = nameScoreSplit[0];
            }
        }
        return playerName + " " + hiScore;
    }

    public void setHighScore(String newHighScore) {
        String[] nameScoreSplit = newHighScore.split(" ");
        int tempScore = Integer.parseInt(nameScoreSplit[1]);
        println(tempScore);
        if(hiScore < tempScore) {
            FileWriter output = null;
            try {
                output = new FileWriter(FULL_FILE_PATH, true);
                output.write(newHighScore + "\n");
                output.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
