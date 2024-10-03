package com.curriculoapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Educacao> educacoes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Habilidade> habilidades;
}
