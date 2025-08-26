package com.example.financa.services;

import com.example.financa.domains.CentroCusto;
import com.example.financa.repositories.CentroCustoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroCustoService {

    private final CentroCustoRepository repository;

    public CentroCustoService(CentroCustoRepository repository) {
        this.repository = repository;
    }

    public List<CentroCusto> listarTodos() {
        return repository.findAll();
    }

    public CentroCusto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centro de Custo não encontrado"));
    }

    public CentroCusto salvar(CentroCusto centroCusto) {
        return repository.save(centroCusto);
    }

    public CentroCusto atualizar(Long id, CentroCusto centroCustoAtualizado) {
        CentroCusto existente = buscarPorId(id);
        existente.setDescricao(centroCustoAtualizado.getDescricao());
        existente.setStatus(centroCustoAtualizado.getStatus());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}