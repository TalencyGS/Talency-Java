package com.fiap.talency.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_TALENCY_AUDITORIA_IA")
public class AuditoriaIA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditoria")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "tipo_solicitacao")
    private String tipoSolicitacao;

    @Lob
    @Column(name = "resposta_gerada", columnDefinition = "CLOB")
    private String respostaGerada;

    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public String getRespostaGerada() {
        return respostaGerada;
    }

    public void setRespostaGerada(String respostaGerada) {
        this.respostaGerada = respostaGerada;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}

