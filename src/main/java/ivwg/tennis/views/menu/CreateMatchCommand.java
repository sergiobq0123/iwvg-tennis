package ivwg.tennis.views.menu;

import ivwg.tennis.views.MessageView;
import ivwg.tennis.views.TennisView;
import ivwg.utils.Command;

public class CreateMatchCommand extends Command {
    TennisView tennisView;

    protected CreateMatchCommand(TennisView tennisView) {
        super(MessageView.CREATE_MATCH.getMessage());
        this.tennisView = tennisView;
    }

    @Override
    public void updateIsActive() {
        this.isActive = true;
    }

    @Override
    public void execute() {
        this.tennisView.createMatch();
    }
}