package org.rvramesh.academy.course;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CourseRepository implements PanacheRepositoryBase<CourseEntity, Long> {
    
}
