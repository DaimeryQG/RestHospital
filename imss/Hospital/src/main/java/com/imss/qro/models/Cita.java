package com.imss.qro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cita_id")
	private Integer citaId;
	
	@NotNull(message = "El ID del paciente es obligatorio")
	@Column(name = "paciente_id", nullable = false)
	private Integer pacienteId;

	@NotNull(message = "El ID del doctor es obligatorio")
	@Column(name = "doctor_id", nullable = false)
	private Integer doctorId;

	@NotNull(message = "La fecha de la cita es obligatoria")
	@FutureOrPresent(message = "La fecha de la cita debe ser en el presente o en el futuro")
	@Column(name = "fecha_cita", nullable = false)
	private LocalDateTime fechaCita;

	@Column(name = "notificado")
	private Boolean notificado;

	@Size(max = 255, message = "El motivo no debe exceder los 255 caracteres")
	@Column(name = "motivo", length = 255)
	private String motivo;

	@Size(max = 500, message = "Las notas no deben exceder los 500 caracteres")
	@Column(name = "notas", length = 500)
	private String notas;

	@PastOrPresent(message = "La fecha y hora debe ser en el pasado o presente")
	@Column(name = "fecha_hora")
	private LocalDateTime fechaHora;

	@Min(value = 1, message = "El ID del insumo debe ser mayor o igual a 1")
	@Column(name = "insumo_id")
	private Integer insumoId;

	@Min(value = 0, message = "La cantidad usada debe ser mayor o igual a 0")
	@Column(name = "cantidad_usada")
	private Integer cantidadUsada;

    // Getters y Setters
    
	public Integer getCitaId() {
		return citaId;
	}

	public void setCitaId(Integer citaId) {
		this.citaId = citaId;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Boolean getNotificado() {
		return notificado;
	}

	public void setNotificado(Boolean notificado) {
		this.notificado = notificado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Integer getInsumoId() {
		return insumoId;
	}

	public void setInsumoId(Integer insumoId) {
		this.insumoId = insumoId;
	}

	public Integer getCantidadUsada() {
		return cantidadUsada;
	}

	public void setCantidadUsada(Integer cantidadUsada) {
		this.cantidadUsada = cantidadUsada;
	}
}

