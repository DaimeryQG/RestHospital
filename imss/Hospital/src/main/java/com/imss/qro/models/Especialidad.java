package com.imss.qro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "especialidades")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especialidad_id")
    private Integer especialidadId;

    @NotNull(message = "El nombre de la especialidad no puede ser nulo")
    @NotBlank(message = "El nombre de la especialidad no puede estar en blanco")
    @Size(max = 100, message = "El nombre de la especialidad no puede exceder los 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Getters y Setters

    public Integer getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(Integer especialidadId) {
        this.especialidadId = especialidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
