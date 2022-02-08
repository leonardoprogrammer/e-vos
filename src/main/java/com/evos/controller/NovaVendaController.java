package com.evos.controller;

import com.evos.model.vo.VendaVO;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class NovaVendaController implements Initializable {

    private VendaVO venda;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        venda = new VendaVO();
    }
}
