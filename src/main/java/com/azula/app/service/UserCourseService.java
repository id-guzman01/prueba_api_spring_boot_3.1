package com.azula.app.service;

import com.azula.app.mapper.UserCourseMapper;
import com.azula.app.persistence.entity.User;
import com.azula.app.persistence.entity.id_class.UserCourse;
import com.azula.app.persistence.repository.UserCourseRepository;
import com.azula.app.service.DTO.UserCourseDTO;
import com.azula.app.util.ResponseHTTP;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCourseService {

    private final UserCourseRepository repository;

    private final UserCourseMapper mapper;

    private final ResponseHTTP responseHTTP;

    public UserCourseService(UserCourseRepository repository, UserCourseMapper mapper, ResponseHTTP responseHTTP) {
        this.repository = repository;
        this.mapper = mapper;
        this.responseHTTP = responseHTTP;
    }

    public List<UserCourse> getAllUserscourses(){
        return this.repository.findAll();
    }

    public ResponseEntity<String> saveAllUserCourse(UserCourseDTO usercourseDTO) throws JsonProcessingException {
        UserCourse userCourse = mapper.map(usercourseDTO);
        Optional<UserCourse> usercourse = Optional.of(this.repository.save(userCourse));
        if(!usercourse.isEmpty()){
            return new ResponseEntity<>(
                    this.responseHTTP.respuesta("Usuario registrado en el curso","200")
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(this.responseHTTP.respuesta("Usuario no registrado en el curso","400"), HttpStatus.BAD_REQUEST);

    }

}
