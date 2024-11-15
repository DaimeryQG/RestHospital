package com.imss.qro.models;

import jakarta.persistence.*; 
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "recordatorios")
public class Recordatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordatorio_id")
    private Integer recordatorioId;

    @NotNull(message = "El ID de la cita es obligatorio.")
    @Column(name = "cita_id", nullable = false)
    private Integer citaId;

    @NotNull(message = "La fecha de recordatorio es obligatoria.")
    @FutureOrPresent(message = "La fecha de recordatorio debe ser en el presente o en el futuro.")
    @Column(name = "fecha_recordatorio", nullable = false)
    private LocalDateTime fechaRecordatorio;

    @Size(max = 500, message = "El mensaje no puede exceder 500 caracteres.")
    @Column(name = "mensaje", columnDefinition = "text")
    private String mensaje;

    // Getters y Setters

    public Integer getRecordatorioId() {
        return recordatorioId;
    }

    public void setRecordatorioId(Integer recordatorioId) {
        this.recordatorioId = recordatorioId;
    }

    public Integer getCitaId() {
        return citaId;
    }

    public void setCitaId(Integer citaId) {
        this.citaId = citaId;
    }

    public LocalDateTime getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setFechaRecordatorio(LocalDateTime fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
