package ivwg.tennis.views.menu;

import ivwg.tennis.views.MessageView;
import ivwg.tennis.views.TennisView;
import ivwg.utils.Command;

public class LoginRefereeCommand extends Command {

    TennisView tennisView;

    protected LoginRefereeCommand(TennisView tennisView) {
        super(MessageView.LOGIN_REFEREE.getMessage());
        this.tennisView = tennisView;
    }

    @Override
    public void updateIsActive() {
        this.isActive = true;
    }

    @Override
    public void execute() {
        this.tennisView.loginReferee();
    }
}
