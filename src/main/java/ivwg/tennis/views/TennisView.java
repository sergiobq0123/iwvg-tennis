package ivwg.tennis.views;

import ivwg.tennis.models.Player;
import ivwg.tennis.views.menu.RefereeMenu;
import ivwg.tennis.views.menu.StartMenu;
import ivwg.utils.WithConsoleView;

public class TennisView extends WithConsoleView {
    private final RefereeView refereeView = new RefereeView();
    private final PlayerView playerView = new PlayerView();
    private final MatchView matchView = new MatchView();
    private final SetView setView = new SetView();

    public void createReferee() {
        this.refereeView.addReferee();
        this.displayStartMenu();
    }

    public void loginReferee() {
        this.refereeView.login();
        this.displayRefereeMenu();
    }

    public void createPlayer() {
        this.playerView.addPlayer();
        displayRefereeMenu();
    }

    public void createMatch() {
        int numberSets = this.setView.readValidSets();
        Player p1 = this.playerView.getPlayer(MessageView.PLAYER_1.getMessage());
        Player p2 = this.playerView.getPlayer(MessageView.PLAYER_2.getMessage());

        this.matchView.addMatch(numberSets, p1, p2);
    }

    public void readPlayer() {
        this.playerView.readPlayers();
    }

    public void readMatch() {
        this.matchView.readMatches();
    }

    public void displayStartMenu() {
        new StartMenu(this).execute();
    }

    public void displayRefereeMenu() {
        new RefereeMenu(this).execute();
    }
}
