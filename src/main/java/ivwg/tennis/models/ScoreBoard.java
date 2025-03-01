package ivwg.tennis.models;

import ivwg.tennis.types.Action;
import ivwg.tennis.types.PointType;
import ivwg.tennis.views.ScoreBoardView;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ScoreBoard {

    private SetScore setScore;
    private final MatchScore matchScore;
    private final GameScore gameScore;
    private final List<Player> players;
    private int service;
    private Optional<Integer> serviceTiebreak = Optional.empty();
    private final Fault fault;
    private PointType pointType;
    private final ScoreBoardView scoreBoardView;

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

    public void setTiebreak(boolean tiebreak){
        this.gameScore.setTieBreak(tiebreak);
    }

    public void changeService() {
        if (this.serviceTiebreak.isPresent()) {
            this.service = this.serviceTiebreak.get();
            this.serviceTiebreak = Optional.empty();
        }
        this.service = updateService();
    }

    public void resetScore(Score score) {
        score.reset();
    }

    public void updateScore(Score score, int i) {
        this.resetFault();
        score.updateScore(i);
        this.setTypePoint(i);
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
            case Action.WIN_PLAYER_1 ->
                this.updateScore(gameScore, 0);
            case Action.WIN_PLAYER_2 ->
                this.updateScore(gameScore, 1);
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

    public void setServiceTiebreak(Integer serviceTiebreak) {
        this.serviceTiebreak = Optional.ofNullable(serviceTiebreak);
    }

    private int updateService() {
        return (service + 1) % 2;
    }

    public int getPlayerService() {
        return this.service;
    }

    public PointType getPointType() {
        return pointType;
    }

    public void resetFault(){
        if(isFault()){
            fault.resetConsecutiveFaults();
        }
    }

    public boolean isFault() {
        return fault.isFault();
    }

    public void addSetGamesToView(SetScore setScore) {
        scoreBoardView.addPlayedSet(setScore);
    }
    public void displayScoreBoard(){
        scoreBoardView.displayScore(this.gameScore.isTieBreak());
    }

    public int getSetResult(int i){
        return this.setScore.getScore(i);
    }

    private void setSetScore(SetScore setScore) {
        this.setScore = setScore;
    }

    public ScoreBoard copy(){
        ScoreBoard copiedScoreBoard = new ScoreBoard(this.matchScore.getNumberSets(), this.players);
        copiedScoreBoard.setSetScore(this.setScore.copy());
        return copiedScoreBoard;
    }

}
