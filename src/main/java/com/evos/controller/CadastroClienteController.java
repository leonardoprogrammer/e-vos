package com.evos.controller;

import com.evos.model.vo.ClienteVO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leonardo.silva
 */
public class CadastroClienteController implements Initializable {

    private ClienteVO cliente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void registrarVenda() {
        cliente = new ClienteVO();
    }
}
