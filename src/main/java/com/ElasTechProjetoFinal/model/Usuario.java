package com.ElasTechProjetoFinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Usuario")
public class Usuario {

    @Id
    private long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    @Size(min = 8)
    private String senha;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chamadoId")
    private Chamado chamado;



}
