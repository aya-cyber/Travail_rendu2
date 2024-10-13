package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.beans.Homme;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HommeService implements IDao<Homme> {
    @Override
    public boolean create(Homme homme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(homme);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Homme getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Homme) session.get(Homme.class, id);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Homme> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from Homme").list();
        } finally {
            session.close();
        }
    }
}
