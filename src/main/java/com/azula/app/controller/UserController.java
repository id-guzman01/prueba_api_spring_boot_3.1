package com.azula.app.controller;

import com.azula.app.persistence.entity.User;
import com.azula.app.service.DTO.UserDTO;
import com.azula.app.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO userdto) throws JsonProcessingException {
        return this.service.addUser(userdto);
        //return new ResponseEntity<>("User created", HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public List<User> getAllUsers(){
        return this.service.getUsers();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Optional<User> getOneUser(@PathVariable("id") int id) {
        return this.service.getUser(id);
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Void> updatePassword(@PathVariable("id") int id, @RequestBody UserDTO userdto){
        this.service.updatePasswordUser(id,userdto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id){
        this.service.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
