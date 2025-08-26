package com.example.financa.controllers;

import com.example.financa.domains.Lancamento;
import com.example.financa.services.LancamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    private final LancamentoService service;

    public LancamentoController(LancamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lancamento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lancamento create(@RequestBody Lancamento lancamento) {
        return service.save(lancamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> update(@PathVariable Long id, @RequestBody Lancamento lancamento) {
        try {
            return ResponseEntity.ok(service.update(id, lancamento));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
