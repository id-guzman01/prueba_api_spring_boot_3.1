package com.azula.app.mapper;

import com.azula.app.persistence.entity.Course;
import com.azula.app.service.DTO.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper implements IMapper<CourseDTO, Course>{
    @Override
    public Course map(CourseDTO in) {
        Course course = new Course();
        course.setNombre(in.getNombre());
        course.setHoras(in.getHoras());
        course.setModalidad(in.getModalidad());
        return course;
    }
}
