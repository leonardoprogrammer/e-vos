package com.evos.model.vo;

import java.util.List;

public class ConfiguracoesVO {
    // VENDAS
    private boolean enviarEmailVenda;

    // HISTORICO

    // APLICATIVO
    private boolean enviarNotifVendaApp;
    private boolean enviarNotifMetaApp;

    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public ConfiguracoesVO() {

    }

    public ConfiguracoesVO(boolean enviarEmailVenda, boolean enviarNotifVendaApp, boolean enviarNotifMetaApp, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.enviarEmailVenda = enviarEmailVenda;
        this.enviarNotifVendaApp = enviarNotifVendaApp;
        this.enviarNotifMetaApp = enviarNotifMetaApp;
        this.dtaInc = dtaInc;
        this.loginInc = loginInc;
        this.dtaAlt = dtaAlt;
        this.loginAlt = loginAlt;
    }

    public boolean isEnviarEmailVenda() {
        return enviarEmailVenda;
    }

    public void setEnviarEmailVenda(boolean enviarEmailVenda) {
        this.enviarEmailVenda = enviarEmailVenda;
    }

    public boolean isEnviarNotifVendaApp() {
        return enviarNotifVendaApp;
    }

    public void setEnviarNotifVendaApp(boolean enviarNotifVendaApp) {
        this.enviarNotifVendaApp = enviarNotifVendaApp;
    }

    public boolean isEnviarNotifMetaApp() {
        return enviarNotifMetaApp;
    }

    public void setEnviarNotifMetaApp(boolean enviarNotifMetaApp) {
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
