package com.ElasTechProjetoFinal.dto.response;

import com.ElasTechProjetoFinal.model.EnumSetor;
import com.ElasTechProjetoFinal.model.Prioridade;
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
    private EnumSetor setor;
    private Prioridade prioridade;
    private String dataInicio;
    private String dataTermino;
    private Long usuarioId;
    private Long tecnicoId;

    public ChamadoResponse(UUID id, String titulo, String descricao, EnumSetor setor, Prioridade prioridade, String dataInicio, String dataTermino, Usuario usuario) {
    }
}
