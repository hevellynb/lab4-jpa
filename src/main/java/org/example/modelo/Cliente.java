package org.example.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @Setter @Getter private String cpf;

    @Setter @Getter private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

}

