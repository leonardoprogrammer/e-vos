package com.evos.model.vo;

import com.evos.enums.TipoUsuario;

import java.util.Calendar;

/**
 * @author leonardo.silva
 */
public class UsuarioVO {
    private long id;
    private String nome;
    private CargoVO cargo;
    private TipoUsuario tipoUsuario;
    private Calendar dataAdmissao;
    private String cpf;
    private Calendar dataNascimento;
    private String email;
    private boolean ativo;
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public UsuarioVO() {

    }

    public UsuarioVO(long id, String nome, CargoVO cargo, Calendar dataAdmissao, String cpf, Calendar dataNascimento, String email, boolean ativo, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
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

    public CargoVO getCargo() {
        return cargo;
    }

    public void setCargo(CargoVO cargo) {
        this.cargo = cargo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
