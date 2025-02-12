package org.example.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_imovel", nullable = false)
    @Setter @Getter private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "id_inquilino", nullable = false)
    @Setter @Getter private Cliente inquilino;

    @Setter @Getter private BigDecimal valorAluguel;
    private BigDecimal percentualMulta;
    private Integer diaVencimento;
    @Setter @Getter private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean ativo;
}

