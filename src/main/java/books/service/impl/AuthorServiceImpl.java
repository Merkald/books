package books.service.impl;

import books.dao.GenericDao;
import books.dao.impl.GenericDaoImpl;
import books.lib.Inject;
import books.lib.Service;
import books.model.Author;
import books.service.AuthorService;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    GenericDao<Author, Long> genericDao = new GenericDaoImpl<>();

    @Override
    public Author create(Author model) {
        return genericDao.setTclass(Author.class).create(model);
    }

    @Override
    public Author getById(Long id) {
        return genericDao.setTclass(Author.class).getById(id);
    }

    @Override
    public Author getByField(String fieldName, Object value) {
        return genericDao.setTclass(Author.class).getByField(fieldName,value);
    }

    @Override
    public List<Author> getAll() {
        return genericDao.setTclass(Author.class).getAll();
    }

    @Override
    public Author update(Author model) {
        return genericDao.setTclass(Author.class).update(model);
    }

    @Override
    public boolean delete(Author model) {
        return genericDao.setTclass(Author.class).delete(model);
    }
}
