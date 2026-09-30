package com.julia.controle_validade.dto;

import java.time.LocalDate;

public record LoteResponseDTO(

        Long id,
        String codigoLote,
        Integer quantidade,
        LocalDate dataFabricacao,
        LocalDate dataValidade,

        //informações do produto
        Long idProduto,
        String codigoBarras,
        String nomeProduto
) {}
