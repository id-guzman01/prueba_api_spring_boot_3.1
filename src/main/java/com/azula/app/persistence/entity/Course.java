package com.azula.app.persistence.entity;

import com.azula.app.persistence.entity.id_class.UserCourse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalIdCache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@NaturalIdCache
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_generator")
    @SequenceGenerator(name = "course_generator", allocationSize = 1)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    @NotBlank
    private String nombre;

    @Column(name = "horas", nullable = false, length = 10)
    @NotNull
    private int horas;

    @Column(name = "modalidad", nullable = false, length = 50)
    @NotBlank
    private String modalidad;

    //@ManyToMany(mappedBy = "courses")
    //private Set<UserEntity> users = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value="course")
    private List<UserCourse> usercourse = new ArrayList<>();

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", horas='" + horas + '\'' +
                ", modalidad='" + modalidad + '\'' +
                '}';
    }

}
