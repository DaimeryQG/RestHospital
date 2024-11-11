package com.imss.qro.controller;

import com.imss.qro.models.Insumos;
import com.imss.qro.service.InsumoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insumos")
public class InsumoController {

    private final InsumoService insumoService;

    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    // Endpoint para obtener todos los insumos
    @GetMapping
    public List<Insumos> obtenerTodosLosInsumos() {
        return insumoService.obtenerTodosLosInsumos();
    }

    // Endpoint para obtener un insumo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Insumos> obtenerInsumoPorId(@PathVariable Integer id) {
        Optional<Insumos> insumo = insumoService.obtenerInsumoPorId(id);
        return insumo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo insumo
    @PostMapping
    public ResponseEntity<Void> registrarInsumo(@Valid @RequestBody Insumos insumo) {
        insumoService.registrarInsumo(insumo);
        return ResponseEntity.status(201).build(); // Creación exitosa sin mensaje
    }

    // Endpoint para actualizar un insumo existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarInsumo(@PathVariable Integer id, @Valid @RequestBody Insumos insumoDetalles) {
        if (insumoService.actualizarInsumo(id, insumoDetalles) != null) {
            return ResponseEntity.ok().build(); // Actualización exitosa
        } else {
            return ResponseEntity.notFound().build(); // Insumo no encontrado
        }
    }

    // Endpoint para eliminar un insumo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInsumo(@PathVariable Integer id) {
        try {
            insumoService.eliminarInsumo(id);
            return ResponseEntity.noContent().build(); // Eliminación exitosa
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Insumo no encontrado
        }
    }
}

