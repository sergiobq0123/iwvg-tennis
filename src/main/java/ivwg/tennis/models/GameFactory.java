package ivwg.tennis.models;

public class GameFactory {

    public Game createGame(int numberGames, ScoreBoard scoreBoard){
        if(numberGames < 12){
            return new StandardGame(scoreBoard);
        }
        else
            return new TieBreakGame(scoreBoard);
    }

}
