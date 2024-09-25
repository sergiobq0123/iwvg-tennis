package ivwg.tennis.views;

import ivwg.tennis.models.ScoreBoard;
import ivwg.tennis.types.PointType;
import ivwg.utils.WithConsoleView;

public class ScoreBoardView  extends WithConsoleView {
    private final ScoreBoard scoreBoard;
    private String[] scores = {"0", "15", "30", "40", "AD"};

    public ScoreBoardView(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void displayScore() {

        String matchId = "1"; // Cambia esto al ID del match actual

        String playerName1 = this.scoreBoard.getPlayers().get(0).getName();
        String playerName2 = this.scoreBoard.getPlayers().get(1).getName();

        String pointsPlayer1 = scores[this.scoreBoard.getGameScore().getScore(0)];
        String pointsPlayer2 = scores[this.scoreBoard.getGameScore().getScore(1)];

        int gamesPlayer1 = this.scoreBoard.getSetScore().getScore(0);
        int gamesPlayer2 = this.scoreBoard.getSetScore().getScore(1);

        boolean isFault = this.scoreBoard.isFault();
        int playerService = this.scoreBoard.getPlayerService();
        int numberOfSets = this.scoreBoard.getNumberOfSets();

        String player1Prefix = (0 == playerService) ? (isFault ? "+ " : "* ") : "  ";
        String player2Prefix = (1 == playerService) ? (isFault ? "+ " : "* ") : "  ";

        String pointType = "";
        switch (this.scoreBoard.getPointType()) {
            case POINT_REST -> pointType = PointType.POINT_REST.getMessage();
            case POINT_SERVICE -> pointType = PointType.POINT_SERVICE.getMessage();
            case LACK_SERVICE -> pointType = PointType.LACK_SERVICE.getMessage();
            default -> throw new IllegalStateException("Unexpected value: " + this.scoreBoard.getPointType());
        }

        this.console.writeln("match id:" + matchId + ">" + pointType);


        String displayPlayer1 = String.format("%s %s: %s %d - -", player1Prefix, playerName1, pointsPlayer1, gamesPlayer1);
        String displayPlayer2 = String.format("%s %s: %s %d - -", player2Prefix, playerName2, pointsPlayer2, gamesPlayer2);

        this.console.writeln(displayPlayer1);
        this.console.writeln(displayPlayer2);

    }

    public void score() {

    }
}