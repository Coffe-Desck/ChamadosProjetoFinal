package com.ElasTechProjetoFinal.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



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

    @Column(name= "data_inicio")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String dataInicio;

    @Column(name= "data_termino")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String dataTermino;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @ManyToOne
    @JoinColumn(name = "prioridade_id")
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}
