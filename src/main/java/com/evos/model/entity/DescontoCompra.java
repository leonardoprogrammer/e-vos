package com.evos.model.entity;

public class DescontoCompra {
    private long id;
    private int qtdMininaProduto;
    private int tipoDesconto;
    private Double porcentagem;
    private Double valor;
    private String ativo;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public DescontoCompra() {

    }

    public DescontoCompra(long id, int qtdMininaProduto, int tipoDesconto, Double porcentagem, Double valor, String ativo, String dtaInc, String loginInc, String dtAlt, String loginAlt) {
        this.id = id;
        this.qtdMininaProduto = qtdMininaProduto;
        this.tipoDesconto = tipoDesconto;
        this.porcentagem = porcentagem;
        this.valor = valor;
        this.ativo = ativo;
        this.dtaInc = dtaInc;
        this.loginInc = loginInc;
        this.dtaAlt = dtAlt;
        this.loginAlt = loginAlt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQtdMininaProduto() {
        return qtdMininaProduto;
    }

    public void setQtdMininaProduto(int qtdMininaProduto) {
        this.qtdMininaProduto = qtdMininaProduto;
    }

    public int getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(int tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
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
