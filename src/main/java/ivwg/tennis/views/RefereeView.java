package ivwg.tennis.views;

import ivwg.tennis.controllers.RefereeController;
import ivwg.tennis.models.Referee;
import ivwg.tennis.types.Error;
import ivwg.utils.WithConsoleView;


public class RefereeView extends WithConsoleView {

    private RefereeController refereeController;

    public RefereeView() {
        refereeController = new RefereeController();
    }

    public void addReferee() {
        this.console.writeln(MessageView.CREATE_REFEREE.getMessage());
        String name = this.console.readString(MessageView.CREATE_NAME.getMessage());
        String password = this.console.readString(MessageView.CREATE_REFEREE_PASSWORD.getMessage());

        Error error = this.refereeController.addReferee(new Referee(name, password));
        this.handeldError(error);
    }

    public void login() {
        this.console.writeln(MessageView.LOGIN_REFEREE.getMessage());

        String name = this.console.readString(MessageView.CREATE_NAME.getMessage());
        String password = this.console.readString(MessageView.CREATE_REFEREE_PASSWORD.getMessage());

        Error error = this.refereeController.login(name, password);
        this.handeldError(error);
    }

}
