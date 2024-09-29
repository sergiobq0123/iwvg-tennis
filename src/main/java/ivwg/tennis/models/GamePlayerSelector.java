package ivwg.tennis.models;

public interface GamePlayerSelector {
    void playGame(TieBreakGame tiebreakGame);
    void playGame(StandardGame standardGame);
}
