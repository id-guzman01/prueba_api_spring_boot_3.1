package com.azula.app.persistence.entity;

import com.azula.app.persistence.entity.id_class.UserCourse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalIdCache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@NaturalIdCache
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", allocationSize = 1)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    @NotBlank
    private String nombre;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    @NotBlank
    @JsonIgnore
    private String password;

    @Column(name = "edad", nullable = false)
    @NotNull
    private int edad;

    //Relación de uno a uno
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact contact;

    //Relación de uno a muchos
    @OneToMany(mappedBy = "user", cascade = CascadeType. ALL, fetch = FetchType.LAZY)
    private List<Publicaciones> publicaciones; //= new HashSet<>();

    //@ManyToMany
    //@JoinTable(name = "users_courses",
            //joinColumns = @JoinColumn(name = "user_id"),
            //inverseJoinColumns = @JoinColumn(name = "course_id"))
    //private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value="user")
    private List<UserCourse> usercourse = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", edad=" + edad +
                '}';
    }
}
