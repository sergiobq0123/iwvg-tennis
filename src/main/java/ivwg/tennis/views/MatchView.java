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
import java.util.UUID;

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

        UUID player1 = this.readValidPlayer(MessageView.PLAYER_1.getMessage());
        UUID player2 = this.readValidPlayer(MessageView.PLAYER_2.getMessage());

        Player p1 = playerController.getPlayer(player1);
        Player p2 = playerController.getPlayer(player2);

        this.matchController.addMatch(new Match(sets, new ArrayList<>(List.of(p1, p2))));
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

    private UUID readValidPlayer(String message) {
        boolean ok = false;
        UUID playerId;
        do {
            playerId = UUID.fromString(this.console.readString(message));
            Error error = this.playerController.playerExists(playerId);
            this.handeldError(error);
            ok = (error != Error.PLAYER_NOT_FOUND);
        } while (!ok);
        return playerId;
    }

    public void readPlayers(){
        this.console.writeln(this.matchController.getMatches().toString());
    }
}
