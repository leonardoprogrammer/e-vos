package com.evos.controller;

import com.evos.business.SessionBeanConfiguracoes;
import com.evos.business.SessionBeanEmpresa;
import com.evos.model.dao.ConfiguracoesDAO;
import com.evos.model.vo.ConfiguracoesVO;
import com.evos.model.vo.EmpresaVO;
import com.evos.model.vo.UsuarioVO;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfiguracoesController implements Initializable {

    private EmpresaVO empresa;
    private UsuarioVO usuario;
    private ConfiguracoesVO configuracoes;
    private SessionBeanEmpresa sessionBeanEmpresa;
    private SessionBeanConfiguracoes sessionBeanConfiguracoes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empresa = sessionBeanEmpresa.recuperarEmpresa();
        configuracoes = sessionBeanConfiguracoes.recuperarConfiguracoes();
    }
}
