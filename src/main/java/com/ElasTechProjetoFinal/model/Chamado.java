package com.ElasTechProjetoFinal.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false )
    private String titulo;

    @Column(length = 500, nullable = false )
    private String descricao;

    @Column(length = 255, nullable = false )
    private String setor;

    @Column(length = 100, nullable = false )
    private String prioridade;

    @Column(name= "data_inicio")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String dataInicio;

    @Column(name= "data_termino")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String dataTermino;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tecnicos_id")
    private List<Tecnico> tecnicos;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientes_id")
    private List<Usuario> clientes;


}
