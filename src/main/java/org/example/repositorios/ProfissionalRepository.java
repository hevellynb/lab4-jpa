package org.example.repositorios;

import jakarta.persistence.EntityManager;
import org.example.modelo.Profissional;

import java.util.List;

public class ProfissionalRepository implements Repository<Profissional> {
    private EntityManager entityManager;

    public ProfissionalRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Profissional entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Profissional entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Profissional buscarPorId(int id) {
        return entityManager.find(Profissional.class, id);
    }

    @Override
    public List<Profissional> listarTodos() {
        return entityManager.createQuery("FROM Profissional", Profissional.class).getResultList();
    }
}
