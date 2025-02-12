package org.example.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.modelo.*;
import org.example.repositorios.*;
import org.example.servico.LocacaoService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteLocacao {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab04");
        EntityManager em = emf.createEntityManager();

        ClienteRepository clienteRepo = new ClienteRepository(em);
        ImovelRepository imovelRepo = new ImovelRepository(em);
        LocacaoRepository locacaoRepo = new LocacaoRepository(em);
        TipoImovelRepository tipoImovelRepo = new TipoImovelRepository(em);

        LocacaoService servicoLocacao = new LocacaoService(locacaoRepo, imovelRepo);

        Cliente cliente = new Cliente();
        cliente.setNome("João Silva");
        cliente.setCpf("12345678900");
        if (clienteRepo.cpfExiste(cliente.getCpf())) {
            System.err.println("Erro: Cliente com esse CPF já existe.");
        } else {
            clienteRepo.salvar(cliente);
        }

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Gabriel Castro");
        cliente2.setCpf("98765432100");
        if (clienteRepo.cpfExiste(cliente2.getCpf())) {
            System.err.println("Erro: Cliente com esse CPF já existe.");
        } else {
            clienteRepo.salvar(cliente2);
        }

        TipoImovel casa = new TipoImovel();
        casa.setDescricao("Casa");
        tipoImovelRepo.salvar(casa);


        Imovel imovel = new Imovel();
        imovel.setProprietario(cliente);
        imovel.setTipoImovel(casa);
        imovel.setLogradouro("Rua A, 123");
        imovel.setDisponivel(true);
        imovelRepo.salvar(imovel);

        Locacao locacao = new Locacao();
        locacao.setImovel(imovel);
        locacao.setInquilino(cliente2);
        locacao.setDataInicio(LocalDate.now());
        locacao.setValorAluguel(new BigDecimal("1500.00"));

        servicoLocacao.registrarLocacao(locacao);

        System.out.println("Locação registrada com sucesso!");


        em.close();
        emf.close();
    }
}
