package com.azula.app.service.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class UserDTO {

    @NotBlank(message = "El campo NOMBRE no debe estar vacio")
    private String nombre;

    @NotBlank(message = "El campo EMAIL noo debe estar vacio")
    @Email(message = "El formato del campo EMAIL es incorrecto")
    private String email;

    @NotBlank(message = "El campo PASSWORD no debe estar vacio")
    private String password;

    @NotNull(message = "El campo EDAD no debe estar vacio")
    @Min(value = 18, message = "La edad no puede ser menor a 18")
    private int edad;

    @NotNull(message = "El cambpo TELEFONO no puede quedar vacio")
    private long telefono;

    @NotBlank(message = "El campo DIRECCION no puede quedar vacio")
    private String direccion;
}
