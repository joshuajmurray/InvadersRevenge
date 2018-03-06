package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Screen {
    public static final String START_TEXT = "Start Screen Test";
    public static final String PLAY_TEXT = "Invaders Revenge!";
    public static final String SCORE_TEXT = "Score: ";
    public static final String LIVES_TEXT = "Lives: ";
    int score;
    int lives;
    PApplet p;

    public Screen(int currentScore, int currentLives, PApplet currentP) {
        score = currentScore;
        lives = currentLives;
        p = currentP;
    }

    public void draw() {
        p.background(0,0,0);
        p.fill(255);
        p.textSize(36);
        p.text(PLAY_TEXT,(p.width/2)-(p.textWidth(PLAY_TEXT)/2),50);
        p.text(SCORE_TEXT,50,50);
        p.text(score, (50 + p.textWidth(SCORE_TEXT)),50);
        p.text(LIVES_TEXT,50,(p.height - 50));
        p.text(lives, (50 + p.textWidth(LIVES_TEXT)),(p.height - 50));
    }
}
