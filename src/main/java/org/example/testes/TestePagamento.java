package org.example.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.modelo.Aluguel;
import org.example.modelo.Locacao;
import org.example.repositorios.*;
import org.example.servico.PagamentoService;

import java.time.LocalDate;

public class TestePagamento {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab04");
        EntityManager em = emf.createEntityManager();

        AluguelRepository aluguelRepo = new AluguelRepository(em);
        LocacaoRepository locacaoRepo = new LocacaoRepository(em);
        PagamentoService servicoPagamento = new PagamentoService(aluguelRepo);

        Aluguel aluguel = new Aluguel();
        Locacao locacao = locacaoRepo.buscarPorId(1);
        aluguel.setLocacao(locacao);
        aluguel.setDataPagamento(LocalDate.of(2025, 2, 12));
        aluguel.setDataVencimento(LocalDate.of(2025, 2, 12).plusDays(10));

        servicoPagamento.registrarPagamento(aluguel, LocalDate.of(2025, 2, 16));
        System.out.println("Pagamento registrado com sucesso!");

        em.close();
        emf.close();
    }
}
