package com.sig.tarefa.repositories;

import com.sig.tarefa.model.Responsavel;

import javax.persistence.EntityManager;

public class ResponsavelRepository extends BaseRepository<Responsavel> {

    public ResponsavelRepository() {
        super(Responsavel.class);
    }

    public Responsavel buscaPorId(Long id) {
        EntityManager em = super.getEmf();
        try {
            em.getTransaction().begin();
            Responsavel result = em.find(Responsavel.class, id);
            em.getTransaction().commit();
            return result;
        } finally {
            em.close();
        }
    }
}
