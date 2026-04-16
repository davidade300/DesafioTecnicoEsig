package com.sig.tarefa.services;

import com.sig.tarefa.model.Responsavel;
import com.sig.tarefa.repositories.ResponsavelRepository;
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
class ResponsavelServiceTest {

    @Mock
    private ResponsavelRepository repository;

    @InjectMocks
    private ResponsavelService service;

    @Test
    void salvar() {
        Responsavel r = new Responsavel();
        r.setNome("teste");

        service.salvar(r);

        verify(repository).salvar(r);
    }

    @Test
    void listarTodos() {
        List<Responsavel> responsaveis = List.of(new Responsavel(), new Responsavel());
        when(repository.listarTodos()).thenReturn(responsaveis);

        List<Responsavel> resultado = service.listarTodos();

        assertEquals(2, resultado.size());
        verify(repository).listarTodos();
    }

    @Test
    void buscaPorId() {
        Responsavel r = new Responsavel();
        when(repository.buscaPorId(1L)).thenReturn(r);

        Responsavel result = service.buscaPorId(1L);

        verify(repository).buscaPorId(1L);
    }
}