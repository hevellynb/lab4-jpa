package org.example.repositorios;

import jakarta.persistence.EntityManager;
import org.example.modelo.Locacao;

import java.util.List;

public class LocacaoRepository implements Repository<Locacao> {
    private EntityManager entityManager;

    public LocacaoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Locacao entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Locacao entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Locacao buscarPorId(int id) {
        return entityManager.find(Locacao.class, id);
    }

    @Override
    public List<Locacao> listarTodos() {
        return entityManager.createQuery("FROM Locacao", Locacao.class).getResultList();
    }
}

