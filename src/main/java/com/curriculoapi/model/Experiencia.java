package com.curriculoapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cargo;
    private String empresa;
    private String descricao;
    private String dataInicio;
    private String dataFim;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
