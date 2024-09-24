package ivwg.tennis.controllers;

import ivwg.tennis.models.ScoreBoard;

import java.util.Random;

public class PointController {

    private static final int MAX_CONSECUTIVE_FAULTS = 2;
    private final ScoreBoard scoreBoard;
    private int consecutiveFaults=0;

    public PointController(ScoreBoard scoreBoard){
        this.scoreBoard = scoreBoard;
    }

    public void playPoint(){
        Random random = new Random();
        int action = random.nextInt(3);
            switch (action) {
                case 0 -> handleFault();
                case 1 -> {
                    this.scoreBoard.updatePointScore(false,true);
                    this.resetConsecutiveFaults();
                }
                case 2 -> {
                    this.scoreBoard.updatePointScore(false,false);
                    this.resetConsecutiveFaults();
                }
        }
    }

    private void handleFault() {
        consecutiveFaults++;
        if (consecutiveFaults != MAX_CONSECUTIVE_FAULTS) {
            this.playPoint();
            //Vista pintar
        } else {
            this.scoreBoard.updatePointScore(true, true);
            resetConsecutiveFaults();
        }
    }

    private void resetConsecutiveFaults() {
        consecutiveFaults = 0;
    }

}
