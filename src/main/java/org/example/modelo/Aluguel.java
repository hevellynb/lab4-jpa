package org.example.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "aluguéis")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_locacao", nullable = false)
    @Setter @Getter private Locacao locacao;

    @Setter @Getter private LocalDate dataVencimento;
    @Setter @Getter private BigDecimal valorPago;
    @Setter @Getter private LocalDate dataPagamento;
}
