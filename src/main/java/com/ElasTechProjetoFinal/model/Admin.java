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

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private EnumRole role;

//    @OneToMany(mappedBy = "chamados", cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "chamado_Id")
//    private Set<Chamado> chamados;
//
//    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "clientes_Id")
//    private Set<Usuario> usuarios;
//
//    @OneToMany(mappedBy = "tecnicos", cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "tecnicos_Id")
//    private Set<Tecnico> tecnicos;

}
