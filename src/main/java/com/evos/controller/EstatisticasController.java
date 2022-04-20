package com.evos.controller;

import com.evos.enums.ModuloEstatisticas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leonardo.silva
 */
public class EstatisticasController implements Initializable {

    // Opções (Módulos)
    @FXML
    private ChoiceBox<ModuloEstatisticas> cbxModulo = new ChoiceBox<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbxModulo.setItems(FXCollections.observableArrayList(ModuloEstatisticas.values()));
    }
}
