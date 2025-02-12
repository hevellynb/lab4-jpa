package org.example.repositorios;

import jakarta.persistence.EntityManager;
import org.example.modelo.Aluguel;

import java.util.List;

public class AluguelRepository implements Repository<Aluguel> {
    private EntityManager entityManager;

    public AluguelRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Aluguel entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Aluguel entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Aluguel buscarPorId(int id) {
        return entityManager.find(Aluguel.class, id);
    }

    @Override
    public List<Aluguel> listarTodos() {
        return entityManager.createQuery("FROM Aluguel", Aluguel.class).getResultList();
    }
}
