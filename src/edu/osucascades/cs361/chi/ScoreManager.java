package edu.osucascades.cs361.chi;

import processing.core.PApplet;

import static processing.core.PApplet.println;

public class ScoreManager {

    private PApplet score;

    ScoreManager() {
    }

    public int readScoresFromFile() {
        try {
            String[] test = score.loadStrings("highScore.txt");
            int arraySize = test.length;
            System.out.println("there are " + arraySize + " lines");

            for (int i = 0; i < arraySize; i++) {
                println(test[i]);
            }
            //sort array for highest score first
            return Integer.parseInt(test[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }}
