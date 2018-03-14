package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Screen implements Drawable {
    public static final String START_TEXT = "Press start to begin";
    private static final String PLAY_TEXT = "Invaders Revenge!";
    private static final String SCORE_TEXT = "Score: ";
    private static final String LIVES_TEXT = "Lives: ";
    private static final String PAUSE_TEXT = "PAUSE";
    private static final String GAME_OVER_TEXT = "GAME OVER";
    private static final String HIGH_SCORE_TEXT = "High Score: ";
    private static final int START = 0;
    private static final int PLAY = 1;
    private static final int PAUSE = 2;
    private static final int GAME_OVER = 3;
    private String highScore = " ";
    private int score;
    private int lives;
    private PApplet canvas;
    private ScoreManager scoreData;
    public int page = PLAY;//TODO setup as a global to select screens

    Screen(int currentScore, int currentLives, PApplet currentP) {
        score = currentScore;
        lives = currentLives;
        canvas = currentP;
        scoreData = new ScoreManager(canvas);
        highScore = scoreData.readScoresFromFile();
        scoreData.setHighScore("test5 5038");//for testing only
    }

    public void draw() {
        displayCommonScreenValues();

        if(page == START) {
            displayStartScreen();
        } else if(page == PLAY) {
            displayPlayScreen();
        }else if(page == PAUSE) {
            displayPauseScreen();
        } else if(page == GAME_OVER) {
            displayGameOverScreen();
        }
    }

    private void displayCommonScreenValues() {
        canvas.background(0, 0, 0);
        canvas.fill(255);
        canvas.textSize(36);
        canvas.text(PLAY_TEXT, (canvas.width / 2) - (canvas.textWidth(PLAY_TEXT) / 2), 50);
    }

    private void displayStartScreen() {
        canvas.text(START_TEXT, (canvas.width/2) - ((canvas.textWidth(START_TEXT))/2), (canvas.height/2));
    }

    private void displayPlayScreen() {
        drawScoreLives();
        canvas.text(lives, (50 + canvas.textWidth(LIVES_TEXT)), (canvas.height - 50));
//        canvas.text(highScore, (canvas.width/2) + (canvas.textWidth(HIGH_SCORE_TEXT))/2, ((canvas.height/2) + 50));//TODO remove when done testing
    }

    private void displayPauseScreen() {
        drawScoreLives();
        canvas.text(lives, (50 + canvas.textWidth(LIVES_TEXT)), (canvas.height - 50));
        canvas.text(PAUSE_TEXT, (canvas.width/2) - ((canvas.textWidth(PAUSE_TEXT))/2), (canvas.height/2));
    }

    private void displayGameOverScreen() {
        canvas.text(GAME_OVER_TEXT, (canvas.width/2) - ((canvas.textWidth(GAME_OVER_TEXT))/2), (canvas.height/2));
        canvas.text(HIGH_SCORE_TEXT, (canvas.width/2) - ((canvas.textWidth(HIGH_SCORE_TEXT))/2), ((canvas.height/2) + 50));
        canvas.text(highScore, (canvas.width/2) + (canvas.textWidth(HIGH_SCORE_TEXT))/2, ((canvas.height/2) + 50));
    }

    private void drawScoreLives() {
        canvas.text(SCORE_TEXT, 50, 50);
        canvas.text(score, (50 + canvas.textWidth(SCORE_TEXT)), 50);
        canvas.text(LIVES_TEXT, 50, (canvas.height - 50));
    }

    public void updateScore(){
        this.score += 10000;
    }
}