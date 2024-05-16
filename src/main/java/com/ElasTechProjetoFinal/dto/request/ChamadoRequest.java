package com.ElasTechProjetoFinal.dto.request;

import com.ElasTechProjetoFinal.model.EnumSetor;
import com.ElasTechProjetoFinal.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoRequest {

    @NotNull
    @JsonProperty("titulo")
    private String titulo;

    @NotNull
    @JsonProperty("descricao")
    private String descricao;

    @NotNull
    @JsonProperty("setor")
    private EnumSetor setor;

    @NotNull
    @JsonProperty("usuario")
    private Usuario usuario;

    @NotNull
    @JsonProperty("prioridade")
    private String prioridade;

    @NotNull
    @JsonProperty("dataInicio")
    private String dataInicio;

    @NotNull
    @JsonProperty("dataTermino")
    private String dataTermino;
}
