package com.azula.app.service;

import com.azula.app.exception.ToDoException;
import com.azula.app.mapper.UserMapper;
import com.azula.app.persistence.entity.User;
import com.azula.app.persistence.repository.UserRepository;
import com.azula.app.service.DTO.UserDTO;
import com.azula.app.util.ResponseHTTP;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private  final ResponseHTTP responseHTTP;

    public UserService(UserRepository repository, UserMapper mapper, ResponseHTTP responseHTTP) {
        this.repository = repository;
        this.mapper = mapper;
        this.responseHTTP = responseHTTP;
    }

    public ResponseEntity<String> addUser(UserDTO userdto) throws JsonProcessingException {
        User userEntity = mapper.map(userdto);
        Optional<User> user = Optional.of(this.repository.save(userEntity));
        if(!user.isEmpty()){
            return new ResponseEntity<>(
                    this.responseHTTP.respuesta("User created successfull","200")
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(this.responseHTTP.respuesta("User not created","400"), HttpStatus.BAD_REQUEST);
    }

    public List<User> getUsers(){
        return this.repository.findAll();
    }

    public Optional<User> getUser(int id){
        return this.repository.findById(id);
    }
    @Transactional
    public void updatePasswordUser(int id, UserDTO userdto){
        Optional<User> optionalUserEntity = this.repository.findById(id);
        if (optionalUserEntity.isEmpty()) {
            throw new ToDoException("Petition not found", HttpStatus.NOT_FOUND);
        }
        this.repository.updatePasswordUser(id,userdto.getPassword());
    }

    public void deleteUser(int id){
        Optional<User> optionalUserEntity = this.repository.findById(id);
        if (optionalUserEntity.isEmpty()) {
            throw new ToDoException("Petition not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}
