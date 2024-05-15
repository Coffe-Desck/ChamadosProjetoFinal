package com.ElasTechProjetoFinal.dto.response;

import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.model.Usuario;
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
    private Setor setor;
    private Prioridade prioridade;
    private String dataInicio;
    private String dataTermino;
    private Usuario usuario;

}
