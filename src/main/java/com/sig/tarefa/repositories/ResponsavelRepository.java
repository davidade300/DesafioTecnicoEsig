package com.sig.tarefa.repositories;

import com.sig.tarefa.model.Responsavel;

public class ResponsavelRepository<T> extends BaseRepository<Responsavel> {

    protected ResponsavelRepository() {
        super(Responsavel.class);
    }
}
