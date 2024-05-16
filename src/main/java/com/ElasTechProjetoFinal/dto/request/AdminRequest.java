package com.ElasTechProjetoFinal.dto.request;

import com.ElasTechProjetoFinal.model.Chamado;
import com.ElasTechProjetoFinal.model.EnumRole;
import com.ElasTechProjetoFinal.model.Tecnico;
import com.ElasTechProjetoFinal.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class AdminRequest {
    @NotBlank
    @JsonProperty("nome")
    private String nome;

    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotBlank
    @JsonProperty("senha")
    private String senha;

    @NotBlank
    @JsonProperty("role")
    private EnumRole role;

    @JsonProperty("chamado")
    private Set<Chamado> chamado;

    @JsonProperty("usuario")
    private Set<Usuario> usuario;

    @JsonProperty("tecnico")
    private Set<Tecnico> tecnico;
}
