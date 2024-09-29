package ivwg.tennis.controllers;

import ivwg.tennis.database.GenericDao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GenericController<T> {

    private final GenericDao<T> baseDAO = new GenericDao<>();

    public T addEntity(T item) {
        return baseDAO.addEntity(item);
    }

    public List<T> getAllEntities() {
        return baseDAO.getEntities();
    }

    public Optional<T> findEntityBy(Predicate<T> predicate) {
        return baseDAO.findBy(predicate);
    }

    public List<T> findAllEntitiesFilter(Predicate<T> predicate) {
        return baseDAO.findAllBy(predicate);
    }

    public boolean removeEntity(T item) {
        return baseDAO.removeEntity(item);
    }

    public boolean existEntity(Predicate<T> predicate) {
        return baseDAO.existEntity(predicate);
    }

    public T getEntity(Predicate<T> predicate) {
        return baseDAO.getEntity(predicate);
    }

    public void updateEntity(Predicate<T> predicate, T newItem) {
        baseDAO.updateEntity(predicate, newItem);
    }
}