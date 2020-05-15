package com.cvicse.msa.jpa.test;

import com.cvicse.msa.jpa.JpaApplication;
import com.cvicse.msa.jpa.dao.CompanyUserDao;
import com.cvicse.msa.jpa.entity.CompanyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CompanyUserTest {

    @Autowired
    private CompanyUserDao companyUserDao;

    /**
     * 新增用户
     * @throws Exception
     */
    @Test
    public void testAddUser() throws Exception {
        CompanyUser user = new CompanyUser();
        user.setName("山东中创软件工程股份有限公司");
        user.setCredit_code("123456789123456789");
        user.setAddr("济南历下区千佛山东路");
        user.setLegal_person("李兆亮");
        user.setOffice_phone("0531-81753510");
        user.setUser_account("18653103113");
        companyUserDao.save(user);

        CompanyUser user2 = new CompanyUser();
        user2.setName("山东济南联控股份公司");
        user2.setCredit_code("98765321987654321");
        user2.setAddr("济南历下区千佛山东路");
        user2.setLegal_person("李兆亮");
        user2.setOffice_phone("0531-81753510");
        user2.setUser_account("18653103113");
        companyUserDao.save(user2);
    }

    /**
     * 删除用户(根据对象删除时，必须要有ID属性)
     * @throws Exception
     */
    @Test
    public void testDelUser() throws Exception {
        CompanyUser user = new CompanyUser();
        user.setId("xxxxxxxxxxxxxxx");
        user.setName("山东济南联控股份公司");
        companyUserDao.delete(user);
    }

    /**
     * 修改用户信息
     * @throws Exception
     */
    @Test
    public void testUpdUser() throws Exception {
        CompanyUser user = new CompanyUser();
        user.setId("xxxxxxxxxxxxxxx");
        user.setCredit_code("123123123123123123");
        user.setUser_account("123123123123123123");
        user.setName("山东中创软件");
        companyUserDao.save(user);
    }

    /**
     * 查询用户
     * @throws Exception
     */
    @Test
    public void testQueryUser() throws Exception {
        //CompanyUser user = companyUserDao.findByCredit_code("123456789123456789");
        //System.out.println(user.getName());

        CompanyUser user2 = companyUserDao.findByName("山东中创软件工程股份有限公司");
        System.out.println(user2.getName());

    }

    /**
     * 查询所有用户
     * @throws Exception
     */
    @Test
    public void testQueryUserList() throws Exception {
        List<CompanyUser> list = companyUserDao.findAll();
        for (CompanyUser user : list) {
            System.out.println(user.getName());
        }
    }

}
