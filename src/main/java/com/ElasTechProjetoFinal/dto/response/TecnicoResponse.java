package com.ElasTechProjetoFinal.dto.response;

import com.ElasTechProjetoFinal.model.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoResponse {

    private Long Id;
    private String nome;
    private String email;
    private String senha;
    private EnumRole role;
    private Set<ChamadoResponse> chamados;
}
