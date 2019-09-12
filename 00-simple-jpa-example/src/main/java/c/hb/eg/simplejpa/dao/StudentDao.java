package c.hb.eg.simplejpa.dao;

import c.hb.eg.config.BaseDao;
import c.hb.eg.simplejpa.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentDao extends BaseDao {

    public Long save(Student student){
        EntityManager entityManager = null;
        Long id = null;
        try{
            entityManager = this.entityManagerFactory.createEntityManager();
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(student);
            id = student.getId();
            tx.commit();
        } finally {
            entityManager.close();
        }
        return id;
    }
}
