package books.dao.impl;

import books.dao.GenericDao;
import books.lib.Dao;
import books.lib.Inject;
import books.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Dao
public class GenericDaoImpl<T, V> implements GenericDao<T, V> {
    @Inject
    private Class<T> tClass;

    @Override
    public GenericDaoImpl<T, V> settClass(Class<T> tClass) {
        this.tClass = tClass;
        return this;
    }

    @Override
    public T create(T model) {
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
            throw new RuntimeException("Cant insert movie entity", e);
        } finally {
            session.close();
        }
    }

    @Override
    public T getById(V id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cr = cb.createQuery(tClass);
        Root<T> root = cr.from(tClass);
        cr.select(root).where(cb.equal(root.get("id"), id));
        Query<T> query = session.createQuery(cr);
        List<T> results = query.getResultList();
        return results.stream().findFirst().orElseThrow();
    }

    @Override
    public T getByField(String fieldName, Object value) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cr = cb.createQuery(tClass);
        Root<T> root = cr.from(tClass);
        cr.select(root).where(cb.equal(root.get(fieldName), value));
        Query<T> query = session.createQuery(cr);
        List<T> results = query.getResultList();
        return results.stream().findFirst().orElseThrow();
    }

    @Override
    public List<T> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cr = cb.createQuery(tClass);
        Root<T> root = cr.from(tClass);
        cr.select(root);
        Query<T> query = session.createQuery(cr);
        List<T> results = query.getResultList();
        return results;
    }

    @Override
    public T update(T model) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(model);
            transaction.commit();
            return model;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant insert movie entity", e);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteById(T model) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(model);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant delete model entity", e);
        } finally {
            session.close();
        }
    }
}
