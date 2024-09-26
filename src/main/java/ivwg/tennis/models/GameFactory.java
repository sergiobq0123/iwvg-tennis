package ivwg.tennis.models;

public class GameFactory {

    public Game createGame(int numberGames, ScoreBoard scoreBoard, int setId){
        if(numberGames < 12){
            return new StandardGame(scoreBoard,setId);
        }
        else
            return new TieBreakGame(scoreBoard,setId);
    }

}
