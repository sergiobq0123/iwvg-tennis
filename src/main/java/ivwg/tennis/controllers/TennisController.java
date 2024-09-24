package ivwg.tennis.controllers;

import ivwg.tennis.views.TennisView;

public class TennisController {

    private TennisView tennisView;

    void play() {
        this.tennisView = new TennisView();
        this.tennisView.interact();
    }

    public static void main(String[] args) {
        new TennisController().play();
    }
}
