package com.evos.filtro;

import com.evos.enums.FormaPagamento;
import com.evos.enums.TipoVenda;
import com.evos.model.vo.ProdutoVO;

public class FiltrosVendas {
    private long id;
    private ProdutoVO produto;
    private String comDesonto;
    private String dataCompra;
    private TipoVenda tipoVenda;
    private FormaPagamento formaPagamento;
    private String gerouNotaFiscal;
    private String foiCancelada;

    public FiltrosVendas() {

    }

    public FiltrosVendas(long id, ProdutoVO produto, String comDesonto, String dataCompra, TipoVenda tipoVenda, FormaPagamento formaPagamento, String gerouNotaFiscal, String foiCancelada) {
        this.id = id;
        this.produto = produto;
        this.comDesonto = comDesonto;
        this.dataCompra = dataCompra;
        this.tipoVenda = tipoVenda;
        this.formaPagamento = formaPagamento;
        this.gerouNotaFiscal = gerouNotaFiscal;
        this.foiCancelada = foiCancelada;
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

    public String getComDesonto() {
        return comDesonto;
    }

    public void setComDesonto(String comDesonto) {
        this.comDesonto = comDesonto;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public TipoVenda getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(TipoVenda tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getGerouNotaFiscal() {
        return gerouNotaFiscal;
    }

    public void setGerouNotaFiscal(String gerouNotaFiscal) {
        this.gerouNotaFiscal = gerouNotaFiscal;
    }

    public String getFoiCancelada() {
        return foiCancelada;
    }

    public void setFoiCancelada(String foiCancelada) {
        this.foiCancelada = foiCancelada;
    }
}
