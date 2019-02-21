package com.rest.webservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class user {
    @Id
    @GeneratedValue
	private Integer id;
    @Size(min=2,message = "name should have at_least 2 chars")
    private String name;
    @Past
    private Date date;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    //For using POST we have to make a default constructor
    protected user() {
    }

    public user(Integer id, String name, Date date) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "user [id=" + id + ", name=" + name + ", date=" + date + "]";
    }


}
