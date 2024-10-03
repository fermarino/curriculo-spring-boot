package com.curriculoapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Educacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instituicao;
    private String curso;
    private String grau;
    private String dataInicio;
    private String dataFim;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
