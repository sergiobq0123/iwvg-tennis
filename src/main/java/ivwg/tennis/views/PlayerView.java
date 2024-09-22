package ivwg.tennis.views;

import ivwg.tennis.controllers.PlayerController;
import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;
import ivwg.utils.WithConsoleView;

public class PlayerView extends WithConsoleView {
    private PlayerController playerController;

    public PlayerView() {
        this.playerController = new PlayerController();
    }

    public void addPlayer() {
        this.console.writeln(MessageView.CREATE_PLAYER.getMessage());
        String name = this.console.readString(MessageView.CREATE_NAME.getMessage());
        Error error = playerController.addPlayer(new Player(name));
        this.handeldError(error);
    }

    public void readPlayers(){
        this.console.writeln(this.playerController.getPlayers().toString());
    }
}
