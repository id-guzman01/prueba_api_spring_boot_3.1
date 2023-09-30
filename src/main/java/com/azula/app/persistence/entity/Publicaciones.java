package com.azula.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "publicaciones")
public class Publicaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publicaciones_generator")
    @SequenceGenerator(name = "publicaciones_generator", allocationSize = 1)
    private int id;

    @Column(name = "titulo", nullable = false, length = 100)
    @NotBlank
    private String titulo;

    @Column(name = "contenido", nullable = false, length = 255)
    @NotBlank
    private String contenido;

    @Column(name = "likes", nullable = true)
    private int likes;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_user_publicaciones_id"))
    @JsonBackReference
    private User user;


    @Override
    public String toString() {
        return "Publicaciones{" +
                "id=" + id +
                ", titulo=" + titulo +
                ", contenido='" + contenido + '\'' +
                ", likes='" + likes + '\'' +
                '}';
    }
}
