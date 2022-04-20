package com.evos.filtro;

import com.evos.enums.TipoUsuario;
import com.evos.model.vo.CargoVO;

public class FiltrosUsuarios {
    private long id;
    private String nome;
    private String cpf;
    private CargoVO cargo;
    private TipoUsuario tipo;
    private String dataAdmissao;
    private String ativo;

    public FiltrosUsuarios() {

    }

    public FiltrosUsuarios(long id, String nome, String cpf, CargoVO cargo, TipoUsuario tipo, String dataAdmissao, String ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.tipo = tipo;
        this.dataAdmissao = dataAdmissao;
        this.ativo = ativo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CargoVO getCargo() {
        return cargo;
    }

    public void setCargo(CargoVO cargo) {
        this.cargo = cargo;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
