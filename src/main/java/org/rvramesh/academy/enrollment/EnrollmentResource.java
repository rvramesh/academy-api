package org.rvramesh.academy.enrollment;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(hal = true, path = "users")
public interface EnrollmentResource extends PanacheEntityResource<EnrollmentEntity, Long> {

}
