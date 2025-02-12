package org.example.modelo;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "profissionais")
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String profissao;
    private String telefone1;
    private String telefone2;
    private BigDecimal valorHora;
    private String obs;
}

