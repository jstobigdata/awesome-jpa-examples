package example01;

import c.hb.eg.config.JPAUtil;
import example00.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TestObjectStates {

    private static EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();

    public static void main(String[] args) {

        // New or transient state
        Student student = new Student("test@email.com");

        // Make changes and see if the data is updated automatically
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(student); //student is now persisted state
        //purposely made changes - to automatically sync the changes
        student.setEmail("updated_email@gmail.com");
        Long persistedId = student.getId();
        tx.commit();
        entityManager.close();

        // Test if the email address was updated
        entityManager = entityManagerFactory.createEntityManager();
        tx = entityManager.getTransaction();
        tx.begin();
        student = entityManager.find(Student.class, persistedId);
        tx.commit();
        System.out.println("Persisted SchoolStudent: " + student);
        entityManager.close();

        //To reattach a detached object
        student.setEmail("updated_again@gmail.com");

        entityManager = entityManagerFactory.createEntityManager();
        tx = entityManager.getTransaction();
        tx.begin();
        student = entityManager.merge(student);
        tx.commit();
        entityManager.close();
        System.out.println("Persisted SchoolStudent: " + student);

        //Remove an Object from the database
        entityManager = entityManagerFactory.createEntityManager();
        tx = entityManager.getTransaction();
        tx.begin();
        student = entityManager.find(Student.class, persistedId);
        entityManager.remove(student);
        tx.commit();
        entityManager.close();
    }

}
