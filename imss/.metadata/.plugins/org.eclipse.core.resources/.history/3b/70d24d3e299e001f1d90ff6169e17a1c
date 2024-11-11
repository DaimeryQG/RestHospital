package com.imss.qro.service;

import com.imss.qro.models.Recordatorio;
import com.imss.qro.repository.RecordatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class RecordatorioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordatorioService.class);

    @Autowired
    private RecordatorioRepository recordatorioRepository;

    // Obtener todos los recordatorios
    public List<Recordatorio> obtenerTodosLosRecordatorios() {
        LOGGER.info("Obteniendo todos los recordatorios.");
        return recordatorioRepository.findAll();
    }

    // Obtener un recordatorio por ID
    public Optional<Recordatorio> obtenerRecordatorioPorId(Integer id) {
        LOGGER.info("Obteniendo recordatorio con ID: {}", id);
        return recordatorioRepository.findById(id);
    }

    // Actualizar un recordatorio
    public String actualizarRecordatorio(Integer id, Recordatorio detallesRecordatorio) {
        LOGGER.info("Actualizando recordatorio con ID: {}", id);
        return recordatorioRepository.findById(id).map(recordatorio -> {
            recordatorio.setCitaId(detallesRecordatorio.getCitaId());
            recordatorio.setFechaRecordatorio(detallesRecordatorio.getFechaRecordatorio());
            recordatorio.setMensaje(detallesRecordatorio.getMensaje());
            recordatorioRepository.save(recordatorio);
            String mensaje = "Recordatorio con ID " + id + " actualizado con éxito.";
            LOGGER.info(mensaje);
            return mensaje;
        }).orElse("Recordatorio con ID " + id + " no encontrado.");
    }

    // Eliminar un recordatorio
    public String eliminarRecordatorio(Integer id) {
        LOGGER.info("Intentando eliminar recordatorio con ID: {}", id);
        Optional<Recordatorio> recordatorioOptional = recordatorioRepository.findById(id);
        if (recordatorioOptional.isPresent()) {
            recordatorioRepository.deleteById(id);
            String mensaje = "El recordatorio con ID " + id + " fue eliminado exitosamente.";
            LOGGER.info(mensaje);
            return mensaje;
        } else {
            String error = "No se encontró ningún recordatorio con ID " + id;
            LOGGER.error(error);
            throw new IllegalArgumentException(error);
        }
    }
}
