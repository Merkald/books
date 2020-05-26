package books.service;

import books.model.Genre;
import java.util.List;

public interface GenreService {
    Genre create(Genre model);

    Genre getById(Long id);

    public Genre getByField(String fieldName, Object value);

    List<Genre> getAll();

    Genre update(Genre model);

    boolean delete(Genre model);
}
