package com.evos.model.vo;

import com.evos.enums.TipoDesconto;

/**
 * @author leonardo.silva
 */
public class DescontoCompraVO {
    private long id;
    private int qtdMininaProdutos;
    private TipoDesconto tipoDesconto;
    private Double porcentagem;
    private Double valor;
    private boolean ativo;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public DescontoCompraVO () {

    }

    public DescontoCompraVO(long id, int qtdMininaProdutos, TipoDesconto tipoDesconto, Double porcentagem, Double valor, boolean ativo, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.qtdMininaProdutos = qtdMininaProdutos;
        this.tipoDesconto = tipoDesconto;
        this.porcentagem = porcentagem;
        this.valor = valor;
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

    public int getQtdMininaProdutos() {
        return qtdMininaProdutos;
    }

    public void setQtdMininaProdutos(int qtdMininaProdutos) {
        this.qtdMininaProdutos = qtdMininaProdutos;
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
