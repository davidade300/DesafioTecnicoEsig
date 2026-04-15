package com.sig.tarefa.repositories;

import com.sig.tarefa.model.Responsavel;
import com.sig.tarefa.model.Tarefa;
import com.sig.tarefa.model.enums.Situacao;

import javax.persistence.EntityManager;
import java.util.List;

public class TarefaRepository<T> extends BaseRepository<Tarefa> {
    protected TarefaRepository() {
        super(Tarefa.class);
    }

    /**
     * Encontra uma tarefa de acordo com o "Numero"(id)
     *
     * @param id numero da tarefa a ser procurada
     * @return tarefa com o id == id passado.
     */
    public Tarefa buscaPorId(Long id) {
        EntityManager em = super.getEmf();
        try {
            em.getTransaction().begin();
            Tarefa result = em.find(Tarefa.class, id);
            em.getTransaction().commit();
            return result;
        } finally {
            em.close();
        }
    }

    public List<Tarefa> filtrar(Long id,
                                String titulo,
                                String Descricao,
                                Responsavel responsavel,
                                Situacao situacao) {

        EntityManager em = super.getEmf();
        try {

        } finally {
            em.close();
        }
    }
}
