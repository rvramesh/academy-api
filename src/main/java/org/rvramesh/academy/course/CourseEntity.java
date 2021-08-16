package org.rvramesh.academy.course;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class CourseEntity extends PanacheEntity {
    public String title;
    public String description;
    public String stepsJson;
    public boolean allowNewEnrollments;
    public LocalDateTime updatedDate;
    public long updatedBy;
    public LocalDateTime createdDate;
    public long createdBy;    
}
