package com.evos.model.entity;

/**
 * @author leonardo.silva
 */
public class Empresa {
    private long id;
    private String nome;
    private String cnpj;
    private String possuiCnpj;
    private String ativa;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public Empresa() {

    }

    public Empresa(long id, String nome, String cnpj, String possuiCnpj, String ativa, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.possuiCnpj = possuiCnpj;
        this.ativa = ativa;
        this.dtaInc = dtaInc;
        this.loginInc = loginInc;
        this.dtaAlt = dtaAlt;
        this.loginAlt = loginAlt;
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

    public String getPossuiCnpj() {
        return possuiCnpj;
    }

    public void setPossuiCnpj(String possuiCnpj) {
        this.possuiCnpj = possuiCnpj;
    }

    public String getAtiva() {
        return ativa;
    }

    public void setAtiva(String ativa) {
        this.ativa = ativa;
    }

    public String getDtaInc() {
        return dtaInc;
    }

    public void setDtaInc(String dtaInc) {
        this.dtaInc = dtaInc;
    }

    public String getLoginInc() {
        return loginInc;
    }

    public void setLoginInc(String loginInc) {
        this.loginInc = loginInc;
    }

    public String getDtaAlt() {
        return dtaAlt;
    }

    public void setDtaAlt(String dtaAlt) {
        this.dtaAlt = dtaAlt;
    }

    public String getLoginAlt() {
        return loginAlt;
    }

    public void setLoginAlt(String loginAlt) {
        this.loginAlt = loginAlt;
    }
}
