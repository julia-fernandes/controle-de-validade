package com.julia.controle_validade.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "TB_PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(unique = true, length = 15)
    private String codigoBarras;

    @Column(unique = true, length = 6)
    private String codigoInterno;

    private String nomeProduto;

    @Enumerated(EnumType.STRING) //salva no banco o texto do enum ao invés da posição numérica
    @Column(nullable = false)
    private StatusProduto status;

    @ManyToOne(optional = false) //produto não pode existir sem uma categoria, precisa do relacionamento
    @JoinColumn(name = "FK_ID_CATEGORIA", nullable = false)
    private Categoria categoria;
}