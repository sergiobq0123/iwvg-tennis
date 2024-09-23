package ivwg.tennis.views;

import ivwg.tennis.types.Error;
import ivwg.utils.NumberSets;
import ivwg.utils.WithConsoleView;

public class SetView extends WithConsoleView {

    public int readValidSets() {
        Error error;
        int sets = 0;
        do {
            sets = this.console.readInt(MessageView.CREATE_NUMBER_SETS.getMessage());
            error = new NumberSets().verifyNumberOfSets(sets);
            this.handeldError(error);
        } while (!error.isNull());
        return sets;
    }
}
