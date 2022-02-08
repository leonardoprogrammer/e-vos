package com.evos.model.entity;

import java.util.Calendar;

public class Venda {
    private long id;
    private long idProduto;
    private long idVendedor;
    private long idCliente;
    private Calendar dataCompra;
    private int tipoVenda;
    private int formaPagamento;
    private String gerouNotaFiscal;
    private String observacao;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public Venda() {

    }

    public Venda(long id, long id_produto, long id_vendedor, long id_cliente, Calendar dataCompra, int tipoVenda, int formaPagamento, String gerouNotaFiscal, String observacao, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.idProduto = id_produto;
        this.idVendedor = id_vendedor;
        this.idCliente = id_cliente;
        this.dataCompra = dataCompra;
        this.tipoVenda = tipoVenda;
        this.formaPagamento = formaPagamento;
        this.gerouNotaFiscal = gerouNotaFiscal;
        this.observacao = observacao;
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

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(int tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getGerouNotaFiscal() {
        return gerouNotaFiscal;
    }

    public void setGerouNotaFiscal(String gerouNotaFiscal) {
        this.gerouNotaFiscal = gerouNotaFiscal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
