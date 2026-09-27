package com.julia.controle_validade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "TB_LOTE")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLote;

    @Column(nullable = false, length = 100)
    private String codigoLote;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDate dataFabricacao;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @ManyToOne(optional = false) //um lote não existe sem produtos
    @JoinColumn(name = "FK_ID_PRODUTO", nullable = false)
    private Produto produto;
}