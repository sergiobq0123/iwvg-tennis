package ivwg.tennis.models;

public class GameFactory {

    public Game createGame(int numberGames, ScoreBoard scoreBoard){
        Game game;
        if(numberGames < 12){
            return game = new StandardGame(scoreBoard);
        }
        else
            return game = new TieBreakGame(scoreBoard);

    }

}
