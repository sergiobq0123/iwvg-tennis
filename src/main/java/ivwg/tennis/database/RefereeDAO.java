package ivwg.tennis.database;

import ivwg.tennis.models.Referee;

import java.util.ArrayList;
import java.util.stream.Stream;

public class RefereeDAO {
    private final ArrayList<Referee> refereeList = new ArrayList<>();

    public void addReferee(Referee referee){
        refereeList.add(referee);
    }

    public Stream<Referee> findAll() {
        return refereeList.stream();
    }

    public boolean login(Referee referee) {
        return this.findAll()
                .anyMatch(rf ->
                    rf.getName().equals(referee.getName()) &&
                    rf.getPassword().equals(referee.getPassword())
                );
    }

    public boolean exists(Referee referee) {
        return this.findAll()
                .anyMatch(rf -> rf.getName().equals(referee.getName()));
    }
}