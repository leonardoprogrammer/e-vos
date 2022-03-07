package com.evos.model.entity;

import java.util.Calendar;

/**
 * @author leonardo.silva
 */
public class Venda {
    private long id;
    private long idProduto;
    private long idVendedor;
    private long idCliente;
    private Double valorTotal;
    private Double valorDesconto;
    private int qtdItens;
    private Calendar dataCompra;
    private int tipoVenda;
    private int formaPagamento;
    private String gerouNotaFiscal;
    private String observacao;
    private String cancelada;
    private Calendar dataCancela;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public Venda() {

    }

    public Venda(long id, long idProduto, long idVendedor, long idCliente, Double valorTotal, Double valorDesconto, int qtdItens, Calendar dataCompra, int tipoVenda, int formaPagamento, String gerouNotaFiscal, String observacao, String cancelada, Calendar dataCancela, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.idProduto = idProduto;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.qtdItens = qtdItens;
        this.dataCompra = dataCompra;
        this.tipoVenda = tipoVenda;
        this.formaPagamento = formaPagamento;
        this.gerouNotaFiscal = gerouNotaFiscal;
        this.observacao = observacao;
        this.cancelada = cancelada;
        this.dataCancela = dataCancela;
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
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

    public String getCancelada() {
        return cancelada;
    }

    public void setCancelada(String cancelada) {
        this.cancelada = cancelada;
    }

    public Calendar getDataCancela() {
        return dataCancela;
    }

    public void setDataCancela(Calendar dataCancela) {
        this.dataCancela = dataCancela;
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
