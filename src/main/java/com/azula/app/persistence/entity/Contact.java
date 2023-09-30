package com.azula.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_generator")
    @SequenceGenerator(name = "contact_generator", allocationSize = 1)
    private int id;

    @Column(name = "telefono", nullable = false, length = 14)
    @NotNull
    private long telefono;

    @Column(name = "direccion", nullable = false, length = 50)
    @NotBlank
    private String direccion;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_user_contact_id"))
    private User user;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
