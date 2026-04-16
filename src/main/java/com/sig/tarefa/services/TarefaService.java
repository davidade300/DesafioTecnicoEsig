package com.sig.tarefa.services;

import com.sig.tarefa.model.Responsavel;
import com.sig.tarefa.model.Tarefa;
import com.sig.tarefa.model.enums.Prioridade;
import com.sig.tarefa.model.enums.Situacao;
import com.sig.tarefa.repositories.TarefaRepository;

import java.util.List;

public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public void salvar(Tarefa t) {
        repository.salvar(t);
    }

    public Tarefa buscaPorId(Long id) {
        return repository.buscaPorId(id);

    }

    public List<Tarefa> listarTodos() {
        return repository.listarTodos();
    }

    public void atualizar(Tarefa t) {
        repository.atualizar(t);
    }

    public List<Tarefa> buscaFiltrada(Long id,
                                      String titulo,
                                      Responsavel responsavel,
                                      Situacao situacao) {

        return repository.filtrar(id,
                titulo,
                responsavel,
                situacao);
    }

    public void concluir(Long id) {
        Tarefa t = repository.buscaPorId(id);
        t.setSituacao(Situacao.CONCLUIDA);
        repository.atualizar(t);
    }

    public void alterarPrioridade(Long id, Prioridade prioridade) {
        Tarefa t = repository.buscaPorId(id);
        t.setPrioridade(prioridade);
        repository.atualizar(t);
    }

    public void excluir(Long id) {
        Tarefa t = repository.buscaPorId(id);
        t.setExcluida(true);
        repository.atualizar(t);
    }


}
