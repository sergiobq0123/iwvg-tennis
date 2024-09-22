package ivwg.tennis.views;

import ivwg.utils.WithConsoleView;
import ivwg.tennis.types.Error;

public class ErrorView extends WithConsoleView {

    public  static final String[] MESSAGES = {
            "Duplicate entry for Referee",
            "Username or password invalid",
            "Duplicate entry for Player",
            "Please, introduce 3 or 5 sets",
            "User not found, please select a valid id"
    };

    protected Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public void writeln() {
        this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
    }
}
