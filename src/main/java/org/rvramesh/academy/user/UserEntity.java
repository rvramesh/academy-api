package org.rvramesh.academy.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class UserEntity extends PanacheEntity{
    public String username;
    public String fullName;
    public String bio;
    public String location;
    public LocalDateTime joiningDate;
    public String email;
    public LocalDateTime lastLoginTime;
}
