package com.azula.app.service.DTO;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class CourseDTO {

    @NotBlank(message = "El campo NOMBRE no puede estar vacio")
    private String nombre;

    @NotNull(message = "El campo HORAS no puede estar vacio")
    private int horas;

    @NotBlank(message = "El campo MODALIDAD no puede estar vacio")
    private String modalidad;

}
