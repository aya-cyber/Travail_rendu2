package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.beans.Mariage;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MariageService implements IDao<Mariage> {
    @Override
    public boolean create(Mariage mariage) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(mariage);
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
    public Mariage getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Mariage) session.get(Mariage.class, id);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Mariage> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from Mariage").list();
        } finally {
            session.close();
        }
    }
}
