package com.imss.qro.service;

import com.imss.qro.models.Especialidad;
import com.imss.qro.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    private static final Logger logger = LoggerFactory.getLogger(EspecialidadService.class);

    @Autowired
    private EspecialidadRepository especialidadRepository;

    // Obtener todas las especialidades
    public List<Especialidad> obtenerTodasLasEspecialidades() {
        logger.info("Obteniendo todas las especialidades");
        List<Especialidad> especialidades = especialidadRepository.findAll();
        logger.info("Se encontraron {} especialidades", especialidades.size());
        return especialidades;
    }

    // Obtener una especialidad por ID
    public Optional<Especialidad> obtenerEspecialidadPorId(Integer id) {
        logger.info("Obteniendo especialidad con ID {}", id);
        Optional<Especialidad> especialidad = especialidadRepository.findById(id);
        if (especialidad.isPresent()) {
            logger.info("Especialidad encontrada: {}", especialidad.get().getNombre());
        } else {
            logger.warn("No se encontró la especialidad con ID {}", id);
        }
        return especialidad;
    }

    // Registrar una nueva especialidad
    public Especialidad registrarEspecialidad(Especialidad especialidad) {
        logger.info("Registrando nueva especialidad: {}", especialidad.getNombre());
        Especialidad nuevaEspecialidad = especialidadRepository.save(especialidad);
        if (nuevaEspecialidad != null) {
            logger.info("Especialidad registrada con éxito con ID {}", nuevaEspecialidad.getEspecialidadId());
        } else {
            logger.error("Error al registrar la especialidad");
        }
        return nuevaEspecialidad;
    }

    // Actualizar una especialidad existente
    public Especialidad actualizarEspecialidad(Integer id, Especialidad detallesEspecialidad) {
        logger.info("Actualizando especialidad con ID {}", id);
        return especialidadRepository.findById(id)
                .map(especialidad -> {
                    especialidad.setNombre(detallesEspecialidad.getNombre());
                    Especialidad actualizada = especialidadRepository.save(especialidad);
                    logger.info("Especialidad con ID {} actualizada exitosamente", id);
                    return actualizada;
                }).orElseGet(() -> {
                    logger.warn("No se encontró la especialidad con ID {}", id);
                    return null;
                });
    }

    // Eliminar una especialidad
    public boolean eliminarEspecialidad(Integer id) {
        logger.info("Intentando eliminar especialidad con ID {}", id);
        if (especialidadRepository.existsById(id)) {
            especialidadRepository.deleteById(id);
            logger.info("Especialidad con ID {} eliminada exitosamente", id);
            return true;
        } else {
            logger.warn("No se encontró la especialidad con ID {}", id);
            return false;
        }
    }
}

