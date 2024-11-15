package com.imss.qro.controller;

import com.imss.qro.models.Cita;
import com.imss.qro.service.CitaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> obtenerTodasLasCitas() {
        return citaService.obtenerTodasLasCitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerCitaPorId(@PathVariable Integer id) {
        Optional<Cita> cita = citaService.obtenerCitaPorId(id);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> registrarCita(@Valid @RequestBody Cita cita) {
        String mensaje = citaService.registrarCita(cita);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCita(@Valid @PathVariable Integer id, @RequestBody Cita detallesCita) {
        String mensaje = citaService.actualizarCita(id, detallesCita);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCita(@PathVariable Integer id) {
        try {
            String mensaje = citaService.eliminarCita(id);
            return ResponseEntity.ok(mensaje);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
