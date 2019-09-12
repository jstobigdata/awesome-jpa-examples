package example00;

import c.hb.eg.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class StudentDao {

    private EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();

    public Long save(Student student) {
        EntityManager entityManager = null;
        Long id = null;
        try {
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

    public Student find(Long id){
        EntityManager entityManager = null;
        Student student = null;
        try{
            entityManager = this.entityManagerFactory.createEntityManager();
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            student = entityManager.find(Student.class, id);
            tx.commit();

        }finally {
            entityManager.close();
        }
        return student;
    }

    /* Test Object Creation */
    public static void main(String[] args) {
        try {
            Student student = new Student("email@dot.com");
            StudentDao studentDao = new StudentDao();
            Long id = studentDao.save(student);
            System.out.println("SchoolStudent created with id: " + id);

            student = studentDao.find(id);
            System.out.println("\n\n" + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
