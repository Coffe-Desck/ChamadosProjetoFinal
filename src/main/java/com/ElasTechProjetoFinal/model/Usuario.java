package com.ElasTechProjetoFinal.model;

import com.ElasTechProjetoFinal.model.Chamado;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    @Size(min = 8)
    private String senha;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chamadoId")
    private Set<Chamado> chamados;

}
