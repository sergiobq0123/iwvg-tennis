package ivwg.tennis.models;

import ivwg.tennis.types.Action;
import ivwg.tennis.types.PointType;
import ivwg.tennis.views.ScoreBoardView;

import java.util.List;
import java.util.Random;

public class ScoreBoard {

    private SetScore setScore;
    private MatchScore matchScore;
    private GameScore gameScore;
    private List<Player> players;
    private int service;
    private int serviceTiebreak = -1;
    private final Fault fault;
    private PointType pointType;
    private ScoreBoardView scoreBoardView;

    public ScoreBoard(int numberSets, List<Player> players) {
        Random random = new Random();
        service = random.nextInt(2);
        matchScore = new MatchScore(players, numberSets);
        setScore = new SetScore(players);
        gameScore = new GameScore(players);
        this.players = players;
        this.fault = new Fault();
        scoreBoardView= new ScoreBoardView(this);
    }

    public boolean hasWinner(Score score) {
        return score.hasWinner();
    }

    public boolean hasWinnerTieBreak() {
        return this.gameScore.hasWinnerTieBreak();
    }

    public void changeService() {
        if (this.serviceTiebreak != -1) {
            this.service = this.serviceTiebreak;
            this.serviceTiebreak = -1;
        }
        this.service = updateService();
    }

    public void resetScore(Score score) {
        score.reset();
    }

    public void updateScore(Score score, int i) {
        this.resetFaultIfExists();
        score.updateScore(i);
        this.setTypePoint(i);
    }

    private void resetFaultIfExists() {
        if(fault.isFault()){
            this.resetFault();
        }
    }

    private void setTypePoint(int i){
        if(i == this.service) {
            pointType = PointType.POINT_SERVICE;
        }else {
            pointType = PointType.POINT_REST;
        }
    }

    public void updateScoreAfterWin(Score updateScore, Score winnerScore) {
        int winnerId = winnerScore.getIdWinner();
        if (winnerId == this.players.getFirst().getId()) {
            this.updateScore(updateScore, 0);
        } else
            this.updateScore(updateScore, 1);
    }

    public void updatePointScore(Action action) {
        switch (action) {
            case Action.FAULT -> {
                this.handledFault();
                pointType = PointType.LACK_SERVICE;
            }
            case Action.WIN_PLAYER_1 -> {
                this.updateScore(gameScore, 0);
            }
            case Action.WIN_PLAYER_2 ->{
                this.updateScore(gameScore, 1);
            }
            default -> throw new IllegalStateException("Unexpected value: " + action);
        }
        this.displayScoreBoard();
    }

    private void handledFault() {
        fault.sumFault();
        if(fault.isSecondFault()){
            fault.resetConsecutiveFaults();
            this.updateScore(gameScore, this.updateService());
        }
    }

    public int getService() {
        return this.service;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getActualGames() {
        return this.setScore.getActualGames();
    }

    public SetScore getSetScore() {
        return setScore;
    }

    public MatchScore getMatchScore() {
        return matchScore;
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public void setServiceTiebreak(int serviceTiebreak) {
        this.serviceTiebreak = serviceTiebreak;
    }

    private int updateService() {
        return (service + 1) % 2;
    }

    public boolean isFault() {
        return fault.isFault();
    }

    public int getPlayerService() {
        return this.service;
    }

    public int getNumberOfSets() {
        return this.matchScore.getNumberSets();
    }

    public PointType getPointType() {
        return pointType;
    }

    public void resetFault(){
        fault.resetConsecutiveFaults();
    }

    public void addSetGamesToView(SetScore setScore) {
        scoreBoardView.addPlayedSet(setScore);
    }
    public void displayScoreBoard(){
        scoreBoardView.displayScore();
    }

}
