package com.br.etec.sp.etec.AdotaLp.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class AdocaoDoacaoFilter {

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataadocao;
    private String nomeanimal;
    private String raca;
    private String nomeadotante;
    private String nomedoador;
    private String nomecidade;
    private String noomeestado;


    public LocalDate getDataadocao() {
        return dataadocao;
    }

    public void setDataadocao(LocalDate dataadocao) {
        this.dataadocao = dataadocao;
    }

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNomeadotante() {
        return nomeadotante;
    }

    public void setNomeadotante(String nomeadotante) {
        this.nomeadotante = nomeadotante;
    }

    public String getNomedoador() {
        return nomedoador;
    }

    public void setNomedoador(String nomedoador) {
        this.nomedoador = nomedoador;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getNoomeestado() {
        return noomeestado;
    }

    public void setNoomeestado(String noomeestado) {
        this.noomeestado = noomeestado;
    }
}
