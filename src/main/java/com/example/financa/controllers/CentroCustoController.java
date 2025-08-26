package com.example.financa.controllers;

import com.example.financa.domains.CentroCusto;
import com.example.financa.services.CentroCustoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centros-custo")
public class CentroCustoController {

    private final CentroCustoService service;

    public CentroCustoController(CentroCustoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CentroCusto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CentroCusto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CentroCusto criar(@RequestBody CentroCusto centroCusto) {
        return service.salvar(centroCusto);
    }

    @PutMapping("/{id}")
    public CentroCusto atualizar(@PathVariable Long id, @RequestBody CentroCusto centroCusto) {
        return service.atualizar(id, centroCusto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}