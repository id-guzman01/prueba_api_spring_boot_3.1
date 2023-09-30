package com.azula.app.persistence.repository;

import com.azula.app.persistence.entity.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionesRespository extends JpaRepository<Publicaciones, Integer> {
}
