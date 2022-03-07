package com.evos.model.vo;

/**
 * @author leonardo.silva
 */
public class VendaItemVO {
    private long id;
    private long idVenda;
    private long sequencial;
    private ProdutoVO produto;
    private Double valorUnidade;
    private Double descontoProduto;
    private Double valorItem;
    private int quantidade;

    public VendaItemVO() {

    }

    public VendaItemVO(long id, long idVenda, long sequencial, ProdutoVO produto, Double valorUnidade, Double descontoProduto, Double valorItem, int quantidade) {
        this.id = id;
        this.idVenda = idVenda;
        this.sequencial = sequencial;
        this.produto = produto;
        this.valorUnidade = valorUnidade;
        this.descontoProduto = descontoProduto;
        this.valorItem = valorItem;
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public long getSequencial() {
        return sequencial;
    }

    public void setSequencial(long sequencial) {
        this.sequencial = sequencial;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public Double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public Double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(Double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
