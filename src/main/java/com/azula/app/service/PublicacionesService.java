package com.azula.app.service;

import com.azula.app.mapper.PublicacionesMapper;
import com.azula.app.persistence.entity.Publicaciones;
import com.azula.app.persistence.repository.PublicacionesRespository;
import com.azula.app.service.DTO.PublicacionesDTO;
import com.azula.app.util.ResponseHTTP;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PublicacionesService {
    private final PublicacionesRespository publicacionesRespository;
    private final ResponseHTTP responsehttp;

    private final PublicacionesMapper mapper;

    public PublicacionesService(PublicacionesRespository publicacionesRespository, ResponseHTTP responsehttp, PublicacionesMapper mapper) {
        this.publicacionesRespository = publicacionesRespository;
        this.responsehttp = responsehttp;
        this.mapper = mapper;
    }

    public List<Publicaciones> getAllPublicaciones(){
        return this.publicacionesRespository.findAll();
    }

    public ResponseEntity<String> savePublicacion(PublicacionesDTO publicacionesDTO) throws JsonProcessingException {
        Publicaciones publicaciones = mapper.map(publicacionesDTO);
        Optional<Publicaciones> obj = Optional.of(this.publicacionesRespository.save(publicaciones));
        if(!obj.isEmpty()){
            return new ResponseEntity<>(
                    this.responsehttp.respuesta("Publicación created successfull","200")
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(this.responsehttp.respuesta("Publicación not created","400"), HttpStatus.BAD_REQUEST);
    }

}
