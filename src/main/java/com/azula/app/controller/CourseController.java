package com.azula.app.controller;

import com.azula.app.persistence.entity.Course;
import com.azula.app.service.CourseService;
import com.azula.app.service.DTO.CourseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = "application/json")
    public List<Course> getCourses(){
        return this.courseService.getAllCourses();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> saveCourses(@RequestBody @Valid CourseDTO courseDTO) throws JsonProcessingException {
        return this.courseService.saveCourse(courseDTO);
    }

}
