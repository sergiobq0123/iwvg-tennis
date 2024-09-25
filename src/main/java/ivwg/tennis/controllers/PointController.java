package ivwg.tennis.controllers;

import ivwg.tennis.models.Fault;
import ivwg.tennis.models.ScoreBoard;
import ivwg.tennis.types.Action;

public class PointController {

    public void playPoint(ScoreBoard scoreBoard) {
        scoreBoard.updatePointScore(Action.generateRandomAction());
    }
}