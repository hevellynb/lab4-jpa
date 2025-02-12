package org.example.repositorios;

import jakarta.persistence.EntityManager;
import org.example.modelo.ServicoImovel;

import java.util.List;

public class ServicoImovelRepository implements Repository<ServicoImovel> {
    private EntityManager entityManager;

    public ServicoImovelRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(ServicoImovel entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(ServicoImovel entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public ServicoImovel buscarPorId(int id) {
        return entityManager.find(ServicoImovel.class, id);
    }

    @Override
    public List<ServicoImovel> listarTodos() {
        return entityManager.createQuery("FROM ServicoImovel", ServicoImovel.class).getResultList();
    }
}
