package com.julia.controle_validade.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record LoteRequestDTO(

        @NotBlank(message = "*Campo obrigatório")
        @Size(max = 100, message = "O código deve ter no máximo 100 caracteres")
        String codigoLote,

        @NotNull(message = "*Campo obrigatório")
        @Positive(message = "*A quantidade deve ser maior que zero")
        Integer quantidade,

        @NotNull(message = "*Campo obrigatório")
        LocalDate dataFabricacao,

        @NotNull(message = "*Campo obrigatório")
        LocalDate dataValidade,

        //identificação do produto
        String codigoBarras,
        String codigoInterno
) {
    @AssertTrue(message = "*Informe o código do produto")
    public boolean isCodigoValido(){

        boolean cdBarras = (codigoBarras != null) && (!codigoBarras.isBlank());
        boolean cdInterno = (codigoInterno != null) && (!codigoInterno.isBlank());

        return cdBarras || cdInterno;
    }

    @AssertTrue(message = "*A data de validade deve ser posterior à fabricação")
    public boolean isDataValidadeValida() {

        //retorna true se os campos estiverem vazios porque a mensagem NotNull é outra
        if (dataFabricacao == null || dataValidade == null) {
            return true;
        }
        return dataValidade.isAfter(dataFabricacao);
        //se a data de validade não for posterior a de fabricação retorna false = mensagem assertTrue
    }
}
