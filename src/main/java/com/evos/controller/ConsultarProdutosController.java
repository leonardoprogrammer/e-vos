package com.evos.controller;

import com.evos.business.SessionBeanCategoria;
import com.evos.business.SessionBeanProduto;
import com.evos.enums.AtivoInativo;
import com.evos.enums.TipoProduto;
import com.evos.filtro.FiltrosProdutos;
import com.evos.model.vo.CategoriaVO;
import com.evos.model.vo.ProdutoVO;
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

public class ConsultarProdutosController implements Initializable {

    private FiltrosProdutos filtrosProdutos;
    private SessionBeanProduto sessionBeanProduto;
    private SessionBeanCategoria sessionBeanCategoria;
    private List<ProdutoVO> produtos = new ArrayList<>();
    private List<CategoriaVO> categorias = new ArrayList<>();

    private UsuarioVO usuario;

    @FXML
    private TextField txtIdProduto;

    @FXML
    private TextField txtNomeProduto;

    @FXML
    private ChoiceBox<TipoProduto> cbxTipo = new ChoiceBox<>();

    @FXML
    private ChoiceBox<CategoriaVO> cbxCategoria = new ChoiceBox<>();

    @FXML
    private DatePicker dateCadastro;

    @FXML
    private ChoiceBox<AtivoInativo> cbxAtivo = new ChoiceBox<>();

    @FXML
    private TableView<ProdutoVO> tableProdutos = new TableView<>();

    @FXML
    private Button btnNovoProduto;

    @FXML
    private Button btnAlterarProduto;

    @FXML
    private Button btnExcluirProduto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!usuario.getCargo().getPermissoes().isCadastraProduto()) {
            btnNovoProduto.setDisable(true);
        }
        if (!usuario.getCargo().getPermissoes().isAlteraProduto()) {
            btnAlterarProduto.setDisable(true);
            btnExcluirProduto.setDisable(true);
        }

        categorias = sessionBeanCategoria.recuperarTodasCategorias();

        cbxTipo.setItems(FXCollections.observableArrayList(TipoProduto.values()));
        cbxCategoria.setItems(FXCollections.observableArrayList(categorias));
    }

    @FXML
    public void pesquisar() {
        populaFiltros();
        produtos = sessionBeanProduto.recuperarProdutosPorFiltros(filtrosProdutos);
        tableProdutos.setItems(FXCollections.observableArrayList(produtos));
        tableProdutos.setEditable(false);
    }

    @FXML
    public void novoProduto() {
        //TODO: abre formCadastroProduto
    }

    @FXML
    public void alterarProduto() {
        //TODO: abre formProduto
    }

    public void populaFiltros() {
        filtrosProdutos = new FiltrosProdutos();

        if (!Utils.isNullOrEmpty(txtIdProduto.getText())) {
            filtrosProdutos.setId(Long.parseLong(txtIdProduto.getText()));
        }

        if (!Utils.isNullOrEmpty(txtNomeProduto.getText())) {
            filtrosProdutos.setNome(txtNomeProduto.getText());
        }

        if (cbxTipo != null) {
            filtrosProdutos.setTipo(cbxTipo.getValue());
        }

        if (cbxCategoria != null) {
            filtrosProdutos.setCategoria(cbxCategoria.getValue());
        }

        if (dateCadastro != null) {
            filtrosProdutos.setDataCadastro(dateCadastro.getValue().toString());
        }

        if (cbxAtivo != null) {
            filtrosProdutos.setAtivo(cbxAtivo.getValue().isStatus() ? "S" : "N");
        }
    }
}
