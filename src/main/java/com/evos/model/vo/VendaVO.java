package com.evos.model.vo;

import java.util.Calendar;

public class VendaVO {
    private long id;
    private ProdutoVO produto;
    private UsuarioVO vendedor;
    private ClienteVO comprador;
    private Calendar dataCompra;
    private boolean avista;
    private boolean parcelado;
    private boolean gerouNotaFiscal;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public VendaVO() {

    }

    public VendaVO(long id, ProdutoVO produto, UsuarioVO vendedor, ClienteVO comprador, Calendar dataCompra, boolean avista, boolean parcelado, boolean gerouNotaFiscal, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.produto = produto;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.dataCompra = dataCompra;
        this.avista = avista;
        this.parcelado = parcelado;
        this.gerouNotaFiscal = gerouNotaFiscal;
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

    public ClienteVO getComprador() {
        return comprador;
    }

    public void setComprador(ClienteVO comprador) {
        this.comprador = comprador;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public boolean isAvista() {
        return avista;
    }

    public void setAvista(boolean avista) {
        this.avista = avista;
    }

    public boolean isParcelado() {
        return parcelado;
    }

    public void setParcelado(boolean parcelado) {
        this.parcelado = parcelado;
    }

    public boolean isGerouNotaFiscal() {
        return gerouNotaFiscal;
    }

    public void setGerouNotaFiscal(boolean gerouNotaFiscal) {
        this.gerouNotaFiscal = gerouNotaFiscal;
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
