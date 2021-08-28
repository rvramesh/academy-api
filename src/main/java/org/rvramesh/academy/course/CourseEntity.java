package org.rvramesh.academy.course;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Course")
@Table(name = "t_courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title")
    @NotEmpty
    public String title;

    @Column(name = "description")
    @NotEmpty
    public String description;

    @Column(name = "steps_json")
    @NotEmpty
    public String stepsJson;

    @Column(name = "allow_enrollments")
    @NotEmpty
    public boolean allowNewEnrollments;

    @Column(name = "updated_date")
    @NotEmpty
    public LocalDateTime updatedDate;

    @Column(name = "updated_by")
    @NotEmpty
    public long updatedBy;

    @Column(name = "created_date")
    @NotEmpty
    public LocalDateTime createdDate;

    @Column(name = "created_by")
    @NotEmpty
    public long createdBy;    
}
