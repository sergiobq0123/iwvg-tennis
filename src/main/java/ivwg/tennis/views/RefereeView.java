package ivwg.tennis.views;

import ivwg.tennis.controllers.RefereeController;
import ivwg.tennis.models.Referee;
import ivwg.tennis.types.Error;
import ivwg.utils.WithConsoleView;


public class RefereeView extends WithConsoleView {

    private final RefereeController refereeController = new RefereeController();

    public void addReferee() {
        Error error;
        do {
            String name = readName();
            String password = readPassword();

            error = this.refereeController.addReferee(new Referee(name, password));
            this.handeldError(error);
        }while (!error.isNull());
    }

    public void login() {
        Error error;
        do {
            String name = readName();
            String password = readPassword();

            error = this.refereeController.login(name, password);
            this.handeldError(error);
        }while (!error.isNull());

    }

    private String readName() {
        return this.console.readString(MessageView.CREATE_NAME.getMessage());
    }

    private String readPassword() {
        return this.console.readString(MessageView.CREATE_REFEREE_PASSWORD.getMessage());
    }

}
