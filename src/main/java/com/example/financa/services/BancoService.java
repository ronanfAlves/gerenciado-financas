package com.example.financa.services;

import com.example.financa.domains.Banco;
import com.example.financa.repositories.BancoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    private final BancoRepository bancoRepository;

    public BancoService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public Banco salvar(Banco banco) {
        return bancoRepository.save(banco);
    }

    public List<Banco> listar() {
        return bancoRepository.findAll();
    }

    public Banco buscarPorId(Long id) {
        return bancoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banco não encontrado"));
    }

    public Banco atualizar(Long id, Banco bancoAtualizado) {
        Banco banco = buscarPorId(id);
        banco.setRazaoSocial(bancoAtualizado.getRazaoSocial());
        return bancoRepository.save(banco);
    }

    public void deletar(Long id) {
        bancoRepository.deleteById(id);
    }
}
