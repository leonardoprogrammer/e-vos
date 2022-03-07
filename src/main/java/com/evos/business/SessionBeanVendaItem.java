package com.evos.business;

import com.evos.model.dao.VendaItemDAO;
import com.evos.model.entity.Produto;
import com.evos.model.entity.VendaItem;
import com.evos.model.vo.ProdutoVO;
import com.evos.model.vo.VendaItemVO;
import com.evos.model.vo.VendaVO;
import com.evos.util.Exception.EvosException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class SessionBeanVendaItem {

    private VendaItemDAO vendaItemDAO;
    private SessionBeanProduto sessionBeanProduto;

    public void registrarItemVenda(VendaItemVO item) throws EvosException {
        vendaItemDAO.registrarItemVenda(item);
    }

    public void deletarItensVenda(VendaVO venda) throws EvosException {
        vendaItemDAO.deletarItensVenda(venda.getId());
    }

    public List<VendaItemVO> recuperarTodosItens() throws EvosException {
        List<VendaItem> itens = vendaItemDAO.recuperarItens();
        List<VendaItemVO> itensVO = new ArrayList<VendaItemVO>();

        if (itens != null) {
            for (VendaItem item : itens) {
                ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(item.getIdProduto());
                itensVO.add(preencherVO(item, produtoVO));
            }
            return itensVO;
        }
        return null;
    }

    public List<VendaItemVO> recuperarItensPorVenda(long idVenda) throws EvosException {
        List<VendaItem> itens = vendaItemDAO.recuperarItensPorVenda(idVenda);
        List<VendaItemVO> itensVO = new ArrayList<VendaItemVO>();

        if (itens != null) {
            for (VendaItem item : itens) {
                ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(item.getIdProduto());
                itensVO.add(preencherVO(item, produtoVO));
            }
            return itensVO;
        }
        return null;
    }

    public VendaItemVO recuperarItemVendaPorId(long id) throws EvosException {
        VendaItem item = vendaItemDAO.recuperarItemPorId(id);

        if (item != null) {
            ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(item.getIdProduto());
            return preencherVO(item, produtoVO);
        }
        return null;
    }

    public VendaItemVO preencherVO(VendaItem item, ProdutoVO produtoVO) {
        VendaItemVO itemVO = new VendaItemVO();
        itemVO.setId(item.getId());
        itemVO.setIdVenda(item.getIdVenda());
        itemVO.setSequencial(item.getSequencial());
        if (produtoVO != null) {
            itemVO.setProduto(produtoVO);
        }
        itemVO.setValorUnidade(item.getValorUnidade());
        itemVO.setDescontoProduto(item.getDescontoProduto());
        itemVO.setValorItem(item.getValorItem());
        itemVO.setQuantidade(item.getQuantidade());
        return itemVO;
    }
}
