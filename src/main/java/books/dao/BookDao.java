package books.dao;

import books.model.Book;
import java.util.List;

public interface BookDao {
    Book create(Book model);

    Book getById(Long id);

    List<Book> getAll();

    Book update(Book model);

    boolean deleteById(Long id);
}
