package com.evos.model.vo;

/**
 * @author leonardo.silva
 */
public class PermissoesVO {
    // SOMENTE 'ADMIN' PODE ALTERAR PERMISSOES
    // o cadastro de permissões é feito automaticamente ao cadastrar cargos
    private long id;
    // VENDAS
    private boolean consultaVenda;
    private boolean registraVenda;
    private boolean alteraVenda; // serve para alterar, cancelar e deletar
    // PRODUTOS
    private boolean consultaProduto;
    private boolean cadastraProduto;
    private boolean alteraProduto; // serve para alterar, ativar/desativar e deletar
    // CATEGORIAS
    private boolean consultaCategoria;
    private boolean cadastraCategoria;
    private boolean alteraCategoria; // serve para alterar, ativar/desativar e deletar
    // USUARIOS
    private boolean consultaUsuario;
    private boolean cadastraUsuario;
    private boolean alteraUsuario; // serve para alterar, ativar/desativar e deletar
    // CLIENTES
    private boolean consultaCliente;
    private boolean cadastraCliente;
    private boolean alteraCliente; // serve para alterar, ativar/desativar e deletar
    // DESCONTOS
    private boolean consultaDesconto;
    private boolean cadastraDesconto;
    private boolean alteraDesconto; // serve para alterar, ativar/desativar e deletar
    // CARGOS
    private boolean consultaCargo;
    private boolean cadastraCargo;
    private boolean alteraCargo; // serve para alterar, ativar/desativar e deletar

    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public PermissoesVO() {

    }

    public PermissoesVO(long id, boolean consultaVenda, boolean registraVenda, boolean alteraVenda, boolean consultaProduto, boolean cadastraProduto, boolean alteraProduto, boolean consultaCategoria, boolean cadastraCategoria, boolean alterarCategoria, boolean consultaUsuario, boolean cadastraUsuario, boolean alteraUsuario, boolean consultaCliente, boolean cadastraCliente, boolean alteraCliente, boolean consultaDesconto, boolean cadastraDesconto, boolean alteraDesconto, boolean consultaCargo, boolean cadastroCargo, boolean alterarCargo, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.consultaVenda = consultaVenda;
        this.registraVenda = registraVenda;
        this.alteraVenda = alteraVenda;
        this.consultaProduto = consultaProduto;
        this.cadastraProduto = cadastraProduto;
        this.alteraProduto = alteraProduto;
        this.consultaCategoria = consultaCategoria;
        this.cadastraCategoria = cadastraCategoria;
        this.alteraCategoria = alterarCategoria;
        this.consultaUsuario = consultaUsuario;
        this.cadastraUsuario = cadastraUsuario;
        this.alteraUsuario = alteraUsuario;
        this.consultaCliente = consultaCliente;
        this.cadastraCliente = cadastraCliente;
        this.alteraCliente = alteraCliente;
        this.consultaDesconto = consultaDesconto;
        this.cadastraDesconto = cadastraDesconto;
        this.alteraDesconto = alteraDesconto;
        this.consultaCargo = consultaCargo;
        this.cadastraCargo = cadastroCargo;
        this.alteraCargo = alterarCargo;
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

    public boolean isConsultaVenda() {
        return consultaVenda;
    }

    public void setConsultaVenda(boolean consultaVenda) {
        this.consultaVenda = consultaVenda;
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

    public boolean isConsultaProduto() {
        return consultaProduto;
    }

    public void setConsultaProduto(boolean consultaProduto) {
        this.consultaProduto = consultaProduto;
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

    public boolean isConsultaCategoria() {
        return consultaCategoria;
    }

    public void setConsultaCategoria(boolean consultaCategoria) {
        this.consultaCategoria = consultaCategoria;
    }

    public boolean isCadastraCategoria() {
        return cadastraCategoria;
    }

    public void setCadastraCategoria(boolean cadastraCategoria) {
        this.cadastraCategoria = cadastraCategoria;
    }

    public boolean isAlteraCategoria() {
        return alteraCategoria;
    }

    public void setAlteraCategoria(boolean alteraCategoria) {
        this.alteraCategoria = alteraCategoria;
    }

    public boolean isConsultaUsuario() {
        return consultaUsuario;
    }

    public void setConsultaUsuario(boolean consultaUsuario) {
        this.consultaUsuario = consultaUsuario;
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

    public boolean isConsultaCliente() {
        return consultaCliente;
    }

    public void setConsultaCliente(boolean consultaCliente) {
        this.consultaCliente = consultaCliente;
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

    public boolean isConsultaDesconto() {
        return consultaDesconto;
    }

    public void setConsultaDesconto(boolean consultaDesconto) {
        this.consultaDesconto = consultaDesconto;
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

    public boolean isConsultaCargo() {
        return consultaCargo;
    }

    public void setConsultaCargo(boolean consultaCargo) {
        this.consultaCargo = consultaCargo;
    }

    public boolean isCadastraCargo() {
        return cadastraCargo;
    }

    public void setCadastraCargo(boolean cadastraCargo) {
        this.cadastraCargo = cadastraCargo;
    }

    public boolean isAlteraCargo() {
        return alteraCargo;
    }

    public void setAlteraCargo(boolean alteraCargo) {
        this.alteraCargo = alteraCargo;
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
