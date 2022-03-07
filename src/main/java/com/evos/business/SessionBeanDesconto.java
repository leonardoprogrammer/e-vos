package com.evos.business;

import com.evos.enums.TipoDesconto;
import com.evos.model.dao.DescontoDAO;
import com.evos.model.entity.DescontoCompra;
import com.evos.model.entity.DescontoProduto;
import com.evos.model.entity.Produto;
import com.evos.model.vo.DescontoCompraVO;
import com.evos.model.vo.DescontoProdutoVO;
import com.evos.model.vo.ProdutoVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Exception.EvosException;
import com.evos.util.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class SessionBeanDesconto {

    private DescontoDAO descontoDAO;
    private SessionBeanProduto sessionBeanProduto;

    public void cadastrarDescontoProduto(DescontoProdutoVO descontoProduto, UsuarioVO userLogado) throws EvosException {
        descontoProduto.setLoginInc(userLogado.getNome());
        descontoProduto.setDtaInc(Calendar.getInstance().toString());
        descontoDAO.cadastrarDescontoProduto(descontoProduto);
    }

    public void cadastrarDescontoCompra(DescontoCompraVO descontoCompra, UsuarioVO userLogado) throws EvosException {
        descontoCompra.setLoginInc(userLogado.getNome());
        descontoCompra.setDtaInc(Calendar.getInstance().toString());
        descontoDAO.cadastrarDescontoCompra(descontoCompra);
    }

    public void alterarDescontoProduto(DescontoProdutoVO descontoProduto, UsuarioVO userLogado) throws EvosException {
        descontoProduto.setDtaAlt(Calendar.getInstance().toString());
        descontoProduto.setLoginAlt(userLogado.getNome());
        descontoDAO.alterarDescontoProduto(descontoProduto);
    }

    public void alterarDescontoCompra(DescontoCompraVO descontoCompra, UsuarioVO userLogado) throws EvosException {
        descontoCompra.setDtaAlt(Calendar.getInstance().toString());
        descontoCompra.setLoginAlt(userLogado.getNome());
        descontoDAO.alterarDescontoCompra(descontoCompra);
    }

    public void ativarDesativarDescontoProduto(DescontoProdutoVO descontoProduto, UsuarioVO userLogado, int opcao) throws EvosException {
        descontoProduto.setDtaAlt(Calendar.getInstance().toString());
        descontoProduto.setLoginAlt(userLogado.getNome());
        descontoDAO.ativarDesativarDescontoProduto(descontoProduto, opcao);
    }

    public void ativarDesativarDescontoCompra(DescontoCompraVO descontoCompra, UsuarioVO userLogado, int opcao) throws EvosException {
        descontoCompra.setDtaAlt(Calendar.getInstance().toString());
        descontoCompra.setLoginAlt(userLogado.getNome());
        descontoDAO.ativarDesativarDescontoCompra(descontoCompra, opcao);
    }

    public void deletarDescontoProduto(DescontoProdutoVO descontoProduto) throws EvosException {
        descontoDAO.deletarDescontoProduto(descontoProduto);
    }

    public void deletarDescontoCompra(DescontoCompraVO descontoCompra) throws EvosException {
        descontoDAO.deletarDescontoCompra(descontoCompra);
    }

    public List<DescontoProdutoVO> recuperarTodosDescontosProdutos() throws EvosException {
        List<DescontoProduto> descontos = descontoDAO.recuperarDescontosProduto();
        List<DescontoProdutoVO> descontosVO = new ArrayList<DescontoProdutoVO>();

        if (descontos != null) {
            for (DescontoProduto desconto : descontos) {
                ProdutoVO produto = sessionBeanProduto.recuperarProdutoPorId(desconto.getIdProduto());
                descontosVO.add(preencherVO(desconto, produto));
            }
            return descontosVO;
        }
        return null;
    }

    public List<DescontoCompraVO> recuperarTodosDescontosCompras() throws EvosException {
        List<DescontoCompra> descontos = descontoDAO.recuperarDescontosCompra();
        List<DescontoCompraVO> descontosVO = new ArrayList<DescontoCompraVO>();

        if (descontos != null) {
            for (DescontoCompra desconto : descontos) {
                descontosVO.add(preencherVO(desconto));
            }
            return descontosVO;
        }
        return null;
    }

    public DescontoProdutoVO recuperarDescontoProdutoPorProduto(ProdutoVO produtoVO) throws EvosException {
        DescontoProduto descontoProduto = descontoDAO.recuperarDescontoPorProduto(produtoVO);

        if (descontoProduto != null) {
            return preencherVO(descontoProduto, produtoVO);
        }
        return null;
    }

    public DescontoCompraVO recuperarDescontoCompraPorId(DescontoCompraVO desconto) throws EvosException {
        DescontoCompra descontoCompra = descontoDAO.recuperarDescontoCompraPorId(desconto.getId());

        if (descontoCompra != null) {
            return preencherVO(descontoCompra);
        }
        return null;
    }

    public DescontoProdutoVO preencherVO(DescontoProduto desconto, ProdutoVO produto) {
        DescontoProdutoVO descontoProdutoVO = new DescontoProdutoVO();
        descontoProdutoVO.setId(desconto.getId());
        if (produto != null) {
            descontoProdutoVO.setProduto(produto);
        }
        descontoProdutoVO.setQtdMinima(desconto.getQtdMinima());
        if (!Utils.isNullOrZero(desconto.getTipoDesconto())) {
            descontoProdutoVO.setTipoDesconto(TipoDesconto.get(desconto.getTipoDesconto()));
        }
        descontoProdutoVO.setPorcentagem(desconto.getPorcentagem());
        descontoProdutoVO.setValor(desconto.getValor());
        descontoProdutoVO.setApenasUmDesconto(desconto.getApenasUmDesconto().equals("S") ? true : false);
        descontoProdutoVO.setAtivo(desconto.getAtivo().equals("S") ? true : false);
        descontoProdutoVO.setDtaInc(desconto.getDtaInc());
        descontoProdutoVO.setLoginInc(desconto.getLoginInc());
        descontoProdutoVO.setDtaAlt(desconto.getDtaAlt());
        descontoProdutoVO.setLoginAlt(desconto.getLoginAlt());
        return descontoProdutoVO;
    }

    public DescontoCompraVO preencherVO(DescontoCompra desconto) {
        DescontoCompraVO descontoCompraVO = new DescontoCompraVO();
        descontoCompraVO.setId(desconto.getId());
        descontoCompraVO.setQtdMininaProdutos(desconto.getQtdMininaProduto());
        if (!Utils.isNullOrZero(desconto.getTipoDesconto())) {
            descontoCompraVO.setTipoDesconto(TipoDesconto.get(desconto.getTipoDesconto()));
        }
        descontoCompraVO.setPorcentagem(desconto.getPorcentagem());
        descontoCompraVO.setValor(desconto.getValor());
        descontoCompraVO.setAtivo(desconto.getAtivo().equals("S") ? true : false);
        descontoCompraVO.setDtaInc(desconto.getDtaInc());
        descontoCompraVO.setLoginInc(desconto.getLoginInc());
        descontoCompraVO.setDtaAlt(desconto.getDtaAlt());
        descontoCompraVO.setLoginAlt(desconto.getLoginAlt());
        return descontoCompraVO;
    }
}
