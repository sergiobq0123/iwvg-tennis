package ivwg.tennis.views.menu;

import ivwg.tennis.views.TennisView;
import ivwg.utils.Menu;

public class StartMenu extends Menu {

    public StartMenu(TennisView tennisView) {
        this.commands.add(new CreateRefereeCommand(tennisView));
        this.commands.add(new LoginRefereeCommand(tennisView));
    }
}
