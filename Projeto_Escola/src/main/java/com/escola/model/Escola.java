package com.escola.model;

import java.util.ArrayList;
import java.util.List;

public class Escola {
    private Integer codigo;
    private String nome;
    private String endereco;
    private Long numeroDeAlunos;
    private String anoFundacao;

    private List<Curso> cursos = new ArrayList<>();

    public Escola(){

    }

    public Escola(Integer codigo, String nome, String endereco, Long numeroDeAlunos, String anoFundacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.numeroDeAlunos = numeroDeAlunos;
        this.anoFundacao = anoFundacao;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getNumeroDeAlunos() {
        return numeroDeAlunos;
    }

    public void setNumeroDeAlunos(Long numeroDeAlunos) {
        this.numeroDeAlunos = numeroDeAlunos;
    }

    public String getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(String anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }    
    
}
