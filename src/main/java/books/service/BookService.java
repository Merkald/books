package books.service;

import books.model.Book;
import java.util.List;

public interface BookService {
    Book create(Book model);

    Book getById(Long id);

    public Book getByField(String fieldName, Object value);

    List<Book> getAll();

    Book update(Book model);

    boolean deleteById(Long id);
}
