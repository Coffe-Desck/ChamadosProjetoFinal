package com.ElasTechProjetoFinal.dto.response;

import com.ElasTechProjetoFinal.model.EnumRole;

import java.util.Set;

public class AdminResponse {
    private Long Id;
    private String nome;
    private String email;
    private String senha;
    private EnumRole role;
    private Set<ChamadoResponse> chamados;
    private Set<UsuarioResponse> usuarios;
    private Set<TecnicoResponse> tecnicos;
}
