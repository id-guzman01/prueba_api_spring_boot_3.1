package com.azula.app.service.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class UserCourseDTO {

    @NotNull(message = "El campo USER_ID no puede estar vacio")
    private int user_id;

    @NotNull(message = "El campo COURSE_ID no puede estar vacio")
    private int course_id;

    @NotNull(message = "El campo RATING no puede estar vacio")
    private int rating;

}
