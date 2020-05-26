package books.service;

import books.model.Author;
import java.util.List;

public interface AuthorService {
    Author create(Author model);

    Author getById(Long id);

    Author getByField(String fieldName, Object value);

    List<Author> getAll();

    Author update(Author model);

    boolean delete(Author book);
}
