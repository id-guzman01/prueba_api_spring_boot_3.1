package com.azula.app.mapper;

import com.azula.app.persistence.entity.Publicaciones;
import com.azula.app.persistence.entity.User;
import com.azula.app.persistence.repository.UserRepository;
import com.azula.app.service.DTO.PublicacionesDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class PublicacionesMapper implements IMapper<PublicacionesDTO, Publicaciones>{

    private final UserRepository userRepository;

    public PublicacionesMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Publicaciones map(PublicacionesDTO in) {
        Publicaciones publicaciones = new Publicaciones();
        publicaciones.setTitulo(in.getTitulo());
        publicaciones.setContenido(in.getContenido());
        publicaciones.setLikes(in.getLikes());

        User user = userRepository.findById(in.getUser_id()).get();

        publicaciones.setUser(user);
        return publicaciones;
    }
}
