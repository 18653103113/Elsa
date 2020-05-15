package com.cvicse.msa.jpa.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "t_company_user")
@Entity
public class CompanyUser {

    //主键采用UUID策略
    //@GenericGenerator是Hibernate提供的主键生成策略注解，注意下面的@GeneratedValue（JPA注解）使用generator = "idGenerator"引用了上面的name = "idGenerator"主键生成策略
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name = "credit_code", unique = true, nullable = false, length = 18)
    private String credit_code;
    @Column(name = "name", nullable = false, length = 300)
    private String name;
    @Column(name = "addr", length = 500)
    private String addr;
    @Column(name = "office_phone", length = 30)
    private String office_phone;
    @Column(name = "legal_person", length = 30)
    private String legal_person;
    @Column(name = "user_account", nullable = false, length = 30)
    private String user_account;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }
}
