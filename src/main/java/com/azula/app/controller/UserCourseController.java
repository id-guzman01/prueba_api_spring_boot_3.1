package com.azula.app.controller;

import com.azula.app.persistence.entity.id_class.UserCourse;
import com.azula.app.service.DTO.UserCourseDTO;
import com.azula.app.service.UserCourseService;
import com.azula.app.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercourse")
public class UserCourseController {

    private final UserCourseService service;

    public UserCourseController(UserCourseService service) {
        this.service = service;
    }
    @GetMapping(produces = "application/json")
    public List<UserCourse> getUserCourses(){
        return this.service.getAllUserscourses();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> saveUserInCourse(@RequestBody @Valid UserCourseDTO userCourseDTO) throws JsonProcessingException {
        return this.service.saveAllUserCourse(userCourseDTO);
    }

}
