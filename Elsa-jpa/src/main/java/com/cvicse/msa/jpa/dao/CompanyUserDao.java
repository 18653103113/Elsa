package com.cvicse.msa.jpa.dao;

import com.cvicse.msa.jpa.entity.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 该Dao成继承了JpaRepository接口，指定了需要操作的实体对象和实体对象的主键类型；
 * 通过查看JpaRepository接口源码可以看到，里面已经封装了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数；
 * spring-data-jpa还提供了一个非常方便的方式，通过实体属性来命名方法，它会根据命名来创建sql查询相关数据，对应更加复杂的语句，还可以用直接写sql来完成。
 */
public interface CompanyUserDao extends JpaRepository<CompanyUser, String> {

    //CompanyUser findByCredit_code(String credit_code);

    CompanyUser findByName(String name);

    //CompanyUser findByUser_account(String user_account);

}
