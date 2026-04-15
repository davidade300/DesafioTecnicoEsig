package com.sig.tarefa.model;


import javax.persistence.*;


/**
 * Decidi deixar responsavel sem conhecimento de Tarefa, criei essa entidade principalmente para uso
 * no seletor de responsavel na tela de cadatro de tarefa.
 * <img src="src/main/resources/images/Responsavel_select.png" >
 */
@Entity
@Table(name = "responsaveis")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Responsavel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

}
