package com.ElasTechProjetoFinal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoResponse {

    private UUID Id;
    private String titulo;
    private String descricao;
    private String setor;
    private String prioridade;
    private String dataInicio;
    private String dataTermino;

}
