package c.hb.eg.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * BaseDao
 */
public class BaseDao {

    protected EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();

    public void save(Object obj) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(obj);
            tx.commit();
        } finally {
            entityManager.close();
        }
    }

    public <T> T find(Class<T> entityClass, Object primaryKey){
        T data = null;
        EntityManager entityManager = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            data = (T) entityManager.find(entityClass, primaryKey);
            tx.commit();
        } finally {
            entityManager.close();
        }
        return data;
    }
}
