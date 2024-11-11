package com.imss.qro.service;

import com.imss.qro.models.Insumos;
import com.imss.qro.repository.InsumosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsumoService.class);

    @Autowired
    private final InsumosRepository insumosRepository;

    public InsumoService(InsumosRepository insumosRepository) {
        this.insumosRepository = insumosRepository;
    }

    // Método para obtener todos los insumos
    public List<Insumos> obtenerTodosLosInsumos() {
        LOGGER.info("Obteniendo todos los insumos.");
        return insumosRepository.findAll();
    }

    // Método para obtener un insumo por su ID
    public Optional<Insumos> obtenerInsumoPorId(Integer id) {
        LOGGER.info("Buscando insumo con ID: {}", id);
        return insumosRepository.findById(id);
    }

    // Método para registrar un nuevo insumo
    public String registrarInsumo(Insumos insumo) {
        LOGGER.info("Registrando insumo: {}", insumo.getNombre());
        insumo.setFecha_registro(LocalDateTime.now());  // Asignamos la fecha de registro automáticamente
        insumosRepository.save(insumo);
        LOGGER.info("Insumo registrado con éxito: {}", insumo.getNombre());
        return "Insumo registrado con éxito";
    }

    // Método para actualizar un insumo existente
    public String actualizarInsumo(Integer id, Insumos insumoDetalles) {
        LOGGER.info("Actualizando insumo con ID: {}", id);
        return insumosRepository.findById(id).map(insumoExistente -> {
            insumoExistente.setNombre(insumoDetalles.getNombre());
            insumoExistente.setCantidad(insumoDetalles.getCantidad());
            insumoExistente.setCategoria(insumoDetalles.getCategoria());
            insumoExistente.setFecha_caducidad(insumoDetalles.getFecha_caducidad());
            insumoExistente.setProveedor(insumoDetalles.getProveedor());
            insumoExistente.setUbicacion(insumoDetalles.getUbicacion());
            insumoExistente.setFecha_registro(LocalDateTime.now());  // Actualiza la fecha de registro
            insumosRepository.save(insumoExistente);
            LOGGER.info("Insumo actualizado con éxito: {}", insumoExistente.getNombre());
            return "Insumo actualizado con éxito";
        }).orElseGet(() -> {
            LOGGER.error("Insumo no encontrado con ID: {}", id);
            return "Insumo no encontrado";
        });
    }

    // Método para eliminar un insumo por su ID
    public String eliminarInsumo(Integer id) {
        LOGGER.info("Eliminando insumo con ID: {}", id);
        if (insumosRepository.existsById(id)) {
            insumosRepository.deleteById(id);
            LOGGER.info("Insumo eliminado con éxito con ID: {}", id);
            return "Insumo eliminado con éxito";
        } else {
            LOGGER.error("Insumo no encontrado con ID: {}", id);
            throw new IllegalArgumentException("Insumo no encontrado");
        }
    }
}
