package com.fiap.talency.service;

import com.fiap.talency.dto.UsuarioRequestDTO;
import com.fiap.talency.dto.UsuarioResponseDTO;
import com.fiap.talency.model.Usuario;
import com.fiap.talency.repository.UsuarioRepository;
import com.fiap.talency.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario entity = new Usuario();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSenhaHash(dto.getSenhaHash());
        entity.setAreaInteresse(dto.getAreaInteresse());
        entity.setDataCadastro(dto.getDataCadastro() != null ? dto.getDataCadastro() : LocalDate.now());

        entity = repository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listar() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario u = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return toResponse(u);
    }

    private UsuarioResponseDTO toResponse(Usuario u) {
        UsuarioResponseDTO r = new UsuarioResponseDTO();
        r.setId(u.getId());
        r.setNome(u.getNome());
        r.setEmail(u.getEmail());
        r.setAreaInteresse(u.getAreaInteresse());
        r.setDataCadastro(u.getDataCadastro());
        return r;
    }
}
