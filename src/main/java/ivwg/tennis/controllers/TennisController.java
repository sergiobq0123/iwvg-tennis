package ivwg.tennis.controllers;

import ivwg.tennis.views.TennisView;

public class TennisController {

    void play() {
        new TennisView().displayStartMenu();
    }

    public static void main(String[] args) {
        new TennisController().play();
    }
}
