package org.example.repositorios;

import jakarta.persistence.EntityManager;
import org.example.modelo.TipoImovel;

import java.util.List;

public class TipoImovelRepository implements Repository<TipoImovel> {
    private EntityManager entityManager;

    public TipoImovelRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(TipoImovel entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(TipoImovel entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public TipoImovel buscarPorId(int id) {
        return entityManager.find(TipoImovel.class, id);
    }

    @Override
    public List<TipoImovel> listarTodos() {
        return entityManager.createQuery("FROM TipoImovel", TipoImovel.class).getResultList();
    }

}
