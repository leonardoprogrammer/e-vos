package com.evos.model.vo;

public class EmpresaVO {
    private long id;
    private String nome;
    private String cnpj;
    private boolean possuiCnpj;
    private boolean ativa;

    public EmpresaVO() {

    }

    public EmpresaVO(long id, String nome, String cnpj, boolean possuiCnpj, boolean ativa) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.possuiCnpj = possuiCnpj;
        this.ativa = ativa;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isPossuiCnpj() {
        return possuiCnpj;
    }

    public void setPossuiCnpj(boolean possuiCnpj) {
        this.possuiCnpj = possuiCnpj;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
