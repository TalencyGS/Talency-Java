package com.fiap.talency.controller;

import com.fiap.talency.dto.SolicitacaoIADTO;
import com.fiap.talency.service.IAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ia")
public class IAController {

    @Autowired
    private IAService iaService;

    @PostMapping("/solicitar")
    public ResponseEntity<String> conversarComIA(@RequestBody SolicitacaoIADTO dto) {
        try {
            String resposta = iaService.solicitarAjudaIA(dto);
            return ResponseEntity.ok(resposta);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao processar IA: " + e.getMessage());
        }
    }
}