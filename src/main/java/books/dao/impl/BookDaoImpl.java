package books.dao.impl;

import books.dao.BookDao;
import books.model.Book;
import books.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public Book create(Book model) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();
            return model;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant insert User entity", e);
        } finally {
            session.close();
        }
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book update(Book model) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
