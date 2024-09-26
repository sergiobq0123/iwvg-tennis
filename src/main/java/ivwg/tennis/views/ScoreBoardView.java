package ivwg.tennis.views;

import ivwg.tennis.models.ScoreBoard;
import ivwg.tennis.models.SetScore;
import ivwg.tennis.types.PointType;
import ivwg.utils.WithConsoleView;

import java.util.List;
import java.util.ArrayList;

public class ScoreBoardView  extends WithConsoleView {
    private final ScoreBoard scoreBoard;
    private String[] scores = {"0 ", "15", "30", "40", "AD"};

    private List<SetScore> setScores;

    public ScoreBoardView(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.setScores = new ArrayList<SetScore>();
    }

    public void displayScore() {

        String matchId = "1";

        String playerName1 = this.scoreBoard.getPlayers().get(0).getName();
        String playerName2 = this.scoreBoard.getPlayers().get(1).getName();

        String pointsPlayer1 = getPoints(0);
        String pointsPlayer2 = getPoints(1);

        List<Integer> gamesPlayer1 = new ArrayList<Integer>();
        List<Integer> gamesPlayer2 = new ArrayList<Integer>();

        this.setGames(gamesPlayer1,gamesPlayer2);

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


        String displayPlayer1 = String.format("%s %s: %s %s - -", player1Prefix, playerName1, pointsPlayer1, formatGames(gamesPlayer1));
        String displayPlayer2 = String.format("%s %s: %s %s - -", player2Prefix, playerName2, pointsPlayer2,  formatGames(gamesPlayer2));

        this.console.writeln(displayPlayer1);
        this.console.writeln(displayPlayer2);
    }

    private String getPoints(int i){
        int points= this.scoreBoard.getGameScore().getScore(i);
        int pointFoe = this.scoreBoard.getSetScore().getScore((i+1)%2);
        if(points < 4){
            return scores[points];
        }
        else if(points == pointFoe){
            return "40";
        }
        else{
            return "AD";
        }
    }

    public void addPlayedSet(SetScore score){
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
        StringBuilder formattedGames = new StringBuilder();
        for (int i = 0; i < games.size(); i++) {
            formattedGames.append(games.get(i));
            if (i < games.size() - 1) {
                formattedGames.append(" ");
            }
        }
        return formattedGames.toString();
    }

    public void score() {

    }
}