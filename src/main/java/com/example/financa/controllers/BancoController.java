package com.example.financa.controllers;

import com.example.financa.domains.Banco;
import com.example.financa.services.BancoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancos")
public class BancoController {

    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @PostMapping
    public ResponseEntity<Banco> criar(@RequestBody Banco banco) {
        return ResponseEntity.ok(bancoService.salvar(banco));
    }

    @GetMapping
    public ResponseEntity<List<Banco>> listar() {
        return ResponseEntity.ok(bancoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bancoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banco> atualizar(@PathVariable Long id, @RequestBody Banco banco) {
        return ResponseEntity.ok(bancoService.atualizar(id, banco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        bancoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
