package com.example.financa.domains;

import com.example.financa.domains.enums.TipoConta;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    private String agencia;
    private String numero;
    private Double limite;
    private Double saldo;

    // relacionamento com Banco
    @ManyToOne
    @JoinColumn(name = "banco_id", nullable = false)
    private Banco banco;

    public Conta() {}

    public Conta(Long id, String descricao, TipoConta tipoConta, String agencia, String numero, Double limite, Double saldo, Banco banco) {
        this.id = id;
        this.descricao = descricao;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.numero = numero;
        this.limite = limite;
        this.saldo = saldo;
        this.banco = banco;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public TipoConta getTipoConta() { return tipoConta; }
    public void setTipoConta(TipoConta tipoConta) { this.tipoConta = tipoConta; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Double getLimite() { return limite; }
    public void setLimite(Double limite) { this.limite = limite; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }

    public Banco getBanco() { return banco; }
    public void setBanco(Banco banco) { this.banco = banco; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}