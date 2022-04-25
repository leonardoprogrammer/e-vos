package com.evos.filtro;

public class FiltrosClientes {
    private long id;
    private String nome;
    private String cpf;
    private String dataCadastro;
    private String enviaEmail;

    public FiltrosClientes() {

    }

    public FiltrosClientes(long id, String nome, String cpf, String dataCadastro, String enviaEmail) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.enviaEmail = enviaEmail;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEnviaEmail() {
        return enviaEmail;
    }

    public void setEnviaEmail(String enviaEmail) {
        this.enviaEmail = enviaEmail;
    }
}
