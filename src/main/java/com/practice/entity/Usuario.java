package com.practice.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("userId")
    private Integer idUsuario;

    @JsonProperty("username")
    private String deAlias;

    @JsonProperty("password")
    private String deClave;

    @JsonProperty("email")
    private String deCorreo;

    @JsonProperty("fullName")
    private String deNombresApellidos;

    @JsonProperty("phone")
    private String deTelefono;

    @JsonProperty("registrationDate") 
    private LocalDate feReg;

    @JsonProperty("isActive")
    private String stActivo;

}
