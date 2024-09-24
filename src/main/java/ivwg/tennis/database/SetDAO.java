package ivwg.tennis.database;

import ivwg.tennis.models.Set;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SetDAO {

    private static final ArrayList<Set> setList = new ArrayList<>();

    public Stream<Set> findAll() {
        return setList.stream();
    }

    public void addSet(Set set){
        setList.add(set);
    }

    public List<Set> getSets(){
        return setList;
    }
}
