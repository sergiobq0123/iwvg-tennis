package ivwg.tennis.views;

import ivwg.tennis.controllers.MatchController;
import ivwg.tennis.controllers.PlayerController;
import ivwg.tennis.models.Match;
import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;
import ivwg.utils.NumberSets;
import ivwg.utils.WithConsoleView;

import java.util.ArrayList;
import java.util.List;

public class MatchView extends WithConsoleView {
    private MatchController matchController;
    private PlayerController playerController;

    public MatchView() {
        this.matchController = new MatchController();
        this.playerController = new PlayerController();
    }

    public void addMatch() {
        this.console.writeln(MessageView.CREATE_MATCH.getMessage());

        int sets = this.readValidSets();

        int player1 = this.readValidPlayer(MessageView.PLAYER_1.getMessage());
        int player2 = this.readValidPlayer(MessageView.PLAYER_2.getMessage());

        Player p1 = playerController.getPlayer(player1);
        Player p2 = playerController.getPlayer(player2);

        Match match = new Match(sets, new ArrayList<>(List.of(p1, p2)));
        this.matchController.addMatch(match);
        this.playMatch(match);
    }

    private int readValidSets() {
        boolean ok = false;
        int sets = 0;
        do {
            sets = this.console.readInt(MessageView.CREATE_NUMBER_SETS.getMessage());
            Error error = new NumberSets().verifyNumberOfSets(sets);
            this.handeldError(error);
            ok = (error != Error.WRONG_NUMBER_OF_SETS);
        } while (!ok);
        return sets;
    }

    private int readValidPlayer(String message) {
        boolean ok = false;
        int playerId;
        do {
            playerId = this.console.readInt(message);
            Error error = this.playerController.playerExists(playerId);
            this.handeldError(error);
            ok = (error != Error.PLAYER_NOT_FOUND);
        } while (!ok);
        return playerId;
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
