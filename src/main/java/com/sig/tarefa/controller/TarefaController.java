package com.sig.tarefa.controller;

import com.sig.tarefa.model.Responsavel;
import com.sig.tarefa.model.Tarefa;
import com.sig.tarefa.model.enums.Prioridade;
import com.sig.tarefa.model.enums.Situacao;
import com.sig.tarefa.repositories.ResponsavelRepository;
import com.sig.tarefa.repositories.TarefaRepository;
import com.sig.tarefa.services.ResponsavelService;
import com.sig.tarefa.services.TarefaService;


import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class TarefaController implements Serializable {

    private Long filtroId;
    private String filtroTitulo;
    private String filtroDesc;
    private Responsavel filtroResponsavel;
    private Situacao filtroSituacao;

    private Tarefa tarefa = new Tarefa();
    private final TarefaService service = new TarefaService(new TarefaRepository());
    private final ResponsavelService responsavelService = new ResponsavelService(new ResponsavelRepository());
    private List<Tarefa> tarefas;

    public TarefaController() {
        this.tarefas = service.buscaFiltrada(null, null, null, null, null);
    }

    public void salvar() {
        service.salvar(tarefa);
        tarefa = new Tarefa();
    }

    public void buscaFiltrada() {
        this.tarefas = service.buscaFiltrada(filtroId, filtroTitulo, filtroDesc, filtroResponsavel, filtroSituacao);
    }

    public void concluir(Tarefa t) {
        service.concluir(t.getId());
        buscaFiltrada();
    }


    public void excluir(Tarefa t) {
        service.excluir(t.getId());
        buscaFiltrada();
    }

    public String gotoEditarTarefa(Tarefa t) {
        this.tarefa = service.buscaPorId(t.getId());
        return "editarTarefa";
    }

    public String editar() {
        service.atualizar(tarefa);
        return "listarTarefas";
    }

    public List<Responsavel> getResponsaveis() {
        return responsavelService.listarTodos();
    }

    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }

    public Long getFiltroId() {
        return filtroId;
    }

    public void setFiltroId(Long filtroId) {
        this.filtroId = filtroId;
    }

    public String getFiltroTitulo() {
        return filtroTitulo;
    }

    public void setFiltroTitulo(String filtroTitulo) {
        this.filtroTitulo = filtroTitulo;
    }

    public String getFiltroDesc() {
        return filtroDesc;
    }

    public void setFiltroDesc(String filtroDesc) {
        this.filtroDesc = filtroDesc;
    }

    public Responsavel getFiltroResponsavel() {
        return filtroResponsavel;
    }

    public void setFiltroResponsavel(Responsavel filtroResponsavel) {
        this.filtroResponsavel = filtroResponsavel;
    }

    public Situacao getFiltroSituacao() {
        return filtroSituacao;
    }

    public void setFiltroSituacao(Situacao filtroSituacao) {
        this.filtroSituacao = filtroSituacao;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }


    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }


}
