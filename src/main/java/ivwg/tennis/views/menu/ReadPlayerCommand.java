package ivwg.tennis.views.menu;

import ivwg.tennis.views.MessageView;
import ivwg.tennis.views.TennisView;
import ivwg.utils.Command;

public class ReadPlayerCommand extends Command {
    TennisView tennisView;

    protected ReadPlayerCommand(TennisView tennisView) {
        super(MessageView.READ_PLAYER.getMessage());
        this.tennisView = tennisView;
    }

    @Override
    public void updateIsActive() {
        this.isActive = true;
    }

    @Override
    public void execute() {
        this.tennisView.readPlayer();
    }
}