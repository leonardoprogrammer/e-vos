package com.evos.model.vo;

/**
 * @author leonardo.silva
 */
public class PermissoesVO {
    // SOMENTE 'ADMIN' PODE ALTERAR PERMISSOES
    // o cadastro de permissões é feito automaticamente ao cadastrar cargos
    private long id;
    // VENDAS
    private boolean registraVenda;
    private boolean alteraVenda; // serve para alterar, cancelar e deletar
    // PRODUTOS
    private boolean cadastraProduto;
    private boolean alteraProduto; // serve para alterar, ativar/desativar e deletar
    // CATEGORIAS
    private boolean cadastraCategoria;
    private boolean alterarCategoria; // serve para alterar, ativar/desativar e deletar
    // USUARIOS
    private boolean cadastraUsuario;
    private boolean alteraUsuario; // serve para alterar, ativar/desativar e deletar
    // CLIENTES
    private boolean cadastraCliente;
    private boolean alteraCliente; // serve para alterar, ativar/desativar e deletar
    // DESCONTOS
    private boolean cadastraDesconto;
    private boolean alteraDesconto; // serve para alterar, ativar/desativar e deletar

    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public PermissoesVO() {

    }

    public PermissoesVO(long id, boolean registraVenda, boolean alteraVenda, boolean cadastraProduto, boolean alteraProduto, boolean cadastraCategoria, boolean alterarCategoria, boolean cadastraUsuario, boolean alteraUsuario, boolean cadastraCliente, boolean alteraCliente, boolean cadastraDesconto, boolean alteraDesconto, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.registraVenda = registraVenda;
        this.alteraVenda = alteraVenda;
        this.cadastraProduto = cadastraProduto;
        this.alteraProduto = alteraProduto;
        this.cadastraCategoria = cadastraCategoria;
        this.alterarCategoria = alterarCategoria;
        this.cadastraUsuario = cadastraUsuario;
        this.alteraUsuario = alteraUsuario;
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

    public boolean isRegistraVenda() {
        return registraVenda;
    }

    public void setRegistraVenda(boolean registraVenda) {
        this.registraVenda = registraVenda;
    }

    public boolean isAlteraVenda() {
        return alteraVenda;
    }

    public void setAlteraVenda(boolean alteraVenda) {
        this.alteraVenda = alteraVenda;
    }

    public boolean isCadastraProduto() {
        return cadastraProduto;
    }

    public void setCadastraProduto(boolean cadastraProduto) {
        this.cadastraProduto = cadastraProduto;
    }

    public boolean isAlteraProduto() {
        return alteraProduto;
    }

    public void setAlteraProduto(boolean alteraProduto) {
        this.alteraProduto = alteraProduto;
    }

    public boolean isCadastraCategoria() {
        return cadastraCategoria;
    }

    public void setCadastraCategoria(boolean cadastraCategoria) {
        this.cadastraCategoria = cadastraCategoria;
    }

    public boolean isAlterarCategoria() {
        return alterarCategoria;
    }

    public void setAlterarCategoria(boolean alterarCategoria) {
        this.alterarCategoria = alterarCategoria;
    }

    public boolean isCadastraUsuario() {
        return cadastraUsuario;
    }

    public void setCadastraUsuario(boolean cadastraUsuario) {
        this.cadastraUsuario = cadastraUsuario;
    }

    public boolean isAlteraUsuario() {
        return alteraUsuario;
    }

    public void setAlteraUsuario(boolean alteraUsuario) {
        this.alteraUsuario = alteraUsuario;
    }

    public boolean isCadastraCliente() {
        return cadastraCliente;
    }

    public void setCadastraCliente(boolean cadastraCliente) {
        this.cadastraCliente = cadastraCliente;
    }

    public boolean isAlteraCliente() {
        return alteraCliente;
    }

    public void setAlteraCliente(boolean alteraCliente) {
        this.alteraCliente = alteraCliente;
    }

    public boolean isCadastraDesconto() {
        return cadastraDesconto;
    }

    public void setCadastraDesconto(boolean cadastraDesconto) {
        this.cadastraDesconto = cadastraDesconto;
    }

    public boolean isAlteraDesconto() {
        return alteraDesconto;
    }

    public void setAlteraDesconto(boolean alteraDesconto) {
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
