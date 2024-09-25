package ivwg.tennis.views.menu;

import ivwg.tennis.views.TennisView;
import ivwg.utils.Menu;

public class RefereeMenu extends Menu {
    public RefereeMenu(TennisView tennisView) {
        this.commands.add(new CreatePlayerCommand(tennisView));
        this.commands.add(new ReadPlayerCommand(tennisView));
        this.commands.add(new CreateMatchCommand(tennisView));
        this.commands.add(new ReadMatchCommand(tennisView));
    }
}