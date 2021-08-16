package org.rvramesh.academy.user;

@ResourceProperties(hal = true, path = "users")
public interface UserResource extends PanacheEntityResource<UserEntity, Long>{
    
}
