package com.ElasTechProjetoFinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioLogin {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private EnumRole role;
    private String token;

}
