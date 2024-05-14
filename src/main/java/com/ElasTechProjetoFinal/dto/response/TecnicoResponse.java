package com.ElasTechProjetoFinal.dto.response;

import com.ElasTechProjetoFinal.model.Chamado;
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
    private Set<ChamadoResponse> chamados;
}
