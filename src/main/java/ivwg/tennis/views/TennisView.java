package ivwg.tennis.views;

import ivwg.tennis.controllers.MatchController;
import ivwg.tennis.controllers.PlayerController;
import ivwg.tennis.controllers.SetController;
import ivwg.tennis.models.Player;
import ivwg.tennis.views.menu.RefereeMenu;
import ivwg.tennis.views.menu.StartMenu;
import ivwg.utils.WithConsoleView;

public class TennisView extends WithConsoleView {

    SetController setController = new SetController();
    MatchController matchController = new MatchController(setController);
    PlayerController playerController = new PlayerController();

    private final RefereeView refereeView = new RefereeView();
    private final PlayerView playerView = new PlayerView(playerController,matchController);
    private final MatchView matchView = new MatchView(matchController);
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
        this.playerView.readPlayers();
        int numberSets = this.setView.readValidSets();
        Player p1 = this.playerView.getPlayer(MessageView.PLAYER_1.getMessage());
        Player p2 = this.playerView.getPlayer(MessageView.PLAYER_2.getMessage());

        this.matchView.addMatch(numberSets, p1, p2);
        displayRefereeMenu();
    }

    public void readPlayer() {
        this.playerView.readPlayers();
        Player p1 = this.playerView.getPlayer(MessageView.PLAYER_1.getMessage());
        this.playerView.readPlayerById(p1.getId());
        this.matchView.readMatchesCompletedByPlayer(p1.getId());
        this.playerView.readPlayerWinPercentage(p1.getId());
        this.displayRefereeMenu();
    }

    public void readMatch() {
        int idMatch = this.matchView.selectMatch();
        this.matchView.readMatch(idMatch);
        this.displayRefereeMenu();
    }

    public void displayStartMenu() {
        new StartMenu(this).execute();
    }

    public void displayRefereeMenu() {
        new RefereeMenu(this).execute();
    }
}
