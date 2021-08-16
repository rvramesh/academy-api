package org.rvramesh.academy.enrollment;

@Entity
public class EnrollmentEntity extends PanacheEntity {
    public LocalDateTime createdDate;
    public LocalDateTime updatedDate;
    public long createdBy;
    public long updatedBy;
    public string course;
    public long user;
    public string courseStepsJson;
    public boolean isVerifiedByMentor;
    public float percentageCompletion;
}
