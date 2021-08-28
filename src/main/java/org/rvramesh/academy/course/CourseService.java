package org.rvramesh.academy.course;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ApplicationScoped
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    CourseService(final CourseRepository courseRepository, final CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public Optional<CourseOutputDto> findById(final Long courseId) {
        return courseRepository.findByIdOptional(courseId).map(courseMapper::convertToDto);
    }

    @Transactional
    public CourseOutputDto insert(@Valid final CourseInputDto course) {
        CourseEntity entity = new CourseEntity();

        courseMapper.convertToEntity(course, entity);
        entity.createdDate = LocalDateTime.now(ZoneOffset.UTC);
        entity.updatedDate = LocalDateTime.now(ZoneOffset.UTC);
        //TODO: Replace with real user id
        entity.createdBy = entity.updatedBy = 0;
        courseRepository.persist(entity);
        return courseMapper.convertToDto(entity);
    }

    public CourseOutputDto update(final Long courseId, @Valid final CourseInputDto course) {
        Optional<CourseEntity> optional = courseRepository.findByIdOptional(courseId);
        if (optional.isEmpty()) {
            throw new CourseServiceException(String.format("No Course found for courseId[%s]", courseId));
        }
        CourseEntity entity = optional.get();
        courseMapper.convertToEntity(course, entity);
        entity.updatedDate = LocalDateTime.now(ZoneOffset.UTC);
        // TODO: Replace with real user id
        entity.updatedBy = 0;
        courseRepository.persist(entity);
        return courseMapper.convertToDto(entity);
    }

    public List<CourseOutputDto> findAll() {
        return courseRepository.findAll().stream().map(courseMapper::convertToDto).collect(Collectors.toList());
    }

}
