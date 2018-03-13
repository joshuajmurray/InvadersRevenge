package edu.osucascades.cs361.chi;

import processing.core.PApplet;

import java.util.Arrays;
import java.util.Comparator;

import static processing.core.PApplet.println;

public class ScoreManager {

    private PApplet score;
    int hiScore = 0;
    String playerName = "";

    ScoreManager(PApplet currentP) {
        score = currentP;
    }

    public int readScoresFromFile() {
        try {
            println(getHighScore(score.loadStrings("highScore.txt")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hiScore;
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

}
