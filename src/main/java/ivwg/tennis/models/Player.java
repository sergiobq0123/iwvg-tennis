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

    public Player copy() {
        return new Player(this.name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
