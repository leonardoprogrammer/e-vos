package com.evos.controller;

import com.evos.model.dao.CondiguracoesDAO;
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
    private CondiguracoesDAO configuracoesDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // recebe EmpresaVO
        // recebe UsuarioVO
        configuracoes = new ConfiguracoesVO();
        configuracoes = configuracoesDao.recuperarConfiguracoes(empresa.getId());
    }
}
