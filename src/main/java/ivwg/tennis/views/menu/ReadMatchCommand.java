package ivwg.tennis.views.menu;

import ivwg.tennis.views.MessageView;
import ivwg.tennis.views.TennisView;
import ivwg.utils.Command;

public class ReadMatchCommand extends Command {
    TennisView tennisView;

    protected ReadMatchCommand(TennisView tennisView) {
        super(MessageView.READ_MATCH.getMessage());
        this.tennisView = tennisView;
    }

    @Override
    public void updateIsActive() {
        this.isActive = true;
    }

    @Override
    public void execute() {
        this.tennisView.readMatch();
    }
}