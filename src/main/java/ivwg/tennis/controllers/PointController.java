package ivwg.tennis.controllers;

import ivwg.tennis.models.Fault;
import ivwg.tennis.models.ScoreBoard;
import ivwg.tennis.types.Action;

public class PointController {

    private final ScoreBoard scoreBoard;
    private Fault fault;

    public PointController(ScoreBoard scoreBoard){
        this.scoreBoard = scoreBoard;
        this.fault = new Fault();
    }

    public void playPoint() {
        Action action = Action.generateRandomAction();
        if (action != Action.FAULT){
            scoreBoard.updatePointScore(action);
            fault.resetConsecutiveFaults();
        }else {
            handledFault();
        }
    }

    private void handledFault() {
        fault.sumFault();
        if(fault.isSecondFault()){
            // GetServicePlayer()
            fault.resetConsecutiveFaults();
        }else {
            playPoint();
        }
    }
}
