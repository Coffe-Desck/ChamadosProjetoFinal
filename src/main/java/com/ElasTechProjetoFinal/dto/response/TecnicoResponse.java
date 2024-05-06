package com.ElasTechProjetoFinal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoResponse {

    private Long Id;
    private String nome;
    private String email;
    private String senha;

}
