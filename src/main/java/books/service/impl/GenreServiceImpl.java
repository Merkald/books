package books.service.impl;

import books.dao.GenericDao;
import books.dao.impl.GenericDaoImpl;
import books.lib.Inject;
import books.lib.Service;
import books.model.Genre;
import books.service.GenreService;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Inject
    GenericDao<Genre, Long> genericDao = new GenericDaoImpl<>();

    @Override
    public Genre create(Genre model) {
        return genericDao.setTclass(Genre.class).create(model);
    }

    @Override
    public Genre getById(Long id) {
        return genericDao.setTclass(Genre.class).getById(id);
    }

    @Override
    public Genre getByField(String fieldName, Object value) {
        return genericDao.setTclass(Genre.class).getByField(fieldName,value);
    }

    @Override
    public List<Genre> getAll() {
        return genericDao.setTclass(Genre.class).getAll();
    }

    @Override
    public Genre update(Genre model) {
        return genericDao.setTclass(Genre.class).update(model);
    }

    @Override
    public boolean delete(Genre model) {
        return genericDao.setTclass(Genre.class).delete(model);
    }
}
