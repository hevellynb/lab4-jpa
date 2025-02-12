package org.example.servico;

import org.example.modelo.*;
import org.example.repositorios.AluguelRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagamentoService {
    private AluguelRepository aluguelRepository;

    public PagamentoService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public void registrarPagamento(Aluguel aluguel, LocalDate dataPagamento) {
        BigDecimal multa = BigDecimal.ZERO;
        if (dataPagamento.isAfter(aluguel.getDataVencimento())) {
            long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(aluguel.getDataVencimento(), dataPagamento);
            multa = aluguel.getLocacao().getValorAluguel().multiply(BigDecimal.valueOf(0.0033 * diasAtraso));
            multa = multa.min(aluguel.getLocacao().getValorAluguel().multiply(BigDecimal.valueOf(0.2)));
        }
        aluguel.setValorPago(aluguel.getLocacao().getValorAluguel().add(multa));
        aluguel.setDataPagamento(dataPagamento);
        aluguelRepository.atualizar(aluguel);
    }
}
