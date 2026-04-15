package com.sig.tarefa.services;

import com.sig.tarefa.model.Responsavel;
import com.sig.tarefa.repositories.ResponsavelRepository;

import java.util.List;

public class ResponsavelService {

    private final ResponsavelRepository repository;

    public ResponsavelService(ResponsavelRepository repository) {
        this.repository = repository;
    }

    public void salvar(Responsavel responsavel) {
        repository.salvar(responsavel);
    }

    public List<Responsavel> listarTodos() {
        return repository.listarTodos();
    }

}
