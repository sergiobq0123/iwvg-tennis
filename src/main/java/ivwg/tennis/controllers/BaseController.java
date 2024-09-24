package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class BaseController<T> {

    private final BaseDAO<T> baseDAO = new BaseDAO<>();

    public T addEntity(T item) {
        return baseDAO.addEntity(item);
    }

    public List<T> getAllEntities() {
        return baseDAO.getEntities();
    }

    public Optional<T> findEntityBy(Predicate<T> predicate) {
        return baseDAO.findBy(predicate);
    }

    public boolean removeEntity(T item) {
        return baseDAO.removeEntity(item);
    }

    public boolean existEntity(Predicate<T> predicate) {
        return baseDAO.existEntity(predicate);
    }
}