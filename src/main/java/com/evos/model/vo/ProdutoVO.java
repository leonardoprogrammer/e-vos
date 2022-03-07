package com.evos.model.vo;

import com.evos.enums.TipoProduto;

/**
 * @author leonardo.silva
 */
public class ProdutoVO {
    private long id;
    private String nome;
    private TipoProduto tipoProduto;
    private CategoriaVO categoria;
    private Double valor;
    private boolean ativo;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public ProdutoVO() {

    }

    public ProdutoVO(long id, String nome, TipoProduto tipo, CategoriaVO categoria, Double valor, boolean ativo, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.nome = nome;
        this.tipoProduto = tipo;
        this.categoria = categoria;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public CategoriaVO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVO categoria) {
        this.categoria = categoria;
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
