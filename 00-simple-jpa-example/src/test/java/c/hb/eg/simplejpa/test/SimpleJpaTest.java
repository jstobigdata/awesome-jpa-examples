package c.hb.eg.simplejpa.test;

import c.hb.eg.config.BaseDao;
import c.hb.eg.simplejpa.dao.StudentDao;
import c.hb.eg.simplejpa.entity.Student;
import org.junit.Test;

public class SimpleJpaTest {

    @Test
    public void testStudent(){

        try{
            Student student = new Student("email@dot.com");
            BaseDao studentDao = new StudentDao();
            studentDao.save(student);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
