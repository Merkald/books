package books.service.impl;

import books.dao.GenericDao;
import books.dao.impl.GenericDaoImpl;
import books.lib.Inject;
import books.lib.Service;
import books.model.Book;
import books.service.BookService;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    GenericDao<Book, Long> genericDao = new GenericDaoImpl<>();

    @Override
    public Book create(Book model) {
        return genericDao.setTclass(Book.class).create(model);
    }

    @Override
    public Book getById(Long id) {
        return genericDao.setTclass(Book.class).getById(id);
    }

    @Override
    public Book getByField(String fieldName, Object value) {
        return genericDao.setTclass(Book.class).getByField(fieldName,value);
    }

    @Override
    public List<Book> getAll() {
        return genericDao.getAll();
    }

    @Override
    public Book update(Book model) {
        return genericDao.update(model);
    }

    @Override
    public boolean delete(Book model) {
        return genericDao.delete(model);
    }
}
