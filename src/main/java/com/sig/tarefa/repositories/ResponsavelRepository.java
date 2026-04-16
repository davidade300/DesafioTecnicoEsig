package com.sig.tarefa.repositories;

import com.sig.tarefa.model.Responsavel;

import javax.persistence.EntityManager;

public class ResponsavelRepository extends BaseRepository<Responsavel> {

    public ResponsavelRepository() {
        super(Responsavel.class);
    }

    public Responsavel buscaPorId(Long id) {
        if (id == null) return null;
        EntityManager em = super.getEmf();
        try {
            return em.find(Responsavel.class, id);
        } finally {
            em.close();
        }
    }
}
