package com.evos.model.vo;

import com.evos.enums.FormaPagamento;
import com.evos.enums.TipoVenda;

import java.util.Calendar;

/**
 * @author leonardo.silva
 */
public class VendaVO {
    private long id;
    private ProdutoVO produto;
    private UsuarioVO vendedor;
    private ClienteVO cliente;
    private Calendar dataCompra;
    private TipoVenda tipoVenda;
    private FormaPagamento formaPagamento;
    private boolean gerouNotaFiscal;
    private String observacao;
    private boolean cancelada;
    private boolean prodDevolvido;
    private Calendar dataCancela;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public VendaVO() {

    }

    public VendaVO(long id, ProdutoVO produto, UsuarioVO vendedor, ClienteVO comprador, Calendar dataCompra, TipoVenda tipoVenda, FormaPagamento formaPagamento, boolean gerouNotaFiscal, String observacao, boolean cancelada, boolean prodDevolvido, Calendar dataCancela, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.produto = produto;
        this.vendedor = vendedor;
        this.cliente = comprador;
        this.dataCompra = dataCompra;
        this.tipoVenda = tipoVenda;
        this.formaPagamento = formaPagamento;
        this.gerouNotaFiscal = gerouNotaFiscal;
        this.observacao = observacao;
        this.cancelada = cancelada;
        this.prodDevolvido = prodDevolvido;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
