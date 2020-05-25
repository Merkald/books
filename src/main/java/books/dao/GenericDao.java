package books.dao;

import books.dao.impl.GenericDaoImpl;
import java.util.List;

public interface GenericDao<T,V> {
    GenericDaoImpl<T,V> settClass(Class<T> tClass);

    T create(T model);

    T getById(V id);

    public T getByField(String fieldName, Object value);

    List<T> getAll();

    T update(T model);

    boolean deleteById(T model);
}
