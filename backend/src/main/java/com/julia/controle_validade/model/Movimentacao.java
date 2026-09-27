package com.julia.controle_validade.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "TB_MOVIMENTACAO")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Date dataHora;

    @Column(length = 255)
    private String observacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FK_ID_LOTE", nullable = false)
    private Lote lote;
}