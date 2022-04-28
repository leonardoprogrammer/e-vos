package com.evos.controller;

import com.evos.business.SessionBeanCliente;
import com.evos.enums.SimNao;
import com.evos.filtro.FiltrosClientes;
import com.evos.model.vo.ClienteVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Utils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ConsultarClientesController implements Initializable {

    private FiltrosClientes filtrosClientes;
    private SessionBeanCliente sessionBeanCliente;
    private List<ClienteVO> clientes;

    private UsuarioVO usuario;

    @FXML
    private TextField txtIdCliente;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtCpf;

    @FXML
    private DatePicker dateCadastro;

    @FXML
    private ChoiceBox<SimNao> cbxEnviaEmail = new ChoiceBox<>();

    @FXML
    private Button btnNovoCliente;

    @FXML
    private Button btnAlterarCliente;

    @FXML
    private Button btnExcluirCliente;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TableView tableClientes = new TableView();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!usuario.getCargo().getPermissoes().isCadastraCliente()) {
            btnNovoCliente.setDisable(true);
        }
        if (!usuario.getCargo().getPermissoes().isAlteraCliente()) {
            btnAlterarCliente.setDisable(true);
            btnExcluirCliente.setDisable(true);
        }

        clientes = sessionBeanCliente.recuperarTodosClientes();
    }

    @FXML
    public void pesquisar() {
        populaFiltros();
        clientes = sessionBeanCliente.recuperarClientesPorFiltros(filtrosClientes);
        tableClientes.setItems(FXCollections.observableArrayList(clientes));
        tableClientes.setEditable(false);
    }

    @FXML
    public void novoCliente() {
        //TODO: abre formCliente
    }

    @FXML
    public void alterarCliente() {
        //TODO: abre formCliente
    }

    @FXML
    public void excluirCliente() {
        //abre dialog para confirmação
        //informa que será registrado no relatório de ações
    }

    public void populaFiltros() {
        filtrosClientes = new FiltrosClientes();

        if (!Utils.isNullOrEmpty(txtIdCliente.getText())) {
            filtrosClientes.setId(Long.parseLong(txtIdCliente.getText()));
        }

        if (!Utils.isNullOrEmpty(txtNomeCliente.getText())) {
            filtrosClientes.setNome(txtNomeCliente.getText());
        }

        if (!Utils.isNullOrEmpty(txtCpf.getText())) {
            filtrosClientes.setCpf(txtCpf.getText());
        }

        if (dateCadastro.getValue() != null) {
            filtrosClientes.setDataCadastro(dateCadastro.getValue().toString());
        }

        if (cbxEnviaEmail.getValue() != null) {
            filtrosClientes.setEnviaEmail(cbxEnviaEmail.getValue().isStatus() ? "S" : "N");
        }
    }
}
