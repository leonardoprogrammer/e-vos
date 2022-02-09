package com.evos.model.vo;

import com.evos.enums.FormaPagamento;
import com.evos.enums.TipoVenda;

import java.util.Calendar;

public class FiltroVendaVO {
    private long id;
    private ProdutoVO produto;
    private UsuarioVO vendedor;
    private ClienteVO cliente;
    private Calendar dataCompra;
    private TipoVenda tipoVenda;
    private FormaPagamento formaPagamento;
    private boolean gerouNotaFiscal;
    private boolean cancelada;
    private boolean prodDevolvido;
    private String dtaInc;

    public FiltroVendaVO(long id, ProdutoVO produto, UsuarioVO vendedor, ClienteVO cliente, Calendar dataCompra, TipoVenda tipoVenda, FormaPagamento formaPagamento, boolean gerouNotaFiscal, boolean cancelada, boolean prodDevolvido, String dtaInc) {
        this.id = id;
        this.produto = produto;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.tipoVenda = tipoVenda;
        this.formaPagamento = formaPagamento;
        this.gerouNotaFiscal = gerouNotaFiscal;
        this.cancelada = cancelada;
        this.prodDevolvido = prodDevolvido;
        this.dtaInc = dtaInc;
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

    public UsuarioVO getVendedor() {
        return vendedor;
    }

    public void setVendedor(UsuarioVO vendedor) {
        this.vendedor = vendedor;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
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

    public boolean isGerouNotaFiscal() {
        return gerouNotaFiscal;
    }

    public void setGerouNotaFiscal(boolean gerouNotaFiscal) {
        this.gerouNotaFiscal = gerouNotaFiscal;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public boolean isProdDevolvido() {
        return prodDevolvido;
    }

    public void setProdDevolvido(boolean prodDevolvido) {
        this.prodDevolvido = prodDevolvido;
    }

    public String getDtaInc() {
        return dtaInc;
    }

    public void setDtaInc(String dtaInc) {
        this.dtaInc = dtaInc;
    }
}
