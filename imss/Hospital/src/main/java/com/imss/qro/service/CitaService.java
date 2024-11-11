package com.imss.qro.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imss.qro.models.Cita;
import com.imss.qro.repository.CitaRepository;

@Service
public class CitaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CitaService.class);
    
    @Autowired
    private CitaRepository citaRepository;

    // Metodo para Obtener todas las citas
    public List<Cita> obtenerTodasLasCitas() {
        LOGGER.info("Obteniendo todas las citas.");
        return citaRepository.findAll();
    }

    // Metodo para Obtener las citas por ID
    public Optional<Cita> obtenerCitaPorId(Integer id) {
        LOGGER.info("Obteniendo cita con ID: {}", id);
        return citaRepository.findById(id);
    }

    // Método para Crear las citas
    public String registrarCita(Cita cita) {
        LOGGER.info("Registrando una nueva cita para el paciente ID: {}", cita.getPacienteId());
        try {
            Cita nuevaCita = citaRepository.save(cita);
            if (nuevaCita != null) {
                String mensaje = "La cita ID " + nuevaCita.getCitaId() + " fue creada con éxito.";
                LOGGER.info(mensaje);
                return mensaje;
            } else {
                String mensaje = "No se pudo crear la cita.";
                LOGGER.warn(mensaje);
                return mensaje;
            }
        } catch (Exception e) {
            LOGGER.error("Error al registrar la cita: {}", e.getMessage());
            throw new RuntimeException("Error interno al registrar la cita.");
        }
    }

    // Metodo para Actualizar las citas
    public String actualizarCita(Integer id, Cita detallesCita) {
        LOGGER.info("Actualizando cita con ID: {}", id);
        try {
            return citaRepository.findById(id).map(cita -> {
                cita.setPacienteId(detallesCita.getPacienteId());
                cita.setDoctorId(detallesCita.getDoctorId());
                cita.setFechaCita(detallesCita.getFechaCita());
                cita.setNotificado(detallesCita.getNotificado());
                cita.setMotivo(detallesCita.getMotivo());
                cita.setNotas(detallesCita.getNotas());
                cita.setFechaHora(detallesCita.getFechaHora());
                cita.setInsumoId(detallesCita.getInsumoId());
                cita.setCantidadUsada(detallesCita.getCantidadUsada());
                citaRepository.save(cita);
                String mensaje = "Cita con ID " + id + " actualizada con éxito.";
                LOGGER.info(mensaje);
                return mensaje;
            }).orElseGet(() -> {
                String mensaje = "Cita con ID " + id + " no encontrada.";
                LOGGER.warn(mensaje);
                return mensaje;
            });
        } catch (Exception e) {
            LOGGER.error("Error al actualizar la cita: {}", e.getMessage());
            throw new RuntimeException("Error interno al actualizar la cita.");
        }
    }

    // Metodo para Eliminar las citas
    public String eliminarCita(Integer id) {
        LOGGER.info("Intentando eliminar cita con ID: {}", id);
        try {
            Optional<Cita> citaOptional = citaRepository.findById(id);
            if (citaOptional.isPresent()) {
                citaRepository.deleteById(id);
                String mensaje = "La cita con ID " + id + " fue eliminada exitosamente.";
                LOGGER.info(mensaje);
                return mensaje;
            } else {
                String error = "No se encontró ninguna cita con ID " + id;
                LOGGER.error(error);
                throw new IllegalArgumentException(error);
            }
        } catch (Exception e) {
            LOGGER.error("Error al eliminar la cita: {}", e.getMessage());
            throw new RuntimeException("Error interno al eliminar la cita.");
        }
    }
}
