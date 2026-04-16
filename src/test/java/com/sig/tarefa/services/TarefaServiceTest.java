package com.sig.tarefa.services;

import com.sig.tarefa.model.Tarefa;
import com.sig.tarefa.model.enums.Prioridade;
import com.sig.tarefa.model.enums.Situacao;
import com.sig.tarefa.repositories.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        Tarefa t = new Tarefa();
        t.setId(1L);
        when(repository.buscaPorId(1L)).thenReturn(t);

        Tarefa encontrada = service.buscaPorId(1L);

        assertEquals(1L, encontrada.getId());
        verify(repository).buscaPorId(1L);
    }

    @Test
    void listarTodos() {
        List<Tarefa> tarefas = List.of(new Tarefa(), new Tarefa());
        when(repository.listarTodos()).thenReturn(tarefas);

        List<Tarefa> resultado = service.listarTodos();

        assertEquals(2, resultado.size());
        verify(repository).listarTodos();
    }

    @Test
    void atualizar() {
        Tarefa t = new Tarefa();
        t.setTitulo("Titulo atualizado");

        service.atualizar(t);

        verify(repository).atualizar(t);
    }

    @Test
    void buscaFiltrada() {
        List<Tarefa> tarefas = List.of(new Tarefa());
        when(repository.filtrar(null, "Titulo", null, null, null)).thenReturn(tarefas);

        List<Tarefa> resultado = service.buscaFiltrada(null, "Titulo", null, null, null);

        assertEquals(1, resultado.size());
        verify(repository).filtrar(null, "Titulo", null, null, null);
    }

    @Test
    void concluir() {
        Tarefa t = new Tarefa();
        t.setId(1L);
        when(repository.buscaPorId(1L)).thenReturn(t);

        service.concluir(1L);

        assertEquals(Situacao.CONCLUIDA, t.getSituacao());
        verify(repository).atualizar(t);
    }

    @Test
    void alterarPrioridade() {
        Tarefa t = new Tarefa();
        t.setId(1L);
        when(repository.buscaPorId(1L)).thenReturn(t);

        service.alterarPrioridade(1L, Prioridade.BAIXA);

        assertEquals(Prioridade.BAIXA, t.getPrioridade());
        verify(repository).atualizar(t);
    }

    @Test
    void excluir() {
        Tarefa t = new Tarefa();
        t.setId(1L);
        when(repository.buscaPorId(1L)).thenReturn(t);

        service.excluir(1L);

        assertTrue(t.isExcluida());
        verify(repository).atualizar(t);
    }
}