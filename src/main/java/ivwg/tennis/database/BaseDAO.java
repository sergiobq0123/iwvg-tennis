package ivwg.tennis.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BaseDAO<T> {

    private final List<T> itemList = new ArrayList<>();

    public Stream<T> findAll() {
        return itemList.stream();
    }

    public T addEntity(T item) {
        if (!existEntity(entity -> entity.equals(item))) {
            itemList.add(item);
            return item;
        }
        return null;
    }

    public boolean removeEntity(T item) {
        return itemList.remove(item);
    }

    public Optional<T> findBy(Predicate<T> predicate) {
        return itemList.stream().filter(predicate).findFirst();
    }

    public List<T> findAllBy(Predicate<T> predicate) {
        return itemList.stream().filter(predicate).toList();
    }

    public boolean existEntity(Predicate<T> predicate) {
        return findBy(predicate).isPresent();
    }

    public List<T> getEntities() {
        return itemList;
    }

    public T getEntity(Predicate<T> predicate) {
        return findBy(predicate).orElse(null);
    }

}
