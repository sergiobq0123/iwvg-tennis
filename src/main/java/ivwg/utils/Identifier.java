package ivwg.utils;

public abstract class Identifier {

    private static int currentId = 0;
    private final int id;

    protected Identifier() {
        this.id = ++currentId;
    }

    public int getId() {
        return id;
    }
}
