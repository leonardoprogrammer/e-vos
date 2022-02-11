package com.evos.model.entity;

public class DescontoProduto {
    private long id;
    private long idProduto;
    private int qtdMinima;
    private int tipoDesconto;
    private Double porcentagem;
    private Double valor;
    private String apenasUmDesconto; // permite só um desconto por venda, mesmo que haja mais de uma unid. do produto
    private String ativo;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public DescontoProduto() {

    }

    public DescontoProduto(long id, long idProduto, int qtdMinima, int tipoDesconto, Double porcentagem, Double valor, String apenasUmDesconto, String ativo, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.idProduto = idProduto;
        this.qtdMinima = qtdMinima;
        this.tipoDesconto = tipoDesconto;
        this.porcentagem = porcentagem;
        this.valor = valor;
        this.apenasUmDesconto = apenasUmDesconto;
        this.ativo = ativo;
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

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
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

    public String getApenasUmDesconto() {
        return apenasUmDesconto;
    }

    public void setApenasUmDesconto(String apenasUmDesconto) {
        this.apenasUmDesconto = apenasUmDesconto;
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
