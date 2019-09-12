package example03.IdClass;

import c.hb.eg.config.BaseDao;

public class TestIdClass {
    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        SchoolStudent schoolStudent = new SchoolStudent("standard-I", "12345", "john@gmail.com", "John Doe");

        //Persist into db
         baseDao.save(schoolStudent);

        PKSchoolStudent pk = new PKSchoolStudent(schoolStudent.getClassName(), schoolStudent.getRollNumber(), schoolStudent.getRegistrationId());

        //To find
        SchoolStudent data = baseDao.find(SchoolStudent.class, pk);
        System.out.println(data);
    }
}