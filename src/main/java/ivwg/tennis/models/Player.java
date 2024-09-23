package ivwg.tennis.models;

import ivwg.utils.Identifier;

public class Player extends Identifier {
    private String name;
    private boolean service;

    public Player(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean getService() {
        return service;
    }

    public void setService(boolean service) {
        this.service = service;
    }
}
