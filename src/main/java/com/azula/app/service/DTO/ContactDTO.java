package com.azula.app.service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class ContactDTO {

    @NotNull(message = "El cambpo TELEFONO no puede quedar vacio")
    private long telefono;

    @NotBlank(message = "El campo DIRECCION no puede quedar vacio")
    private String direccion;

}
