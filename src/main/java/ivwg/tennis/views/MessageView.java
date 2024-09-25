package ivwg.tennis.views;

public enum MessageView{
    SEPARATOR("-----------------------------------------------------"),
    START_GAME("---------------------- TENNIS -----------------------"),
    START_REFEREE_VIEW("-------------------- REFEREE --------------------"),
    START_PLAYER_VIEW("--------------------- PLAYER --------------------"),
    CREATE_REFEREE("Create Referee"),
    CREATE_NAME("  - Name : "),
    CREATE_REFEREE_PASSWORD("  - Password : "),
    LOGIN_REFEREE("Login Referee"),
    CREATE_PLAYER("Create Player"),
    CREATE_MATCH("Create Match"),
    PLAYER_NOT_FOUND("Player not found"),
    CREATE_NUMBER_SETS("  - Sets : "),
    PLAYER_1("  - Player 1 : "),
    PLAYER_2("  - Player 2 : "),
    ID("id:  "),
    DATE("date:  "),
    READ_MATCH("Read Match"),
    READ_PLAYER("Read Player");


    private String message;

    private MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    void write() {
        System.out.print(this.message);
    }

    void writeln() {
        System.out.println(this.message);
    }
}
