package example03.embeddedId.ManyToOne;

import c.hb.eg.config.BaseDao;

public class TestEmbeddedIdWithManyToOne {
    public static void main(String[] args) {
        //Get the baseDao
        BaseDao baseDao = new BaseDao();

        //Persist SubSystem
        SubSystem subSystem = new SubSystem("randomId","linux");
        baseDao.save(subSystem);

        //Persist BaseDao
        PKSystemUser pkSystemUser = new PKSystemUser(subSystem, "admin");
        SystemUser user = new SystemUser(pkSystemUser, "System user for Linux");
        baseDao.save(user);

        System.out.println(user);
    }
}
