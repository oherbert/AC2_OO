package com.escola.model;

public class Curso {
    private Integer codigo;
    private String nome;
    private Integer duracao;
    private Integer anoCriacao;
    private Integer maxAluno;
    private Escola escola;

    public Curso(){

    }

    public Curso(Integer codigo, String nome, Integer duracao, Integer anoCriacao, Integer maxAluno, Escola escola) {
        this.codigo = codigo;
        this.nome = nome;
        this.duracao = duracao;
        this.anoCriacao = anoCriacao;
        this.maxAluno = maxAluno;
        this.escola = escola;
    }

    public Curso(Integer codigo, String nome, Integer duracao, Integer anoCriacao, Integer maxAluno) {
        this.codigo = codigo;
        this.nome = nome;
        this.duracao = duracao;
        this.anoCriacao = anoCriacao;
        this.maxAluno = maxAluno;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

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

    @Override
    public String toString() {
        return "Curso [anoCriacao=" + anoCriacao + ", codigo=" + codigo + ", duracao=" + duracao + ", escola=" + escola
                + ", maxAluno=" + maxAluno + ", nome=" + nome + "]";
    }
    
}
