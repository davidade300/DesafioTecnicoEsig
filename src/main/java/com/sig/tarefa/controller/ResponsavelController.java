package com.sig.tarefa.controller;

import com.sig.tarefa.model.Responsavel;
import com.sig.tarefa.repositories.ResponsavelRepository;
import com.sig.tarefa.services.ResponsavelService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class ResponsavelController {

    private Responsavel responsavel = new Responsavel();
    private final ResponsavelService service = new ResponsavelService(new ResponsavelRepository());

    public void salvar() {
        service.salvar(responsavel);
        responsavel = new Responsavel(); // limpa o formulario
    }

    public List<Responsavel> getResponsaveis() {
        return service.listarTodos();
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
