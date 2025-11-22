package com.fiap.talency.service;

import com.fiap.talency.dto.PythonRequestDTO;
import com.fiap.talency.dto.PythonResponseDTO;
import com.fiap.talency.dto.SolicitacaoIADTO;
import com.fiap.talency.model.AuditoriaIA;
import com.fiap.talency.model.Usuario;
import com.fiap.talency.repository.AuditoriaIARepository;
import com.fiap.talency.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class IAService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuditoriaIARepository auditoriaRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String URL_PYTHON_IOT = "http://localhost:8000/chat";

    public String solicitarAjudaIA(SolicitacaoIADTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado no Oracle"));

        String promptParaPython = criarPrompt(dto.getTipoSolicitacao(), usuario);

        PythonRequestDTO requestPayload = new PythonRequestDTO(promptParaPython);

        PythonResponseDTO respostaPython = restTemplate.postForObject(
                URL_PYTHON_IOT,
                requestPayload,
                PythonResponseDTO.class
        );

        String textoResposta = (respostaPython != null) ? respostaPython.getResposta() : "Erro ao gerar resposta da IA.";

        AuditoriaIA auditoria = new AuditoriaIA();
        auditoria.setUsuario(usuario);
        auditoria.setTipoSolicitacao(dto.getTipoSolicitacao());
        auditoria.setRespostaGerada(textoResposta);
        auditoria.setDataConsulta(LocalDateTime.now());

        auditoriaRepository.save(auditoria);

        return textoResposta;
    }

    private String criarPrompt(String tipo, Usuario user) {
        switch (tipo.toUpperCase()) {
            case "MOTIVACAO":
                return "TIPO: MOTIVACAO para o aluno " + user.getNome() +
                        " que tem interesse na área de " + user.getAreaInteresse();

            case "SUGESTAO_ESTUDO":
                return "TIPO: SUGESTAO_ESTUDO para um profissional de " + user.getAreaInteresse();

            case "RESUMO_CONTEUDO":
                return "TIPO: RESUMO_CONTEUDO sobre as tendências de " + user.getAreaInteresse();

            default:
                return "TIPO: MOTIVACAO genérica";
        }
    }
}