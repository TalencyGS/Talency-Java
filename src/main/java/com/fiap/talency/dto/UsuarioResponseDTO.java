package com.fiap.talency.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String areaInteresse;
    private LocalDate dataCadastro;
}
