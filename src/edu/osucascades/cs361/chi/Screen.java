package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Screen {
    public static final String START_TEXT = "Start Screen Test";
    private static final String PLAY_TEXT = "Invaders Revenge!";
    private static final String SCORE_TEXT = "Score: ";
    private static final String LIVES_TEXT = "Lives: ";
    private int score;
    private int lives;
    private PApplet canvas;

    Screen(int currentScore, int currentLives, PApplet currentP) {
        score = currentScore;
        lives = currentLives;
        canvas = currentP;
    }

    public void draw() {
        canvas.background(0,0,0);
        canvas.fill(255);
        canvas.textSize(36);
        canvas.text(PLAY_TEXT,(canvas.width/2)-(canvas.textWidth(PLAY_TEXT)/2),50);
        canvas.text(SCORE_TEXT,50,50);
        canvas.text(score, (50 + canvas.textWidth(SCORE_TEXT)),50);
        canvas.text(LIVES_TEXT,50,(canvas.height - 50));
        canvas.text(lives, (50 + canvas.textWidth(LIVES_TEXT)),(canvas.height - 50));
    }
}
