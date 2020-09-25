package com.example.restfulserviceproject.model;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table (name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    @Size(min = 3 ,message = "min 3 characters are required")
    private String name;

    @Column(name = "Birth_date")
    @Past (message = "date can not be greater than today's date.")
    private Date birth_date;

    public User() {
    }

    public User(String name, Date birth_date) {
        this.name = name;
        this.birth_date = birth_date;
    }

    public User(int id, String name, Date birth_date) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getB_date() {
        return birth_date;
    }

    public void setB_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Birth_date=" + birth_date +
                '}';
    }
}
