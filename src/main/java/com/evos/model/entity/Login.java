package com.evos.model.entity;

/**
 * @author leonardo.silva
 */
public class Login {
    // SOMENTE 'ADMIN' PODE ALTERAR DADOS DE LOGIN
    private long id;
    private long idUsuario;
    private String username;
    private String senha;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public Login() {

    }

    public Login(long id, long idUsuario, String username, String senha, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.username = username;
        this.senha = senha;
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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
