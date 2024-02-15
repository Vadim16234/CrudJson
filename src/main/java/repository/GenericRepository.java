package repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    List<T> findAll();

    T findById(ID id);

    void deleteById(ID id);

    T add(T t);

    T update(T t);
}
