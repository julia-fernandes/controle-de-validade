package com.julia.controle_validade.dto;

import com.julia.controle_validade.model.TipoMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MovimentacaoRequestDTO(

        @NotNull(message = "*Campo obrigatório")
        TipoMovimentacao tipo,

        @NotNull(message = "*Campo obrigatório")
        @Positive(message = "*A quantidade deve ser maior que zero")
        Integer quantidadeMovimentada,

        String observacao,

        @NotBlank(message = "*Campo obrigatório")
        @Size(max = 100, message = "O código deve ter no máximo 100 caracteres")
        String codigoLote
) {}
