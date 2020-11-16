package com.escola.dto;

public class CursoDTO {

    private String nome;
    private Integer duracao;
    private Integer anoCriacao;
    private Integer maxAluno;

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


}
