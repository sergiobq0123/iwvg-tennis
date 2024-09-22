package ivwg.tennis.types;

public enum Error {
    DUPLICATE_REFEREE,
    NOT_LOGIN,
    DUPLICATE_PLAYER,
    WRONG_NUMBER_OF_SETS,
    PLAYER_NOT_FOUND,
    NULL_ERROR;

    public boolean isNull(){
        return this == Error.NULL_ERROR;
    }
}
