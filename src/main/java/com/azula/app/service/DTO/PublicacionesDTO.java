package com.azula.app.service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class PublicacionesDTO {

    @NotBlank(message = "El campo TITULO no puede estar vacio")
    private String titulo;

    @NotBlank(message = "El campo CONTENIDO no puede estar vacio")
    private String contenido;

    @NotNull(message = "El campo LIKES no puede estar vacio")
    private int likes;

    @NotNull(message = "El campo USER_ID no puede estar vacio")
    private int user_id;

}
