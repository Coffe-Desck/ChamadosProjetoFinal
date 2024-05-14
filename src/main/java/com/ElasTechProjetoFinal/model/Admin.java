package com.ElasTechProjetoFinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Admin")
@Entity
public class Admin {
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientes_Id")
    private Set<Usuario> usuarios;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tecnicos_Id")
    private Set<Tecnico> tecnicos;

}
