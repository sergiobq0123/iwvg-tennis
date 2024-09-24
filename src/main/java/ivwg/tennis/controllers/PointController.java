package ivwg.tennis.controllers;

import ivwg.tennis.models.Fault;
import ivwg.tennis.models.ScoreBoard;
import ivwg.tennis.types.Action;

public class PointController {

    private Fault fault;

    public PointController(){
        this.fault = new Fault();
    }

    public void playPoint(ScoreBoard scoreBoard) {
        Action action = Action.generateRandomAction();
        if (action != Action.FAULT){
            scoreBoard.updatePointScore(action);
            fault.resetConsecutiveFaults();
        }else {
            handledFault(scoreBoard);
        }
    }

    private void handledFault(ScoreBoard scoreBoard) {
        fault.sumFault();
        if(fault.isSecondFault()){
            // GetServicePlayer()
            fault.resetConsecutiveFaults();
        }else {
            playPoint(scoreBoard);
        }
    }
}
