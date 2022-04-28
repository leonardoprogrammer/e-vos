package com.evos.controller;

import com.evos.business.SessionBeanCargo;
import com.evos.enums.AtivoInativo;
import com.evos.filtro.FiltrosCargos;
import com.evos.model.vo.CargoVO;
import com.evos.model.vo.PermissoesVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Utils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConsultarCargosController implements Initializable {

    private FiltrosCargos filtrosCargos;
    private SessionBeanCargo sessionBeanCargo;
    private List<CargoVO> cargos = new ArrayList<>();

    private UsuarioVO usuario;

    @FXML
    private TextField txtIdCargo;

    @FXML
    private TextField txtNome;

    @FXML
    private ChoiceBox<AtivoInativo> cbxAtivo = new ChoiceBox<>();

    @FXML
    private DatePicker dateCadastro;

    @FXML
    private Button btnNovoCargo;

    @FXML
    private Button btnAlterarCargo;

    @FXML
    private Button btnExcluirCargo;

    @FXML
    private TableView tableCargos = new TableView();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!usuario.getCargo().getPermissoes().isCadastraCargo()) {
            btnNovoCargo.setDisable(true);
        }
        if (!usuario.getCargo().getPermissoes().isAlteraCargo()) {
            btnAlterarCargo.setDisable(true);
            btnExcluirCargo.setDisable(true);
        }
    }

    @FXML
    public void pesquisar() {
        populaFiltros();
        cargos = sessionBeanCargo.recuperarCargosPorFiltros(filtrosCargos);
        tableCargos.setItems(FXCollections.observableArrayList(cargos));
        tableCargos.setEditable(false);
    }

    @FXML
    public void novoCargo() {
        //TODO: abre formCargo
    }

    @FXML
    public void alterarCargo() {
        //TODO: abre formCargo
    }

    @FXML
    public void excluirCargo() {
        //abre dialog para confirmação
        //informa que será registrado no relatório de vendas
    }

    public void populaFiltros() {
        filtrosCargos = new FiltrosCargos();

        if (!Utils.isNullOrEmpty(txtIdCargo.getText())) {
            filtrosCargos.setId(Long.parseLong(txtIdCargo.getText()));
        }

        if (!Utils.isNullOrEmpty(txtNome.getText())) {
            filtrosCargos.setNome(txtNome.getText());
        }

        if (cbxAtivo.getValue() != null) {
            filtrosCargos.setAtivo(cbxAtivo.getValue().isStatus() ? "S" : "N");
        }

        if (dateCadastro.getValue() != null) {
            filtrosCargos.setDataCadastro(dateCadastro.getValue().toString());
        }
    }
}
