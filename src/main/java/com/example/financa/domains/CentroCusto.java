package com.example.financa.domains;

import com.example.financa.domains.enums.StatusCentroCusto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "centros_custo")
public class CentroCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusCentroCusto status;

    public CentroCusto() {}

    public CentroCusto(Long id, String descricao, StatusCentroCusto status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public StatusCentroCusto getStatus() { return status; }
    public void setStatus(StatusCentroCusto status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CentroCusto that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}