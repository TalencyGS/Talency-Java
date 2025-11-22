package com.fiap.talency.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senhaHash;
    private String areaInteresse;
    private LocalDate dataCadastro;
}
