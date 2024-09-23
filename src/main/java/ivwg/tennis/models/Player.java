package ivwg.tennis.models;

public class Player {
    private int id;
    private String name;
    private boolean service;

    public Player(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
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
