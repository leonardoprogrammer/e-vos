package com.evos.model.vo;

import java.util.Calendar;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class ClienteVO {
    private long id;
    private String nome;
    private String cpfCnpj;
    private Calendar dataNascimento;
    private String email;
    private String endereco;
    private String telefoneUm;
    private String telefoneDois;
    private boolean enviaEmail; //envia email ao realizar compra
    private String dtaInc;
    private String loginInc;
    private String dtaAlt;
    private String loginAlt;

    public ClienteVO() {

    }

    public ClienteVO(long id, String nome, String cpfCnpj, Calendar dataNascimento, String email, String endereco, String telefoneUm, String telefoneDois, boolean enviaEmail, String dtaInc, String loginInc, String dtaAlt, String loginAlt) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
        this.telefoneUm = telefoneUm;
        this.telefoneDois = telefoneDois;
        this.enviaEmail = enviaEmail;
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefoneUm() {
        return telefoneUm;
    }

    public void setTelefoneUm(String telefoneUm) {
        this.telefoneUm = telefoneUm;
    }

    public String getTelefoneDois() {
        return telefoneDois;
    }

    public void setTelefoneDois(String telefoneDois) {
        this.telefoneDois = telefoneDois;
    }

    public boolean isEnviaEmail() {
        return enviaEmail;
    }

    public void setEnviaEmail(boolean enviaEmail) {
        this.enviaEmail = enviaEmail;
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
