package org.rvramesh.academy.course;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseOutputDto convertToDto(CourseEntity entity);

    void convertToEntity(CourseInputDto inputDto, @MappingTarget CourseEntity entity);
}
