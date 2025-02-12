package org.example.repositorios;

import jakarta.persistence.EntityManager;
import org.example.modelo.Cliente;

import java.util.List;

public class ClienteRepository implements Repository<Cliente> {
    private EntityManager entityManager;

    public ClienteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Cliente entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Cliente entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Cliente buscarPorId(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return entityManager.createQuery("FROM Cliente", Cliente.class).getResultList();
    }

    public boolean cpfExiste(String cpf) {
        Long count = entityManager.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.cpf = :cpf", Long.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
        return count > 0;
    }
}
