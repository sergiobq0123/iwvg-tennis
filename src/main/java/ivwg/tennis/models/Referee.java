package ivwg.tennis.models;

import ivwg.tennis.database.RefereeDAO;

public class Referee {

    private String name;
    private String password;

    public Referee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
