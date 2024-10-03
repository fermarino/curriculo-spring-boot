package com.curriculoapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
