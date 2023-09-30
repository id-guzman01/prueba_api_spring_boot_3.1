package com.azula.app.controller;

import com.azula.app.persistence.entity.Publicaciones;
import com.azula.app.service.DTO.PublicacionesDTO;
import com.azula.app.service.PublicacionesService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionesController {

    private final PublicacionesService service;

    public PublicacionesController(PublicacionesService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public List<Publicaciones> getUsers(){
        return this.service.getAllPublicaciones();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> addPublicacion(@RequestBody @Valid PublicacionesDTO publicacionesDTO) throws JsonProcessingException {
        return this.service.savePublicacion(publicacionesDTO);
    }

}
