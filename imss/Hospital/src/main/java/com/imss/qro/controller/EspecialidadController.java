package com.imss.qro.controller;

import com.imss.qro.models.Especialidad;
import com.imss.qro.service.EspecialidadService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    // Obtener todas las especialidades
    @GetMapping
    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return especialidadService.obtenerTodasLasEspecialidades();
    }

    // Obtener una especialidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerEspecialidadPorId(@PathVariable @NotNull Integer id) {
        Optional<Especialidad> especialidad = especialidadService.obtenerEspecialidadPorId(id);
        return especialidad.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Registrar una nueva especialidad
    @PostMapping
    public ResponseEntity<Especialidad> registrarEspecialidad(@RequestBody @Valid Especialidad especialidad) {
        // El objeto Especialidad será validado antes de entrar en el servicio
        Especialidad nuevaEspecialidad = especialidadService.registrarEspecialidad(especialidad);
        return new ResponseEntity<>(nuevaEspecialidad, HttpStatus.CREATED);
    }

    // Actualizar una especialidad existente
    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(@PathVariable @NotNull Integer id,
                                                               @RequestBody @Valid Especialidad detallesEspecialidad) {
        Especialidad especialidadActualizada = especialidadService.actualizarEspecialidad(id, detallesEspecialidad);
        if (especialidadActualizada != null) {
            return ResponseEntity.ok(especialidadActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una especialidad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEspecialidad(@PathVariable @NotNull Integer id) {
        boolean eliminado = especialidadService.eliminarEspecialidad(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
