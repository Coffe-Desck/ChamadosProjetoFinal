package com.ElasTechProjetoFinal.dto.request;

import com.ElasTechProjetoFinal.model.Chamado;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
public class TecnicoRequest {

    @NotBlank
    @JsonProperty("nome")
    private String nome;

    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotBlank
    @JsonProperty("senha")
    private String senha;

    @JsonProperty("chamados")
    private Set<Chamado> chamado;

}
