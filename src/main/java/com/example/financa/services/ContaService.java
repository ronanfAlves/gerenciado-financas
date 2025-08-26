package com.example.financa.services;

import com.example.financa.domains.Conta;
import com.example.financa.repositories.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> listar() {
        return contaRepository.findAll();
    }

    public Conta buscarPorId(Long id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public Conta atualizar(Long id, Conta contaAtualizada) {
        Conta conta = buscarPorId(id);
        conta.setDescricao(contaAtualizada.getDescricao());
        conta.setTipoConta(contaAtualizada.getTipoConta());
        conta.setAgencia(contaAtualizada.getAgencia());
        conta.setNumero(contaAtualizada.getNumero());
        conta.setLimite(contaAtualizada.getLimite());
        conta.setSaldo(contaAtualizada.getSaldo());
        conta.setBanco(contaAtualizada.getBanco());
        return contaRepository.save(conta);
    }

    public void deletar(Long id) {
        contaRepository.deleteById(id);
    }
}
