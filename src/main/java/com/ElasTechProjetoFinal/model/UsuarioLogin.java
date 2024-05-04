package com.ElasTechProjetoFinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioLogin {

    private Long id;
    private String nome;
    private String email;
    private String senha;
}
