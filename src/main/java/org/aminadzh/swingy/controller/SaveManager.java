package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.characters.Hero;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

public class SaveManager {

    private SessionFactory sessionFactory;

    public SaveManager() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Failed to load game saves file");
            e.printStackTrace();
        }
    }

    ArrayList<Hero> loadSaves() {
        ArrayList<Hero> heroes = new ArrayList<Hero>();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List queryResult = session.createQuery("from Hero").list();
        if (queryResult.size() > 0) {
            System.out.println("There are " + queryResult.size() + " saves found"); // TODO: this is debug only
            heroes.addAll((List<Hero>) queryResult);
        } else {
            System.out.println("No heroes alavuable in save");
        }

        return heroes;
    }

    void save(final Hero hero) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Session session = sessionFactory.openSession();
                Transaction transaction = null;
                try {
                    transaction = session.beginTransaction();
                    session.saveOrUpdate(hero);
                    transaction.commit();
                } catch (HibernateException e) {
                    if (transaction != null) transaction.rollback();
                    e.printStackTrace();
                }
                session.close();
            }
        });

        thread.start();
    }

}
