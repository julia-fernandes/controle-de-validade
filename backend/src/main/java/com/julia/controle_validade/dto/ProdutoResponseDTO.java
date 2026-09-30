package com.julia.controle_validade.dto;

import com.julia.controle_validade.model.StatusProduto;

public record ProdutoResponseDTO(

        Long id,
        String codigoBarras,
        String codigoInterno,
        String nomeProduto,
        StatusProduto status,
        CategoriaResponseDTO categoria
) {}