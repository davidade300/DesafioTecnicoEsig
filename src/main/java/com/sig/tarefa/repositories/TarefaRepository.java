package com.sig.tarefa.repositories;

import com.sig.tarefa.model.Responsavel;
import com.sig.tarefa.model.Tarefa;
import com.sig.tarefa.model.enums.Situacao;

import javax.persistence.EntityManager;
import java.util.List;

public class TarefaRepository extends BaseRepository<Tarefa> {
    public TarefaRepository() {
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

    /**
     * filtra de acordo com 1 ou mais criterios. Acredito que existam outras forma de fazer,
     * mas dado o tempo para fazer o desafio preferi seguir o obvio.
     *
     * @param id          numero da tarefa a ser buscada
     * @param titulo      titulo da tarefa a ser buscada
     * @param responsavel responsavel da tarefa a ser buscada
     * @param situacao    situacao da tarefa a ser buscada
     * @return lista de tarefa de acordo com os criterios
     */
    public List<Tarefa> filtrar(Long id,
                                String titulo,
                                Responsavel responsavel,
                                Situacao situacao) {

        EntityManager em = super.getEmf();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT e FROM Tarefa e WHERE e.excluida = false");
            if (id != null) sb.append(" AND e.id = :id");
            if (titulo != null && !titulo.isEmpty())
                sb.append(" AND (e.titulo LIKE :titulo OR e.descricao LIKE :titulo)");
            if (responsavel != null) sb.append(" AND e.responsavel = :responsavel");
            if (situacao != null) sb.append(" AND e.situacao = :situacao");

            var result = em.createQuery(sb.toString(), Tarefa.class);

            if (id != null) result.setParameter("id", id);
            if (titulo != null && !titulo.isEmpty()) result.setParameter("titulo", "%" + titulo + "%");
            if (responsavel != null) result.setParameter("responsavel", responsavel);
            if (situacao != null) result.setParameter("situacao", situacao);

            return result.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * nao gosto muito do merge, mas por questao de tempo, decidi utilizá-lo.
     *
     * @param tarefa tarefa a ser atualizada
     */
    public void atualizar(Tarefa tarefa) {
        EntityManager em = super.getEmf();
        try {
            em.getTransaction().begin();
            em.merge(tarefa);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
