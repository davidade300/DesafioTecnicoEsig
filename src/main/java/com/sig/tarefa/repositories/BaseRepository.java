package com.sig.tarefa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BaseRepository<T> {

    private final Class<T> classe;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefadb");

    protected BaseRepository(Class<T> classe) {
        this.classe = classe;
    }

    protected EntityManager getEmf() {
        return emf.createEntityManager();
    }

    public void salvar(T entity) {
        EntityManager em = getEmf();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<T> listarTodos() {
        EntityManager em = getEmf();
        try {
            return em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e", classe).getResultList();
        } finally {
            em.close();
        }
    }
}
