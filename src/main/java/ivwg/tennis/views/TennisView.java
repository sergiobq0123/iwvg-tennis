package ivwg.tennis.views;

import ivwg.tennis.models.Player;
import ivwg.utils.WithConsoleView;

public class TennisView extends WithConsoleView {
    private final RefereeView refereeView = new RefereeView();
    private final PlayerView playerView = new PlayerView();
    private final MatchView matchView = new MatchView();
    private final SetView setView = new SetView();


    public void interact(){
         // this.refereeView.addReferee();
        // this.refereeView.login();

        this.playerView.addPlayer();
        this.playerView.addPlayer();
        this.playerView.readPlayers();

        playMatch();

    }

    private void playMatch(){
        this.console.writeln(MessageView.CREATE_MATCH.getMessage());
        int numberSets = this.setView.readValidSets();
        Player p1 = this.playerView.getPlayer(MessageView.PLAYER_1.getMessage());
        Player p2 = this.playerView.getPlayer(MessageView.PLAYER_2.getMessage());

        this.matchView.addMatch(numberSets, p1, p2);
    }
}
