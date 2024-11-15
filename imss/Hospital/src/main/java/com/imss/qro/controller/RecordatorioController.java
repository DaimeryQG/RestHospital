package com.imss.qro.controller;

import com.imss.qro.models.Recordatorio;
import com.imss.qro.service.RecordatorioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recordatorios")
public class RecordatorioController {

    @Autowired
    private RecordatorioService recordatorioService;

    @GetMapping
    public List<Recordatorio> obtenerTodosLosRecordatorios() {
        return recordatorioService.obtenerTodosLosRecordatorios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recordatorio> obtenerRecordatorioPorId(@PathVariable Integer id) {
        Optional<Recordatorio> recordatorio = recordatorioService.obtenerRecordatorioPorId(id);
        return recordatorio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarRecordatorio(@PathVariable Integer id, @Valid @RequestBody Recordatorio detallesRecordatorio) {
        String mensaje = recordatorioService.actualizarRecordatorio(id, detallesRecordatorio);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRecordatorio(@PathVariable Integer id) {
        try {
            String mensaje = recordatorioService.eliminarRecordatorio(id);
            return ResponseEntity.ok(mensaje);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
