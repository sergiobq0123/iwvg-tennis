package ivwg.tennis.views;

public class TennisView {
    private RefereeView refereeView;
    private PlayerView playerView;
    private MatchView matchView;

    public TennisView() {
        this.refereeView = new RefereeView();
        this.playerView = new PlayerView();
        this.matchView = new MatchView();
    }

    public void interact(){
        //this.refereeView.addReferee();
        //this.refereeView.login();

        this.playerView.addPlayer();
        this.playerView.addPlayer();
        this.playerView.readPlayers();

        this.matchView.addMatch();
        this.matchView.readMatches();
    }
}
