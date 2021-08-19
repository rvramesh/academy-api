package org.rvramesh.academy.course;

import javax.validation.constraints.NotEmpty;

public class CourseInputDto {
    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String stepsJson;

    @NotEmpty
    private boolean allowNewEnrollments;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getStepsJson() {
        return stepsJson;
    }

    public void setStepsJson(final String stepsJson) {
        this.stepsJson = stepsJson;
    }

    public boolean isAllowNewEnrollments() {
        return allowNewEnrollments;
    }

    public void setAllowNewEnrollments(final boolean allowNewEnrollments) {
        this.allowNewEnrollments = allowNewEnrollments;
    }
}
