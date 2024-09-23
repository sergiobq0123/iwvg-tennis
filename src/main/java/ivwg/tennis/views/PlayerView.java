package ivwg.tennis.views;

import ivwg.tennis.controllers.PlayerController;
import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;
import ivwg.utils.WithConsoleView;

import java.util.Optional;

public class PlayerView extends WithConsoleView {
    private final PlayerController playerController = new PlayerController();

    public void addPlayer() {
        this.console.writeln(MessageView.CREATE_PLAYER.getMessage());
        Error error;
        do {
            String name = this.console.readString(MessageView.CREATE_NAME.getMessage());
            error = this.playerController.addPlayer(new Player(name));
            this.handeldError(error);
        }while (!error.isNull());
    }

    public void readPlayers(){
        this.console.writeln(this.playerController.getAllEntities().toString());
    }

    public Player getPlayer(String message) {
        Player player = null;
        Error error;
        do {
            int playerId = this.console.readInt(message);
            Optional<Player> optionalPlayer = playerController.findEntityBy(p -> p.getId() == playerId);

            if (optionalPlayer.isEmpty()) {
                error = Error.PLAYER_NOT_FOUND;
                this.handeldError(error);
            } else {
                player = optionalPlayer.get();
                error = Error.NULL_ERROR;
            }
        } while (error != Error.NULL_ERROR);
        return player;
    }
}
