package books.dao;

import books.dao.impl.GenericDaoImpl;
import java.util.List;

public interface GenericDao<T, V> {
    GenericDaoImpl<T, V> setTclass(Class<T> tclass);

    T create(T model);

    T getById(V id);

    public T getByField(String fieldName, Object value);

    List<T> getAll();

    T update(T model);

    boolean delete(T model);
}
