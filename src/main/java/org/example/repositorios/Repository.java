package org.example.repositorios;

import java.util.List;

public interface Repository<T> {
    void salvar(T entity);
    void atualizar(T entity);
    T buscarPorId(int id);
    List<T> listarTodos();
}