package com.ElasTechProjetoFinal.model;

import com.ElasTechProjetoFinal.model.Chamado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private EnumRole role;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Chamado> chamados;
}
