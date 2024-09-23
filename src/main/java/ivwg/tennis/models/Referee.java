package ivwg.tennis.models;

import ivwg.utils.Identifier;
import ivwg.tennis.types.Error;

public class Referee extends Identifier {

    private String name;
    private String password;

    public Referee(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
