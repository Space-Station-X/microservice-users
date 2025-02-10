package com.practice.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Date feReg;

    @JsonProperty("isActive")
    private String stActivo;

}
