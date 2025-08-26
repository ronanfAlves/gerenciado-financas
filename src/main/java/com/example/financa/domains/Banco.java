package com.example.financa.domains;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bancos")
public class
Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Long id;

    @Column(nullable = false, length = 100) // campo obrigatório, máx 100 caracteres
    private String razaoSocial;

    public Banco() {
    }

    public Banco(Long id, String razaoSocial) {
        this.id = id;
        this.razaoSocial = razaoSocial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banco banco)) return false;
        return Objects.equals(id, banco.id) && Objects.equals(razaoSocial, banco.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razaoSocial);
    }
}
