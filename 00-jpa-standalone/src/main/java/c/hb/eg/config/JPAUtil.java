package c.hb.eg.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory;

    private JPAUtil(){
        throw new UnsupportedOperationException();
    }

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate-JPA");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                entityManagerFactory.close();
            }
        });
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
