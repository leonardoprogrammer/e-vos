package com.evos.filtro;

import com.evos.enums.TipoProduto;
import com.evos.model.vo.CategoriaVO;

public class FiltrosProdutos {
    private long id;
    private String nome;
    private TipoProduto tipo;
    private CategoriaVO categoria;
    private String ativo;
    private String dataCadastro;

    public FiltrosProdutos() {

    }

    public FiltrosProdutos(long id, String nome, TipoProduto tipo, CategoriaVO categoria, String ativo, String dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = categoria;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
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

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public CategoriaVO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVO categoria) {
        this.categoria = categoria;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
