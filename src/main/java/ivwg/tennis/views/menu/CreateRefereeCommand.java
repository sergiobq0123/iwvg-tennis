package ivwg.tennis.views.menu;

import ivwg.tennis.views.MessageView;
import ivwg.tennis.views.TennisView;
import ivwg.utils.Command;

public class CreateRefereeCommand extends Command {
    TennisView tennisView;

    protected CreateRefereeCommand(TennisView tennisView) {
        super(MessageView.CREATE_REFEREE.getMessage());
        this.tennisView = tennisView;
    }

    @Override
    public void updateIsActive() {
        this.isActive = true;
    }

    @Override
    public void execute() {
        this.tennisView.createReferee();
    }
}
