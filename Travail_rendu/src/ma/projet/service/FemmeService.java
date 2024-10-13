package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.beans.Femme;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FemmeService implements IDao<Femme> {
    @Override
    public boolean create(Femme femme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(femme);
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
    public Femme getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Femme) session.get(Femme.class, id);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Femme> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from Femme").list();
        } finally {
            session.close();
        }
    }
}
