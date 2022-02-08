package com.evos.controller;

import com.evos.model.vo.CategoriaVO;
import com.evos.model.vo.ClienteVO;
import com.evos.model.vo.ProdutoVO;
import com.evos.model.vo.UsuarioVO;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    private ProdutoVO cadProduto;
    private ClienteVO cadCliente;
    private CategoriaVO cadCategoria;
    private UsuarioVO cadUsuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cadProduto = new ProdutoVO();
        cadCliente = new ClienteVO();
        cadCategoria = new CategoriaVO();
        cadUsuario = new UsuarioVO();
    }
}
