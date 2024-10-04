package com.curriculoapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Educacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;
    private String instituicao;
    private String periodo;

    @ManyToOne
    @JoinColumn(name = "curriculo_id", nullable = false)
    private Curriculo curriculo;
}
