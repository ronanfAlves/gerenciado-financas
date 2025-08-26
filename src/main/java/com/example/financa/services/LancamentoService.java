package com.example.financa.services;

import com.example.financa.domains.Lancamento;
import com.example.financa.repositories.LancamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    private final LancamentoRepository repository;

    public LancamentoService(LancamentoRepository repository) {
        this.repository = repository;
    }

    public List<Lancamento> findAll() {
        return repository.findAll();
    }

    public Optional<Lancamento> findById(Long id) {
        return repository.findById(id);
    }

    public Lancamento save(Lancamento lancamento) {
        return repository.save(lancamento);
    }

    public Lancamento update(Long id, Lancamento lancamento) {
        return repository.findById(id).map(existing -> {
            existing.setDescricao(lancamento.getDescricao());
            existing.setValor(lancamento.getValor());
            existing.setTipo(lancamento.getTipo());
            existing.setDataLancamento(lancamento.getDataLancamento());
            existing.setPessoa(lancamento.getPessoa());
            existing.setCentroCusto(lancamento.getCentroCusto());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Lançamento não encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
