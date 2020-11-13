package com.escola.dto;

import com.escola.model.Escola;

public class CursoDTO {

    private String nome;
    private Integer duracao;
    private Integer anoCriacao;
    private Integer maxAluno;
    private Escola escola;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(Integer anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public Integer getMaxAluno() {
        return maxAluno;
    }

    public void setMaxAluno(Integer maxAluno) {
        this.maxAluno = maxAluno;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

}
