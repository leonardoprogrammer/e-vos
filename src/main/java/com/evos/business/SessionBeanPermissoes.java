package com.evos.business;

import com.evos.enums.TipoProduto;
import com.evos.model.dao.ProdutoDAO;
import com.evos.model.entity.Categoria;
import com.evos.model.entity.Produto;
import com.evos.model.vo.CategoriaVO;
import com.evos.model.vo.ProdutoVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SessionBeanPermissoes {

    private ProdutoDAO produtoDAO;
    private SessionBeanCategoria sessionBeanCategoria;

    public void cadastrarProduto(ProdutoVO produto, UsuarioVO userLogado) {
        produto.setDtaInc(Calendar.getInstance().toString());
        produto.setLoginInc(userLogado.getNome());
        produtoDAO.cadastrarProduto(produto);
    }

    public void alterarProduto(ProdutoVO produto, UsuarioVO userLogado) {
        produto.setDtaAlt(Calendar.getInstance().toString());
        produto.setLoginAlt(userLogado.getNome());
        produtoDAO.alterarProduto(produto);
    }

    public void deletarProduto(ProdutoVO produto) {
        produtoDAO.deletarProduto(produto);
    }

    public List<ProdutoVO> recuperarTodosProdutos() {
        List<Produto> produtos = produtoDAO.recuperarProdutos();
        List<ProdutoVO> produtosVO = new ArrayList<ProdutoVO>();

        if (produtos != null) {
            for (Produto produto : produtos) {
                CategoriaVO categoria = sessionBeanCategoria.recuperarCategoriaPorId(produto.getIdCategoria());
                produtosVO.add(preencherVO(produto, categoria));
            }
            return produtosVO;
        }
        return null;
    }

    public ProdutoVO recuperarProdutoPorId(long id) {
        Produto produto = produtoDAO.recuperarProdutoPorId(id);

        if (produto != null) {
            CategoriaVO categoria = sessionBeanCategoria.recuperarCategoriaPorId(produto.getIdCategoria());
            return preencherVO(produto, categoria);
        }
        return null;
    }

    public ProdutoVO preencherVO(Produto produto, CategoriaVO categoria) {
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setId(produto.getId());
        produtoVO.setNome(produto.getNome());
        if (!Utils.isNullOrZero(produto.getTipoProduto())) {
            produtoVO.setTipoProduto(TipoProduto.get(produto.getTipoProduto()));
        }
        if (categoria != null) {
            produtoVO.setCategoria(categoria);
        }
        produtoVO.setValor(produto.getValor());
        produtoVO.setAtivo(produto.getAtivo().equals("S") ? true : false);
        produtoVO.setDtaInc(produto.getDtaInc());
        produtoVO.setLoginInc(produto.getLoginInc());
        produtoVO.setDtaAlt(produto.getLoginAlt());
        produtoVO.setLoginAlt(produto.getLoginAlt());
        return produtoVO;
    }
}
