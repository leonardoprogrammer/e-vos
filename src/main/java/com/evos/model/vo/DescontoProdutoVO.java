package com.evos.model.vo;

import com.evos.enums.TipoDesconto;

public class DescontoProdutoVO {
    private long id;
    private ProdutoVO produto;
    private int qtdMinima;
    private TipoDesconto tipoDesconto;
    private Double porcentagem;
    private Double valor;
    private boolean apenasUmDesconto; // permite só um desconto por venda, mesmo que haja mais de uma unid. do produto
    private boolean ativo;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public DescontoProdutoVO() {

    }

    public DescontoProdutoVO(long id, ProdutoVO produto, int qtdMinima, TipoDesconto tipoDesconto, Double porcentagem, Double valor, boolean apenasUmDesconto, boolean ativo, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.produto = produto;
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

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public TipoDesconto getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipoDesconto tipoDesconto) {
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

    public boolean isApenasUmDesconto() {
        return apenasUmDesconto;
    }

    public void setApenasUmDesconto(boolean apenasUmDesconto) {
        this.apenasUmDesconto = apenasUmDesconto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
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
