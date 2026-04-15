package com.sig.tarefa.model.enums;


public enum Situacao {
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA("Concluida");

    public final String rotulo;

    Situacao(String rotulo) {
        this.rotulo = rotulo;
    }
}