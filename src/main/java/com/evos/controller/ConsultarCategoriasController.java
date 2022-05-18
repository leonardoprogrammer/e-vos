package com.evos.controller;

import com.evos.business.SessionBeanCategoria;
import com.evos.enums.AtivoInativo;
import com.evos.filtro.FiltrosCategorias;
import com.evos.model.vo.CategoriaVO;
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

public class ConsultarCategoriasController implements Initializable {

    private FiltrosCategorias filtrosCategorias;
    private SessionBeanCategoria sessionBeanCategoria;
    private List<CategoriaVO> categorias = new ArrayList<>();

    private UsuarioVO usuario;

    @FXML
    private TextField txtIdCategoria;

    @FXML
    private TextField txtNome;

    @FXML
    private ChoiceBox<AtivoInativo> cbxAtivo = new ChoiceBox<>();

    @FXML
    private DatePicker dateCadastro;

    @FXML
    private Button btnNovaCategoria;

    @FXML
    private Button btnAlterarCategoria;

    @FXML
    private Button btnExcluirCategoria;

    @FXML
    private TableView tableCategorias = new TableView();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!usuario.getCargo().getPermissoes().isCadastraCargo()) {
            btnNovaCategoria.setDisable(true);
        }
        if (!usuario.getCargo().getPermissoes().isAlteraCategoria()) {
            btnAlterarCategoria.setDisable(true);
            btnExcluirCategoria.setDisable(true);
        }
    }

    @FXML
    public void pesquisar() {
        populaFiltros();
        categorias = sessionBeanCategoria.recuperarCategoriasPorFiltros(filtrosCategorias);
        tableCategorias.setItems(FXCollections.observableArrayList(categorias));
        tableCategorias.setEditable(false);
    }

    @FXML
    public void novaCategoria() {
        //TODO: abre formCategoria;
    }

    @FXML
    public void alterarCategoria() {
        //TODO: abre formCategoria;
    }

    @FXML
    public void excluirCategoria() {
        //abre dialog para confirmação
        //informa que será registrado no relatório de ações
    }

    public void populaFiltros() {
        filtrosCategorias = new FiltrosCategorias();

        if (!Utils.isNullOrEmpty(txtIdCategoria.getText())) {
            filtrosCategorias.setId(Long.parseLong(txtIdCategoria.getText()));
        }

        if (!Utils.isNullOrEmpty(txtNome.getText())) {
            filtrosCategorias.setNome(txtNome.getText());
        }

        if (cbxAtivo.getValue() != null) {
            filtrosCategorias.setAtivo(cbxAtivo.getValue().isStatus() ? "S" : "N");
        }

        if (dateCadastro.getValue() != null) {
            filtrosCategorias.setDataCadastro(dateCadastro.getValue().toString());
        }
    }
}
