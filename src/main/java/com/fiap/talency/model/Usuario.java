package com.fiap.talency.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "senha_hash", length = 255)
    private String senhaHash;

    @Column(name = "area_interesse", length = 50)
    private String areaInteresse;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
}