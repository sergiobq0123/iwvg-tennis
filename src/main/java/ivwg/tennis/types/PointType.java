package ivwg.tennis.types;

public enum PointType {
    LACK_SERVICE("lackService"),
    POINT_REST("pointRest"),
    POINT_SERVICE("pointService");

    private String message;

    private PointType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
