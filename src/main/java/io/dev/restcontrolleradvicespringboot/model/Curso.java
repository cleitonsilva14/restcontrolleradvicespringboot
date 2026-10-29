package io.dev.restcontrolleradvicespringboot.model;


import io.dev.restcontrolleradvicespringboot.enums.Categoria;
import io.dev.restcontrolleradvicespringboot.enums.Idioma;
import io.dev.restcontrolleradvicespringboot.enums.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150, unique = true)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 200, unique = true)
    private String descricao;

    @Column(name = "nivel",  nullable = false)
    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "idioma")
    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    @Column(name = "preco",  nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

}
