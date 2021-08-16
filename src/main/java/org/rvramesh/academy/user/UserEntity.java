package org.rvramesh.academy.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class UserEntity extends PanacheEntity{
    public string username;
    public string fullName;
    public string bio;
    public string location;
    public LocalDateTime joiningDate;
    public string email;
    public LocalDateTime lastLoginTime;
}
