package org.rvramesh.academy.enrollment;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class EnrollmentEntity extends PanacheEntity {
    public LocalDateTime createdDate;
    public LocalDateTime updatedDate;
    public long createdBy;
    public long updatedBy;
    public String course;
    public long user;
    public String courseStepsJson;
    public boolean isVerifiedByMentor;
    public float percentageCompletion;
}
