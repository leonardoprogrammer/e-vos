package com.evos.controller;

import com.evos.model.vo.VendaVO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leonardo.silva
 */
public class NovaVendaController implements Initializable {

    private VendaVO venda;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void registrarVenda() {
        venda = new VendaVO();
    }
}
