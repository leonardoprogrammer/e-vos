package com.evos.model.entity;

/**
 * @author leonardo.silva
 */
public class Permissoes {
    private long id;
    // VENDAS
    private String consultaVenda;
    private String registraVenda;
    private String alteraVenda;
    // PRODUTOS
    private String consultaProduto;
    private String cadastraProduto;
    private String alteraProduto;
    // CATEGORIAS
    private String consultaCategoria;
    private String cadastraCategoria;
    private String alteraCategoria;
    // USUARIOS
    private String consultaUsuario;
    private String cadastraUsuario;
    private String alteraUsuario;
    // CLIENTES
    private String consultaCliente;
    private String cadastraCliente;
    private String alteraCliente;
    // DESCONTOS
    private String consultaDesconto;
    private String cadastraDesconto;
    private String alteraDesconto;

    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public Permissoes() {

    }

    public Permissoes(long id, String consultaVenda, String registraVenda, String alteraVenda, String consultaProduto, String cadastraProduto, String alteraProduto, String consultaCategoria, String cadastraCategoria, String alteraCategoria, String consultaUsuario, String cadastraUsuario, String alteraUsuario, String consultaCliente, String cadastraCliente, String alteraCliente, String consultaDesconto, String cadastraDesconto, String alteraDesconto, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.consultaVenda = consultaVenda;
        this.registraVenda = registraVenda;
        this.alteraVenda = alteraVenda;
        this.consultaProduto = consultaProduto;
        this.cadastraProduto = cadastraProduto;
        this.alteraProduto = alteraProduto;
        this.consultaCategoria = consultaCategoria;
        this.cadastraCategoria = cadastraCategoria;
        this.alteraCategoria = alteraCategoria;
        this.consultaUsuario = consultaUsuario;
        this.cadastraUsuario = cadastraUsuario;
        this.alteraUsuario = alteraUsuario;
        this.consultaCliente = consultaCliente;
        this.cadastraCliente = cadastraCliente;
        this.alteraCliente = alteraCliente;
        this.consultaDesconto = consultaDesconto;
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

    public String getConsultaVenda() {
        return consultaVenda;
    }

    public void setConsultaVenda(String consultaVenda) {
        this.consultaVenda = consultaVenda;
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

    public String getConsultaProduto() {
        return consultaProduto;
    }

    public void setConsultaProduto(String consultaProduto) {
        this.consultaProduto = consultaProduto;
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

    public String getConsultaCategoria() {
        return consultaCategoria;
    }

    public void setConsultaCategoria(String consultaCategoria) {
        this.consultaCategoria = consultaCategoria;
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

    public String getConsultaUsuario() {
        return consultaUsuario;
    }

    public void setConsultaUsuario(String consultaUsuario) {
        this.consultaUsuario = consultaUsuario;
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

    public String getConsultaCliente() {
        return consultaCliente;
    }

    public void setConsultaCliente(String consultaCliente) {
        this.consultaCliente = consultaCliente;
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

    public String getConsultaDesconto() {
        return consultaDesconto;
    }

    public void setConsultaDesconto(String consultaDesconto) {
        this.consultaDesconto = consultaDesconto;
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
