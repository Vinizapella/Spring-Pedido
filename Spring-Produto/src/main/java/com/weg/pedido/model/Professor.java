package com.weg.pedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String especialidade;

    @OneToMany(mappedBy = "professor")
    private List<Curso> cursos;


    public Professor(String nome, String email, String especialidade) {
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
    }
}
