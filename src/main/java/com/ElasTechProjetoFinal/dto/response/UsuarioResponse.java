package com.ElasTechProjetoFinal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
    private Long Id;
    private String nome;
    private String email;
    private String senha;
    private Set<ChamadoResponse> chamados;
}
