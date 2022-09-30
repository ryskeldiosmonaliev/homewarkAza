package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernetUtil {
    private static final SessionFactory session = buildSession();

    private static SessionFactory buildSession() {
        try {
            return new Configuration().configure("hibernate.cfg.xml.tld").buildSessionFactory();
        }catch (Throwable e){
            System.out.println("Session achylgan jok");
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSession(){
        return session;
    }
    public static void shutdown(){
        getSession().close();
    }
}


