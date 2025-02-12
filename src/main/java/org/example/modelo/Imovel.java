package org.example.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "imoveis")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_proprietario", nullable = false)
    @Setter @Getter private Cliente proprietario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_imovel", nullable = false)
    @Setter @Getter private TipoImovel tipoImovel;

    @Setter @Getter private String logradouro;
    private String bairro;
    private String cep;
    private Integer metragem;
    private Integer dormitorios;
    private Integer banheiros;
    private Integer suites;
    private Integer vagasGaragem;
    private BigDecimal valorAluguelSugerido;
    private String obs;
    @Setter @Getter private Boolean disponivel;

}

