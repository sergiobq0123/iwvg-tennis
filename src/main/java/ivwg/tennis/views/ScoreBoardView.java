package ivwg.tennis.views;

import ivwg.tennis.models.ScoreBoard;
import ivwg.tennis.models.SetScore;
import ivwg.tennis.types.PointType;
import ivwg.utils.WithConsoleView;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ScoreBoardView extends WithConsoleView {
    private final ScoreBoard scoreBoard;
    private static final String[] SCORES = {"0 ", "15", "30", "40", "AD"};
    private List<SetScore> setScores;

    public ScoreBoardView(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.setScores = new ArrayList<>();
    }

    public void displayScore( boolean isTiebreak) {
        String matchId = "1";
        String pointType = getPointTypeMessage();

        this.console.writeln("match id:" + matchId + ">" + pointType);
        if (!this.scoreBoard.hasWinner(scoreBoard.getGameScore())) {
            displayPlayerScores(isTiebreak);
        }
    }

    private String getPointTypeMessage() {
        return switch (this.scoreBoard.getPointType()) {
            case POINT_REST -> PointType.POINT_REST.getMessage();
            case POINT_SERVICE -> PointType.POINT_SERVICE.getMessage();
            case LACK_SERVICE -> PointType.LACK_SERVICE.getMessage();
            default -> throw new IllegalStateException("Unexpected value: " + this.scoreBoard.getPointType());
        };
    }

    private void displayPlayerScores(boolean isTiebreak) {
        String playerName1 = this.scoreBoard.getPlayers().get(0).getName();
        String playerName2 = this.scoreBoard.getPlayers().get(1).getName();

        String pointsPlayer1 = getPoints(0, isTiebreak);
        String pointsPlayer2 = getPoints(1, isTiebreak);

        List<Integer> gamesPlayer1 = new ArrayList<>();
        List<Integer> gamesPlayer2 = new ArrayList<>();
        setGames(gamesPlayer1, gamesPlayer2);

        String player1Prefix = getPlayerPrefix(0);
        String player2Prefix = getPlayerPrefix(1);

        String displayPlayer1 = formatPlayerDisplay(player1Prefix, playerName1, pointsPlayer1, gamesPlayer1);
        String displayPlayer2 = formatPlayerDisplay(player2Prefix, playerName2, pointsPlayer2, gamesPlayer2);

        this.console.writeln(displayPlayer1);
        this.console.writeln(displayPlayer2);
    }

    private String getPlayerPrefix(int playerIndex) {
        boolean isServing = playerIndex == this.scoreBoard.getPlayerService();
        boolean isFault = this.scoreBoard.isFault();
        return isServing ? (isFault ? "+ " : "* ") : "  ";
    }

    private String formatPlayerDisplay(String prefix, String name, String points, List<Integer> games) {
        return String.format("%s %s: %s %s - -", prefix, name, points, formatGames(games));
    }

    private String getPoints(int playerIndex, boolean tiebreak) {
        int points = this.scoreBoard.getGameScore().getScore(playerIndex);
        if(tiebreak) {
            return String.valueOf(points);
        }
        int pointFoe = this.scoreBoard.getGameScore().getScore((playerIndex + 1) % 2);
        if (points < 4) {
            return SCORES[points];
        } else if (points == pointFoe || points < pointFoe) {
            return "40";
        } else {
            return "AD";
        }
    }

    public void addPlayedSet(SetScore score) {
        this.setScores.add(score);
    }

    private void setGames(List<Integer> gamesPlayer1, List<Integer> gamesPlayer2) {
        gamesPlayer1.add(this.scoreBoard.getSetScore().getScore(0));
        gamesPlayer2.add(this.scoreBoard.getSetScore().getScore(1));

        for (SetScore score : setScores) {
            gamesPlayer1.add(score.getScore(0));
            gamesPlayer2.add(score.getScore(1));
        }
    }

    private String formatGames(List<Integer> games) {
        return games.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

}