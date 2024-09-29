package ivwg.tennis.models;

import ivwg.utils.Identifier;

public class Player extends Identifier {
    private String name;

    public Player(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name : " + this.name + "; id : " + this.getId() ;
    }
}
