package com.evos.controller;

import com.evos.business.SessionBeanProduto;
import com.evos.business.SessionBeanVenda;
import com.evos.enums.FormaPagamento;
import com.evos.enums.TipoVenda;
import com.evos.filtro.FiltrosVendas;
import com.evos.model.vo.ProdutoVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.model.vo.VendaVO;
import com.evos.util.Utils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConsultarVendasController implements Initializable {

    private FiltrosVendas filtrosVendas;
    private SessionBeanVenda sessionBeanVenda;
    private SessionBeanProduto sessionBeanProduto;
    private List<VendaVO> vendas = new ArrayList<>();
    private List<ProdutoVO> produtos = new ArrayList<>();

    private UsuarioVO usuario;

    @FXML
    private TextField txtIdVenda;

    @FXML
    private ChoiceBox<ProdutoVO> cbxProduto = new ChoiceBox<>();

    @FXML
    private CheckBox checkComDesconto;

    @FXML
    private DatePicker dateCompra;

    @FXML
    private ChoiceBox<TipoVenda> cbxTipoVenda = new ChoiceBox<>();

    @FXML
    private ChoiceBox<FormaPagamento> cbxPagamento = new ChoiceBox<>();

    @FXML
    private CheckBox checkGerouNotaFiscal;

    @FXML
    private CheckBox checkCancelada;

    @FXML
    private Button btnNovaVenda;

    @FXML
    private Button btnAlterarVenda;

    @FXML
    private Button btnExcluirVenda;

    @FXML
    private TableView<VendaVO> tableVendas = new TableView<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!usuario.getCargo().getPermissoes().isRegistraVenda()) {
            btnNovaVenda.setDisable(true);
        }
        if (!usuario.getCargo().getPermissoes().isAlteraVenda()) {
            btnAlterarVenda.setDisable(true);
            btnExcluirVenda.setDisable(true);
        }

        produtos = sessionBeanProduto.recuperarTodosProdutos();

        cbxProduto.setItems(FXCollections.observableArrayList(produtos));
        cbxTipoVenda.setItems(FXCollections.observableArrayList(TipoVenda.values()));
        cbxPagamento.setItems(FXCollections.observableArrayList(FormaPagamento.values()));
    }

    @FXML
    public void pesquisar() {
        populaFiltros();
        vendas = sessionBeanVenda.recuperarVendasPorFiltro(filtrosVendas);
        tableVendas.setItems(FXCollections.observableArrayList(vendas));
        tableVendas.setEditable(false);
    }

    @FXML
    public void novaVenda() {
        //TODO: abre formVenda
    }

    @FXML
    public void alterarVenda() {
        //TODO: abre formAlterarVenda
    }

    @FXML
    public void excluirVenda() {
        //abre dialog para confirmação
        //informa que a exclusão da venda será registrado no relatório de ações
    }

    public void populaFiltros() {
        filtrosVendas = new FiltrosVendas();

        if (!Utils.isNullOrEmpty(txtIdVenda.getText())) {
            filtrosVendas.setId(Long.parseLong(txtIdVenda.getText()));
        }

        if (cbxProduto != null) {
            filtrosVendas.setProduto(cbxProduto.getValue());
        }

        if (checkComDesconto.isSelected()) {
            filtrosVendas.setComDesonto("S");
        }

        if (dateCompra != null) {
            filtrosVendas.setDataCompra(dateCompra.getValue().toString());
        }

        if (cbxTipoVenda != null) {
            filtrosVendas.setTipoVenda(cbxTipoVenda.getValue());
        }

        if (cbxPagamento != null) {
            filtrosVendas.setFormaPagamento(cbxPagamento.getValue());
        }

        if (checkGerouNotaFiscal.isSelected()) {
            filtrosVendas.setGerouNotaFiscal("S");
        }

        if (checkCancelada.isSelected()) {
            filtrosVendas.setFoiCancelada("S");
        }
    }
}
