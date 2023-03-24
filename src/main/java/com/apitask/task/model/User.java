package com.apitask.task.model;

import jakarta.persistence.*;
import org.springframework.data.domain.Persistable;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="users")
public class User implements Persistable<String>, Comparable<User> {

    @Id
    @Column(length = 100, updatable = false, nullable = false, insertable = false)
    private String username;

    private String firstname;
    private String surname;
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
        hash = 59 * hash + Objects.hashCode(username);
        return hash;
    }

    @Override
    public String getId() {
        return getUsername();
    }

    @Override
    public boolean isNew() {
        return createDate == null;
    }

    @Override
    public int compareTo(User o) {
        return this.username.compareTo(o.getUsername());
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    //getter setter standard stuff
    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
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
