package ivwg.tennis.models;

public class Fault {
    private static final int MAX_CONSECUTIVE_FAULTS = 2;
    private int consecutiveFaults;

    public void sumFault() {
        consecutiveFaults++;
    }

    public void resetConsecutiveFaults() {
        consecutiveFaults = 0;
    }

    public boolean isSecondFault() {
        return consecutiveFaults >= MAX_CONSECUTIVE_FAULTS;
    }

    public boolean isFault() {
        return this.consecutiveFaults == 1;
    }
}
