package org.rvramesh.academy.course;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(hal = true, path = "courses")
public interface CourseResource extends PanacheEntityResource<CourseEntity, Long> {

    
}
