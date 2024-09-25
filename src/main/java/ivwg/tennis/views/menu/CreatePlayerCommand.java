package ivwg.tennis.views.menu;

import ivwg.tennis.views.MessageView;
import ivwg.tennis.views.TennisView;
import ivwg.utils.Command;

public class CreatePlayerCommand extends Command {
    TennisView tennisView;

    protected CreatePlayerCommand(TennisView tennisView) {
        super(MessageView.CREATE_PLAYER.getMessage());
        this.tennisView = tennisView;
    }

    @Override
    public void updateIsActive() {
        this.isActive = true;
    }

    @Override
    public void execute() {
        this.tennisView.createPlayer();
    }
}
