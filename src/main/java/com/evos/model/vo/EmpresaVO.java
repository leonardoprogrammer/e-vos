package com.evos.model.vo;

/**
 * @author leonardo.silva
 */
public class EmpresaVO {
    private long id;
    private String nome;
    private String cnpj;
    private boolean possuiCnpj;
    private boolean ativa;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public EmpresaVO() {

    }

    public EmpresaVO(long id, String nome, String cnpj, boolean possuiCnpj, boolean ativa, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
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
