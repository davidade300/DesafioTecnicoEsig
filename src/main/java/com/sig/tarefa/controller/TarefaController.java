package com.sig.tarefa.controller;

import com.sig.tarefa.model.Tarefa;
import com.sig.tarefa.model.enums.Situacao;
import com.sig.tarefa.repositories.TarefaRepository;
import com.sig.tarefa.services.TarefaService;


import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class TarefaController implements Serializable {




    private Tarefa tarefa = new Tarefa();
    private final TarefaService service = new TarefaService(new TarefaRepository());
    private List<Tarefa> tarefas;

    public void salvar() {
        service.salvar(tarefa);
        tarefa = new Tarefa();
    }

    public void concluir(Tarefa t) {
        service.concluir(t.getId());
    }

    public void buscaFiltrada() {
        this.tarefas = service.buscaFiltrada(filtroId, filtroTitulo, filtroDescricao, filtroResponsavel, filtroSituacao);
    }


}
