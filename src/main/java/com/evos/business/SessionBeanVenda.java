package com.evos.business;

import com.evos.enums.FormaPagamento;
import com.evos.enums.TipoVenda;
import com.evos.filtro.FiltrosVendas;
import com.evos.model.dao.VendaDAO;
import com.evos.model.entity.Venda;
import com.evos.model.vo.*;
import com.evos.util.Exception.EvosException;
import com.evos.util.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class SessionBeanVenda {

    private VendaDAO vendaDAO;
    private SessionBeanProduto sessionBeanProduto;
    private SessionBeanUsuario sessionBeanUsuario;
    private SessionBeanCliente sessionBeanCliente;
    private SessionBeanVendaItem sessionBeanVendaItem;

    public void registrarVenda(VendaVO venda, UsuarioVO userLogado) throws EvosException {
        venda.setLoginInc(userLogado.getNome());
        venda.setDtaInc(Calendar.getInstance().toString());
        vendaDAO.registrarVenda(venda);
    }

    public void alterarVenda(VendaVO venda, UsuarioVO userLogado) throws EvosException {
        venda.setLoginAlt(userLogado.getNome());
        venda.setDtaAlt(Calendar.getInstance().toString());
        vendaDAO.alterarVenda(venda);
    }

    public void cancelarVenda(VendaVO venda, UsuarioVO userLogado) throws EvosException {
        venda.setLoginAlt(userLogado.getNome());
        vendaDAO.cancelarVenda(venda);
    }

    public void deletarVenda(VendaVO venda) throws EvosException {
        vendaDAO.deletarVenda(venda.getId());
    }

    public List<VendaVO> recuperarTodasVendas() throws EvosException {
        List<Venda> vendas = vendaDAO.recuperarVendas();
        List<VendaVO> vendasVO = new ArrayList<VendaVO>();

        if (vendas != null) {
            for (Venda venda : vendas) {
                ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(venda.getIdProduto());
                UsuarioVO vendedorVO = sessionBeanUsuario.recuperarUsuarioPorId(venda.getIdVendedor());
                ClienteVO clienteVO = sessionBeanCliente.recuperarClientePorId(venda.getIdCliente());
                List<VendaItemVO> itensVO = sessionBeanVendaItem.recuperarItensPorVenda(venda.getId());
                vendasVO.add(preencherVO(venda, produtoVO, vendedorVO, clienteVO, itensVO));
            }
            return vendasVO;
        }
        return null;
    }

    public VendaVO recuperarVendaPorId(long id) throws EvosException {
        Venda venda = vendaDAO.recuperarVendaPorId(id);

        if (venda != null) {
            ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(venda.getIdProduto());
            UsuarioVO vendedorVO = sessionBeanUsuario.recuperarUsuarioPorId(venda.getIdVendedor());
            ClienteVO clienteVO = sessionBeanCliente.recuperarClientePorId(venda.getIdCliente());
            List<VendaItemVO> itensVO = sessionBeanVendaItem.recuperarItensPorVenda(venda.getId());
            return preencherVO(venda, produtoVO, vendedorVO, clienteVO, itensVO);
        }
        return null;
    }

    public List<VendaVO> recuperarVendasPorFiltro(FiltrosVendas filtros) {
        List<Venda> vendas = vendaDAO.recuperarVendasPorFiltro(filtros);
        List<VendaVO> vendasVO = new ArrayList<VendaVO>();

        if (vendas != null) {
            for (Venda venda : vendas) {
                ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(venda.getIdProduto());
                UsuarioVO vendedorVO = sessionBeanUsuario.recuperarUsuarioPorId(venda.getIdVendedor());
                ClienteVO clienteVO = sessionBeanCliente.recuperarClientePorId(venda.getIdCliente());
                List<VendaItemVO> itensVO = sessionBeanVendaItem.recuperarItensPorVenda(venda.getId());
                vendasVO.add(preencherVO(venda, produtoVO, vendedorVO, clienteVO, itensVO));
            }
            return vendasVO;
        }
        return null;
    }

    public VendaVO preencherVO(Venda venda, ProdutoVO produtoVO, UsuarioVO vendedor, ClienteVO clienteVO, List<VendaItemVO> itensVO) {
        VendaVO vendaVO = new VendaVO();
        vendaVO.setId(venda.getId());
        if (produtoVO != null) {
            vendaVO.setProduto(produtoVO);
        }
        if (vendedor != null) {
            vendaVO.setVendedor(vendedor);
        }
        if (clienteVO != null) {
            vendaVO.setCliente(clienteVO);
        }
        if (itensVO != null) {
            vendaVO.setItens(itensVO);
        }
        vendaVO.setValorTotal(venda.getValorTotal());
        vendaVO.setValorDesconto(venda.getValorDesconto());
        vendaVO.setQtdItens(venda.getQtdItens());
        vendaVO.setDataCompra(venda.getDataCompra());
        if (!Utils.isNullOrZero(venda.getTipoVenda())) {
            vendaVO.setTipoVenda(TipoVenda.get(venda.getTipoVenda()));
        }
        if (!Utils.isNullOrZero(venda.getFormaPagamento())) {
            vendaVO.setFormaPagamento(FormaPagamento.get(venda.getFormaPagamento()));
        }
        vendaVO.setGerouNotaFiscal(venda.getGerouNotaFiscal().equals("S") ? true : false);
        vendaVO.setObservacao(venda.getObservacao());
        vendaVO.setCancelada(venda.getCancelada().equals("S") ? true : false);
        vendaVO.setDataCancela(venda.getDataCancela());
        vendaVO.setDtaInc(venda.getDtaInc());
        vendaVO.setLoginInc(venda.getLoginInc());
        vendaVO.setDtaAlt(venda.getDtaAlt());
        vendaVO.setLoginAlt(venda.getLoginAlt());
        return vendaVO;
    }
}
