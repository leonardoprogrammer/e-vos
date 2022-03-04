package com.evos.model.entity;

public class Permissoes {
    private long id;
    // VENDAS
    private String registraVenda;
    private String alteraVenda;
    // PRODUTOS
    private String cadastraProduto;
    private String alteraProduto;
    // CATEGORIAS
    private String cadastraCategoria;
    private String alteraCategoria;
    // USUARIOS
    private String cadastraUsuario;
    private String alteraUsuario;
    // CLIENTES
    private String cadastraCliente;
    private String alteraCliente;
    // DESCONTOS
    private String cadastraDesconto;
    private String alteraDesconto;

    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public Permissoes() {

    }

    public Permissoes(long id, String registraVenda, String alteraVenda, String cadastraProduto, String alteraProduto, String cadastraCategoria, String alteraCategoria, String cadastraUsuario, String alterarUsuario, String cadastraCliente, String alteraCliente, String cadastraDesconto, String alteraDesconto, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.registraVenda = registraVenda;
        this.alteraVenda = alteraVenda;
        this.cadastraProduto = cadastraProduto;
        this.alteraProduto = alteraProduto;
        this.cadastraCategoria = cadastraCategoria;
        this.alteraCategoria = alteraCategoria;
        this.cadastraUsuario = cadastraUsuario;
        this.alteraUsuario = alterarUsuario;
        this.cadastraCliente = cadastraCliente;
        this.alteraCliente = alteraCliente;
        this.cadastraDesconto = cadastraDesconto;
        this.alteraDesconto = alteraDesconto;
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

    public String getRegistraVenda() {
        return registraVenda;
    }

    public void setRegistraVenda(String registraVenda) {
        this.registraVenda = registraVenda;
    }

    public String getAlteraVenda() {
        return alteraVenda;
    }

    public void setAlteraVenda(String alteraVenda) {
        this.alteraVenda = alteraVenda;
    }

    public String getCadastraProduto() {
        return cadastraProduto;
    }

    public void setCadastraProduto(String cadastraProduto) {
        this.cadastraProduto = cadastraProduto;
    }

    public String getAlteraProduto() {
        return alteraProduto;
    }

    public void setAlteraProduto(String alteraProduto) {
        this.alteraProduto = alteraProduto;
    }

    public String getCadastraCategoria() {
        return cadastraCategoria;
    }

    public void setCadastraCategoria(String cadastraCategoria) {
        this.cadastraCategoria = cadastraCategoria;
    }

    public String getAlteraCategoria() {
        return alteraCategoria;
    }

    public void setAlteraCategoria(String alteraCategoria) {
        this.alteraCategoria = alteraCategoria;
    }

    public String getCadastraUsuario() {
        return cadastraUsuario;
    }

    public void setCadastraUsuario(String cadastraUsuario) {
        this.cadastraUsuario = cadastraUsuario;
    }

    public String getAlteraUsuario() {
        return alteraUsuario;
    }

    public void setAlteraUsuario(String alteraUsuario) {
        this.alteraUsuario = alteraUsuario;
    }

    public String getCadastraCliente() {
        return cadastraCliente;
    }

    public void setCadastraCliente(String cadastraCliente) {
        this.cadastraCliente = cadastraCliente;
    }

    public String getAlteraCliente() {
        return alteraCliente;
    }

    public void setAlteraCliente(String alteraCliente) {
        this.alteraCliente = alteraCliente;
    }

    public String getCadastraDesconto() {
        return cadastraDesconto;
    }

    public void setCadastraDesconto(String cadastraDesconto) {
        this.cadastraDesconto = cadastraDesconto;
    }

    public String getAlteraDesconto() {
        return alteraDesconto;
    }

    public void setAlteraDesconto(String alteraDesconto) {
        this.alteraDesconto = alteraDesconto;
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
