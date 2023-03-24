package com.apitask.task.model;

import jakarta.persistence.*;
import org.springframework.data.domain.Persistable;

import java.util.Date;
import java.util.Objects;

@Entity
public class User implements Persistable<String>, Comparable<User> {

    @Id
    @Column(length = 100, updatable = false, nullable = false, insertable = false)
    private String userName;

    private String firstName;
    private String surName;
    private Integer age;
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(userName);
        return hash;
    }

    @Override
    public String getId() {
        return getUserName();
    }

    @Override
    public boolean isNew() {
        return createDate == null;
    }

    @Override
    public int compareTo(User o) {
        return this.userName.compareTo(o.getUserName());
    }





    //getter setter standard stuff
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
