package org.example.repositorios;

import jakarta.persistence.EntityManager;
import org.example.modelo.Imovel;

import java.util.List;

public class ImovelRepository implements Repository<Imovel> {
    private EntityManager entityManager;

    public ImovelRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Imovel entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Imovel entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Imovel buscarPorId(int id) {
        return entityManager.find(Imovel.class, id);
    }

    @Override
    public List<Imovel> listarTodos() {
        return entityManager.createQuery("FROM Imovel", Imovel.class).getResultList();
    }

    public List<Imovel> listarDisponiveis() {
        return entityManager.createQuery("SELECT i FROM Imovel i WHERE i.disponivel = true", Imovel.class).getResultList();
    }
}

