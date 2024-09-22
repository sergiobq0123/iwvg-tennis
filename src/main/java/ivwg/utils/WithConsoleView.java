package ivwg.utils;

import ivwg.tennis.types.Error;
import ivwg.tennis.views.ErrorView;

public abstract class WithConsoleView {

    protected Console console;

    protected WithConsoleView() {
        this.console = new Console();
    }

    protected void handeldError(Error error){
        if(!error.isNull()) {
            new ErrorView(error).writeln();
        }
    }
}
