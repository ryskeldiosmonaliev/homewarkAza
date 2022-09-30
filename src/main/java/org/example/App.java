package org.example;

import Util.HIbernetUtil;
import org.example.entiti.Worker;
import org.hibernate.Session;

import javax.persistence.Query;

/**
 * Ryskeldi
 * Аты Аза жана жашы 20дан чон болгон баардык жумушчуларды алыныз.
 * <p>
 * Аты Аза болгон жумушчулардын жашын 18ге озгортунуз.
 * <p>
 * Аты Аза болгон жумушчуларды очурунуз.
 */
public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//
//        Worker worker1 = new Worker("Samat", "Osmonov", 34);
//        Worker worker2 = new Worker("Aza", "Imanaliev", 40);
//        Worker worker3 = new Worker("Ulan", "Jakypiv", 23);
//        Worker worker4 = new Worker("Aza", "Ormonaov", 19);
//        Worker worker5 = new Worker("Uluk", "Sakylbekov", 21);
//         create(worker1);
//         create(worker2);
//         create(worker3);
//         create(worker4);
//         create(worker5);
        // ByNameAndAGe("Aza",18);
        deleteByName("Aza");
    }

    public static int create(Worker worker) {
        Session session = HIbernetUtil.getSession().openSession();
        session.beginTransaction();
        session.save(worker);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully " + worker);
        return worker.getId();
    }

    public static void ByNameAndAGe(String name, int age) {
        Session session = HIbernetUtil.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE Worker set age=:age WHERE name =:name")
                .setParameter("name", name).setParameter("age", age);
        System.out.println(" UPDATE " + name + " " + age);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByName(String name) {
        Session session = HIbernetUtil.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Worker WHERE name =:name").setParameter("name", name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println(name + " delete");
    }
}