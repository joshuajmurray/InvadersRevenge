package edu.osucascades.cs361.chi;

import processing.core.PApplet;

import static processing.core.PApplet.println;

public class ScoreManager {

    private PApplet score;

    ScoreManager(PApplet currentP) {
        score = currentP;
    }

    public int readScoresFromFile() {
        int hiScore = 0;
        try {
            String[] test =  score.loadStrings("highScore.txt");
            int arraySize = test.length;
            //TODO sort array for highest score first
            System.out.println("there are " + arraySize + " lines");
            for (int i = 0; i < arraySize; i++) {
                String[] nameScoreSplit = test[i].split(" ");
                hiScore = Integer.parseInt(nameScoreSplit[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hiScore;
    }}
