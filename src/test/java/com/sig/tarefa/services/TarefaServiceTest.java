package com.sig.tarefa.services;

import com.sig.tarefa.model.Tarefa;
import com.sig.tarefa.model.enums.Prioridade;
import com.sig.tarefa.repositories.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {


    @Mock
    private TarefaRepository repository;

    @InjectMocks
    private TarefaService service;

    @Test
    void salvarTest() {
        Tarefa t = new Tarefa();
        t.setTitulo("Titulo teste");
        t.setPrioridade(Prioridade.ALTA);

        service.salvar(t);

        verify(repository).salvar(t);

    }

    @Test
    void buscaPorId() {
    }

    @Test
    void listarTodos() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void buscaFiltrada() {
    }

    @Test
    void concluir() {
    }

    @Test
    void alterarPrioridade() {
    }

    @Test
    void excluir() {
    }
}