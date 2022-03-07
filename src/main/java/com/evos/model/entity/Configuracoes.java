package com.evos.model.entity;

/**
 * @author leonardo.silva
 */
public class Configuracoes {
    // SOMENTE 'ADMIN' PODE ALTERAR AS CONFIGURACOES
    // VENDAS
    private String enviarEmailVenda;
    // APLICATIVO
    private String enviarNotifVendaApp;
    private String enviarNotifMetaApp;

    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public Configuracoes() {

    }

    public Configuracoes(String enviarEmailVenda, String enviarNotifVendaApp, String enviarNotifMetaApp, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.enviarEmailVenda = enviarEmailVenda;
        this.enviarNotifVendaApp = enviarNotifVendaApp;
        this.enviarNotifMetaApp = enviarNotifMetaApp;
        this.dtaInc = dtaInc;
        this.loginInc = loginInc;
        this.dtaAlt = dtaAlt;
        this.loginAlt = loginAlt;
    }

    public String getEnviarEmailVenda() {
        return enviarEmailVenda;
    }

    public void setEnviarEmailVenda(String enviarEmailVenda) {
        this.enviarEmailVenda = enviarEmailVenda;
    }

    public String getEnviarNotifVendaApp() {
        return enviarNotifVendaApp;
    }

    public void setEnviarNotifVendaApp(String enviarNotifVendaApp) {
        this.enviarNotifVendaApp = enviarNotifVendaApp;
    }

    public String getEnviarNotifMetaApp() {
        return enviarNotifMetaApp;
    }

    public void setEnviarNotifMetaApp(String enviarNotifMetaApp) {
        this.enviarNotifMetaApp = enviarNotifMetaApp;
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
