package example03.embeddedId;

import c.hb.eg.config.BaseDao;

public class TestEmbeddedId {
    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        PKStudent pkStudent = new PKStudent("standard-I", "12345");
        MyStudent myStudent = new MyStudent(pkStudent, "john@gmail.com", "John Doe");

        //Persist into db
        baseDao.save(myStudent);

        //Make sure the data is persisted
        MyStudent data = baseDao.find(MyStudent.class, pkStudent);
        System.out.println(data);
    }
}
