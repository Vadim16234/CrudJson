package repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {
    List<T> findAll();

    Optional<T> findById(Long ID);

    void deleteById(Long ID);

    void add(T t);

    void update(Long ID, String s1, String s2);
}
