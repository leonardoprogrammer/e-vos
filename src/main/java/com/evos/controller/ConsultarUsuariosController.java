package com.evos.controller;

import com.evos.business.SessionBeanCargo;
import com.evos.business.SessionBeanUsuario;
import com.evos.enums.AtivoInativo;
import com.evos.enums.TipoUsuario;
import com.evos.filtro.FiltrosUsuarios;
import com.evos.model.vo.CargoVO;
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

public class ConsultarUsuariosController implements Initializable {

    private FiltrosUsuarios filtrosUsuarios;
    private SessionBeanUsuario sessionBeanUsuario;
    private SessionBeanCargo sessionBeanCargo;
    private List<UsuarioVO> usuarios = new ArrayList<>();
    private List<CargoVO> cargos = new ArrayList<>();

    private UsuarioVO usuario;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private TextField txtNomeUsuario;

    @FXML
    private TextField txtCpf;

    @FXML
    private ChoiceBox<CargoVO> cbxCargo = new ChoiceBox<>();

    @FXML
    private ChoiceBox<TipoUsuario> cbxTipo = new ChoiceBox<>();

    @FXML
    private DatePicker dateAdmissao;

    @FXML
    private ChoiceBox<AtivoInativo> cbxStatus = new ChoiceBox<>();

    @FXML
    private Button btnNovoUsuario;

    @FXML
    private Button btnAlterarUsuario;

    @FXML
    private Button btnExcluirUsuario;

    @FXML
    private TableView tableUsuarios = new TableView();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!usuario.getCargo().getPermissoes().isCadastraUsuario()) {
            btnNovoUsuario.setDisable(true);
        }
        if (!usuario.getCargo().getPermissoes().isAlteraUsuario()) {
            btnAlterarUsuario.setDisable(true);
            btnExcluirUsuario.setDisable(true);
        }

        cargos = sessionBeanCargo.recuperarTodosCargo();

        cbxCargo.setItems(FXCollections.observableArrayList(cargos));
        cbxTipo.setItems(FXCollections.observableArrayList(TipoUsuario.values()));
        cbxStatus.setItems(FXCollections.observableArrayList(AtivoInativo.values()));
    }

    @FXML
    public void pesquisar() {
        populaFiltros();
        usuarios = sessionBeanUsuario.recuperarUsuariosPorFiltros(filtrosUsuarios);
        tableUsuarios.setItems(FXCollections.observableArrayList(usuarios));
        tableUsuarios.setEditable(false);
    }

    @FXML
    public void novoUsuario() {
        //TODO: abre formUsuario
    }

    @FXML
    public void alterarUsuario() {
        //TODO: abre formUsuario
    }

    @FXML
    public void excluirUsuario() {
        //abre dialog para confirmação
        //informa que será registrado no relatório de ações
    }

    public void populaFiltros() {
        filtrosUsuarios = new FiltrosUsuarios();

        if (!Utils.isNullOrEmpty(txtIdUsuario.getText())) {
            filtrosUsuarios.setId(Long.parseLong(txtIdUsuario.getText()));
        }

        if (!Utils.isNullOrEmpty(txtNomeUsuario.getText())) {
            filtrosUsuarios.setNome(txtNomeUsuario.getText());
        }

        if (!Utils.isNullOrEmpty(txtCpf.getText())) {
            filtrosUsuarios.setCpf(txtCpf.getText());
        }

        if (cbxCargo != null) {
            filtrosUsuarios.setCargo(cbxCargo.getValue());
        }

        if (cbxTipo != null) {
            filtrosUsuarios.setTipo(cbxTipo.getValue());
        }

        if (dateAdmissao != null) {
            filtrosUsuarios.setDataAdmissao(dateAdmissao.getValue().toString());
        }

        if (cbxStatus != null) {
            filtrosUsuarios.setAtivo(cbxStatus.getValue().isStatus() ? "S" : "N");
        }
    }
}
