package ivwg.tennis.models;

public interface GameSelector {
    void playGame(TieBreakGame tiebreakGame);
    void playGame(StandardGame standardGame);
}
