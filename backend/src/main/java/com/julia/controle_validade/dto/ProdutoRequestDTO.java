package com.julia.controle_validade.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;

public record ProdutoRequestDTO(

        @Size(max = 15, message = "*Código de no máximo 15 caracteres")
        String codigoBarras,

        @Size(max = 6, message = "*Código de no máximo 6 caracteres")
        String codigoInterno
) {

    @AssertTrue(message = "*Informe o código do produto")
    public boolean isCodigoValido(){

        //verifica se os campos não estão vazios nem nulos
        boolean cdBarras = (codigoBarras != null) && (!codigoBarras.isBlank());
        boolean cdInterno = (codigoInterno != null) && (!codigoInterno.isBlank());

        return cdBarras || cdInterno;
        //retorna o que for true, se caso ambos forem false o assertTrue retorna a mensagem
    }
}
