package com.evos.filtro;

public class FiltrosCargos {
    private long id;
    private String nome;
    private String ativo;
    private String dataCadastro;

    public FiltrosCargos() {

    }

    public FiltrosCargos(long id, String nome, String ativo, String dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
