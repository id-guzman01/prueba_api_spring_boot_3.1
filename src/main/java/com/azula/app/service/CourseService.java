package com.azula.app.service;

import com.azula.app.mapper.CourseMapper;
import com.azula.app.persistence.entity.Course;
import com.azula.app.persistence.entity.User;
import com.azula.app.persistence.repository.CourseRepository;
import com.azula.app.service.DTO.CourseDTO;
import com.azula.app.util.ResponseHTTP;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    private final ResponseHTTP responseHTTP;

    private final CourseMapper mapper;

    public CourseService(CourseRepository courseRepository, ResponseHTTP responseHTTP, CourseMapper mapper) {
        this.courseRepository = courseRepository;
        this.responseHTTP = responseHTTP;
        this.mapper = mapper;
    }

    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }

    public ResponseEntity<String> saveCourse(CourseDTO courseDTO) throws JsonProcessingException {
        Course course = mapper.map(courseDTO);
        Optional<Course> course1 = Optional.of(this.courseRepository.save(course));
        if(!course1.isEmpty()){
            return new ResponseEntity<>(
                    this.responseHTTP.respuesta("Course created successfull","200")
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(this.responseHTTP.respuesta("Course not created","400"),
                HttpStatus.BAD_REQUEST);
    }


}
