package ivwg.tennis.views;

import ivwg.tennis.controllers.MatchController;
import ivwg.tennis.models.Match;
import ivwg.tennis.models.Player;
import ivwg.utils.WithConsoleView;
import java.util.ArrayList;
import java.util.List;


public class MatchView extends WithConsoleView {
    private final MatchController matchController = new MatchController();

    public void addMatch(int numberSets, Player player1, Player player2 ) {
        Match match = new Match(numberSets, new ArrayList<>(List.of(player1, player2)));
        this.matchController.addMatch(match);
        this.playMatch(match);
    }

    public void readMatches(){
        this.console.writeln(this.matchController.getMatches().toString());
    }

    public void playMatch(Match match) {
        this.console.writeln(MessageView.ID.getMessage() + match.getId());
        this.console.writeln(MessageView.DATE.getMessage() + match.getDate());
        this.matchController.playMatch(match);
    }
}
