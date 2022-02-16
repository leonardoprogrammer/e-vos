package com.evos.controller;

import com.evos.business.SessionBeanConfiguracoes;
import com.evos.business.SessionBeanEmpresa;
import com.evos.model.vo.ConfiguracoesVO;
import com.evos.model.vo.EmpresaVO;
import com.evos.model.vo.UsuarioVO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfiguracoesController implements Initializable {

    private EmpresaVO empresa;
    private UsuarioVO usuario;
    private ConfiguracoesVO configuracoes;
    private SessionBeanEmpresa sessionBeanEmpresa;
    private SessionBeanConfiguracoes sessionBeanConfiguracoes;

    // Componentes da Interface

    @FXML
    private CheckBox checkEnviarEmailVenda;

    @FXML
    private CheckBox checkEnviarNotifVendaApp;

    @FXML
    private CheckBox checkEnviarNotifMetaApp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuario = new UsuarioVO();
        empresa = sessionBeanEmpresa.recuperarEmpresa();
        configuracoes = sessionBeanConfiguracoes.recuperarConfiguracoes();
    }

    @FXML
    public void salvarConfiguracoes() {
        configuracoes = new ConfiguracoesVO();
        configuracoes.setEnviarEmailVenda(checkEnviarEmailVenda.isSelected());
        configuracoes.setEnviarNotifVendaApp(checkEnviarNotifVendaApp.isSelected());
        configuracoes.setEnviarNotifMetaApp(checkEnviarNotifMetaApp.isSelected());
        sessionBeanConfiguracoes.alterarConfiguracoes(configuracoes, usuario);
    }
}
