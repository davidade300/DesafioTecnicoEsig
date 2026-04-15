package com.sig.tarefa.model.enums;


public enum Situacao {
    EM_ANDAMENTO("Em andamento"),
    COMPLETO("Completo");

    public final String rotulo;

    Situacao(String rotulo) {
        this.rotulo = rotulo;
    }
}