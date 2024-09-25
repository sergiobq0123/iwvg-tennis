package ivwg.utils;

public abstract class Command{

    protected String title;
    protected boolean isActive;

    protected Command(String message) {
        this.title = message;
    }

    protected boolean isActive() {
        return this.isActive;
    }

    String getTitle() {
        return this.title;
    }

    public abstract void updateIsActive();

    public abstract void execute();

}
