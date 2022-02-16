package com.evos.business;

import com.evos.enums.FormaPagamento;
import com.evos.enums.TipoVenda;
import com.evos.model.dao.VendaDAO;
import com.evos.model.entity.Venda;
import com.evos.model.vo.*;
import com.evos.util.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SessionBeanVenda {

    private VendaDAO vendaDAO;
    private SessionBeanProduto sessionBeanProduto;
    private SessionBeanUsuario sessionBeanUsuario;
    private SessionBeanCliente sessionBeanCliente;

    public void registrarVenda(VendaVO venda, UsuarioVO userLogado) {
        venda.setLoginInc(userLogado.getNome());
        venda.setDtaInc(Calendar.getInstance().toString());
        vendaDAO.registrarVenda(venda);
    }

    public void alterarVenda(VendaVO venda, UsuarioVO userLogado) {
        venda.setLoginAlt(userLogado.getNome());
        venda.setDtaAlt(Calendar.getInstance().toString());
        vendaDAO.alterarVenda(venda);
    }

    public void cancelarVenda(VendaVO venda, UsuarioVO userLogado) {
        vendaDAO.cancelarVenda(venda.getId(), venda.isProdDevolvido(), venda.getObservacao(), userLogado);
    }

    public void deletarVenda(VendaVO venda) {
        vendaDAO.deletarVenda(venda.getId());
    }

    public List<VendaVO> recuperarTodasVendas() {
        List<Venda> vendas = vendaDAO.recuperarVendas();
        List<VendaVO> vendasVO = new ArrayList<VendaVO>();

        if (vendas != null) {
            for (Venda venda : vendas) {
                ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(venda.getIdProduto());
                UsuarioVO vendedorVO = sessionBeanUsuario.recuperarUsuarioPorId(venda.getIdVendedor());
                ClienteVO clienteVO = sessionBeanCliente.recuperarClientePorId(venda.getIdCliente());
                vendasVO.add(preencherVO(venda, produtoVO, vendedorVO, clienteVO));
            }
            return vendasVO;
        }
        return null;
    }

    public VendaVO recuperarVendaPorId(long id) {
        Venda venda = vendaDAO.recuperarVendaPorId(id);

        if (venda != null) {
            ProdutoVO produtoVO = sessionBeanProduto.recuperarProdutoPorId(venda.getIdProduto());
            UsuarioVO vendedorVO = sessionBeanUsuario.recuperarUsuarioPorId(venda.getIdVendedor());
            ClienteVO clienteVO = sessionBeanCliente.recuperarClientePorId(venda.getIdCliente());
            return preencherVO(venda, produtoVO, vendedorVO, clienteVO);
        }
        return null;
    }

    public List<VendaVO> recuperarVendasPorFiltro(FiltroVendaVO filtroVendaVO) {
        // TODO: Terminar
    }

    public VendaVO preencherVO(Venda venda, ProdutoVO produtoVO, UsuarioVO vendedor, ClienteVO clienteVO) {
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
        vendaVO.setProdDevolvido(venda.getProdDevolvido().equals("S") ? true : false);
        vendaVO.setDataCancela(venda.getDataCancela());
        vendaVO.setDtaInc(venda.getDtaInc());
        vendaVO.setLoginInc(venda.getLoginInc());
        vendaVO.setDtaAlt(venda.getDtaAlt());
        vendaVO.setLoginAlt(venda.getLoginAlt());
        return vendaVO;
    }
}
