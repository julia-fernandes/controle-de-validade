package com.julia.controle_validade.dto;

import com.julia.controle_validade.model.TipoMovimentacao;

import java.time.LocalDateTime;

public record MovimentacaoResponseDTO (

        Long id,
        TipoMovimentacao tipo,
        Integer quantidadeMovimentada,
        LocalDateTime dataHora,
        String observacao,

        Long idLote,
        String codigoLote
){}
