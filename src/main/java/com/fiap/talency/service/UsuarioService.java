package com.fiap.talency.service;

import com.fiap.talency.dto.UsuarioRequestDTO;
import com.fiap.talency.dto.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO criar(UsuarioRequestDTO dto);
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO buscarPorId(Long id);
}
