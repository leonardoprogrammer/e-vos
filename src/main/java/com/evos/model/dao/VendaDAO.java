package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Venda;
import com.evos.model.vo.FiltroVendaVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.model.vo.VendaVO;
import com.evos.util.Exception.EvosException;
import com.evos.util.Utils;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class VendaDAO {

    public void registrarVenda(VendaVO venda) throws EvosException {
        StringBuilder query = new StringBuilder("INSERT INTO VENDA");
        query.append("(id_produto, id_vendedor, id_cliente, valor_total, valor_desconto, qtd_itens, data_compra,");
        query.append(" tipo_venda, forma_pagamento, gerou_nfs, observacao, cancelada, data_cancela, dta_inc, login_inc)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setLong(1, venda.getProduto().getId());
            pstm.setLong(2, venda.getVendedor().getId());
            pstm.setLong(3, venda.getCliente().getId());
            pstm.setDouble(4, venda.getValorTotal());
            pstm.setDouble(5, venda.getValorDesconto());
            pstm.setInt(6, venda.getQtdItens());
            pstm.setDate(7, (Date) venda.getDataCompra().getTime());
            pstm.setInt(8, venda.getTipoVenda().getId());
            pstm.setInt(9, venda.getFormaPagamento().getId());
            pstm.setString(10, venda.isGerouNotaFiscal() ? "S" : "N");
            pstm.setString(11, venda.getObservacao());
            pstm.setString(12, "N");
            pstm.setString(13, "N");
            pstm.setDate(14, null);
            pstm.setString(15, venda.getDtaInc());
            pstm.setString(16, venda.getLoginInc());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao registrar venda!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void alterarVenda(VendaVO venda) throws EvosException {
        StringBuilder query = new StringBuilder("UPDATE VENDA SET");
        query.append(" id_produto = ?, id_vendedor = ?, id_cliente = ?, valor_total = ?, valor_desconto = ?, qtd_itens = ?, data_compra = ?, tipo_venda = ?,");
        query.append("  forma_pagamento = ?, gerou_nfs = ?, observacao = ?, cancelada = ?, data_cancela = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setLong(1, venda.getProduto().getId());
            pstm.setLong(2, venda.getVendedor().getId());
            pstm.setLong(3, venda.getCliente().getId());
            pstm.setDouble(4, venda.getValorTotal());
            pstm.setDouble(5, venda.getValorDesconto());
            pstm.setInt(6, venda.getQtdItens());
            pstm.setDate(7,(Date) venda.getDataCompra().getTime());
            pstm.setInt(8, venda.getTipoVenda().getId());
            pstm.setInt(9, venda.getFormaPagamento().getId());
            pstm.setString(10, venda.isGerouNotaFiscal() ? "S" : "N");
            pstm.setString(11, venda.getObservacao());
            pstm.setString(12, venda.isCancelada() ? "S" : "N");
            pstm.setDate(13, (Date) venda.getDataCancela().getTime());
            pstm.setString(14, venda.getDtaAlt());
            pstm.setString(15, venda.getLoginAlt());
            pstm.setLong(16, venda.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao alterar venda!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelarVenda(VendaVO venda) throws EvosException {
        StringBuilder query = new StringBuilder("UPDATE VENDA SET");
        query.append(" cancelada = ?, data_cancela = ?, observacao = ?,");
        query.append(" dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, "S");
            pstm.setDate(2, (Date) venda.getDataCancela().getTime());
            pstm.setString(3, venda.getObservacao());
            pstm.setString(4, venda.getDtaAlt());
            pstm.setString(5, venda.getLoginAlt());
            pstm.setLong(6, venda.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao cancelar venda!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletarVenda(long id) throws EvosException {
        String query = "DELETE FROM VENDA WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao deletar venda!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Venda> recuperarVendas() throws EvosException {
        String query = "SELECT * FROM VENDA";
        List<Venda> vendas = new ArrayList<Venda>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getLong("id"));
                venda.setIdProduto(rs.getLong("id_produto"));
                venda.setIdVendedor(rs.getLong("id_vendedor"));
                venda.setIdCliente(rs.getLong("id_cliente"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setValorDesconto(rs.getDouble("valor_desconto"));
                venda.setQtdItens(rs.getInt("qtd_itens"));
                venda.getDataCompra().setTime(rs.getDate("data_compra"));
                venda.setTipoVenda(rs.getInt("tipo_venda"));
                venda.setFormaPagamento(rs.getInt("forma_pagamento"));
                venda.setGerouNotaFiscal(rs.getString("gerou_nfs"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setCancelada(rs.getString("cancelada"));
                venda.getDataCancela().setTime(rs.getDate("data_cancela"));
                venda.setDtaInc(rs.getString("dta_inc"));
                venda.setLoginInc(rs.getString("login_inc"));
                venda.setDtaAlt(rs.getString("dta_alt"));
                venda.setLoginAlt(rs.getString("login_alt"));

                vendas.add(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar vendas!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vendas;
    }

    public Venda recuperarVendaPorId(long id) throws EvosException {
        String query = "SELECT * FROM VENDA WHERE id = ?";
        Venda venda = new Venda();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                venda = new Venda();
                venda.setId(rs.getLong("id"));
                venda.setIdProduto(rs.getLong("id_produto"));
                venda.setIdVendedor(rs.getLong("id_vendedor"));
                venda.setIdCliente(rs.getLong("id_cliente"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setValorDesconto(rs.getDouble("valor_desconto"));
                venda.setQtdItens(rs.getInt("qtd_itens"));
                venda.getDataCompra().setTime(rs.getDate("data_compra"));
                venda.setTipoVenda(rs.getInt("tipo_venda"));
                venda.setFormaPagamento(rs.getInt("forma_pagamento"));
                venda.setGerouNotaFiscal(rs.getString("gerou_nfs"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setCancelada(rs.getString("cancelada"));
                venda.getDataCancela().setTime(rs.getDate("data_cancela"));
                venda.setDtaInc(rs.getString("dta_inc"));
                venda.setLoginInc(rs.getString("login_inc"));
                venda.setDtaAlt(rs.getString("dta_alt"));
                venda.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar venda!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return venda;
    }

    public List<Venda> recuperarVendasPorFiltro(FiltroVendaVO filtroVenda) throws EvosException {
        StringBuilder query = new StringBuilder("SELECT * FROM VENDA");
        int count = 0;

        if (Utils.isNullOrZero(filtroVenda.getId())) {
            query.append(" WHERE id = ?");
        } else {
            query.append(" WHERE id IS NOT NULL ");
        }

        if (Utils.isNullOrZero(filtroVenda.getProduto().getId())) {
            query.append(" AND id_produto = ?");
        }
        if (Utils.isNullOrZero(filtroVenda.getVendedor().getId())) {
            query.append(" AND id_vendedor = ?");
        }
        if (Utils.isNullOrZero(filtroVenda.getCliente().getId())) {
            query.append(" AND id_cliente = ?");
        }
        if (Utils.isNullOrEmpty(filtroVenda.getDataCompra().toString())) {
            query.append(" AND data_compra = ?");
        }
        if (Utils.isNullOrZero(filtroVenda.getTipoVenda().getId())) {
            query.append(" AND tipo_venda = ?");
        }
        if (Utils.isNullOrZero(filtroVenda.getFormaPagamento().getId())) {
            query.append(" AND forma_pagamento = ?");
        }
        if (filtroVenda.isGerouNotaFiscal()) {
            query.append(" AND gerou_nfs = ?");
        }
        if (filtroVenda.isCancelada()) {
            query.append(" AND cancelada = ?");
        }
        if (Utils.isNullOrEmpty(filtroVenda.getDtaInc())) {
            query.append(" AND dta_inc = ?");
        }

        List<Venda> vendas = new ArrayList<Venda>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            if (Utils.isNullOrZero(filtroVenda.getId())) {
                pstm.setLong(count++, filtroVenda.getId());
            }
            if (Utils.isNullOrZero(filtroVenda.getProduto().getId())) {
                pstm.setLong(count++, filtroVenda.getProduto().getId());
            }
            if (Utils.isNullOrZero(filtroVenda.getVendedor().getId())) {
                pstm.setLong(count++, filtroVenda.getVendedor().getId());
            }
            if (Utils.isNullOrZero(filtroVenda.getCliente().getId())) {
                pstm.setLong(count++, filtroVenda.getCliente().getId());
            }
            if (Utils.isNullOrEmpty(filtroVenda.getDataCompra().toString())) {
                pstm.setDate(count++, (Date) filtroVenda.getDataCompra().getTime());
            }
            if (Utils.isNullOrZero(filtroVenda.getTipoVenda().getId())) {
                pstm.setInt(count++, filtroVenda.getTipoVenda().getId());
            }
            if (Utils.isNullOrZero(filtroVenda.getFormaPagamento().getId())) {
                pstm.setInt(count++, filtroVenda.getFormaPagamento().getId());
            }
            if (filtroVenda.isGerouNotaFiscal()) {
                pstm.setString(count++, "S");
            }
            if (filtroVenda.isCancelada()) {
                pstm.setString(count++, "S");
            }
            if (Utils.isNullOrEmpty(filtroVenda.getDtaInc())) {
                pstm.setString(count++, filtroVenda.getDtaInc());
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getLong("id"));
                venda.setIdProduto(rs.getLong("id_produto"));
                venda.setIdVendedor(rs.getLong("id_vendedor"));
                venda.setIdCliente(rs.getLong("id_cliente"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setValorDesconto(rs.getDouble("valor_desconto"));
                venda.setQtdItens(rs.getInt("qtd_itens"));
                venda.getDataCompra().setTime(rs.getDate("data_compra"));
                venda.setTipoVenda(rs.getInt("tipo_venda"));
                venda.setFormaPagamento(rs.getInt("forma_pagamento"));
                venda.setGerouNotaFiscal(rs.getString("gerou_nfs"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setCancelada(rs.getString("cancelada"));
                venda.getDataCancela().setTime(rs.getDate("data_cancela"));
                venda.setDtaInc(rs.getString("dta_inc"));
                venda.setLoginInc(rs.getString("login_inc"));
                venda.setDtaAlt(rs.getString("dta_alt"));
                venda.setLoginAlt(rs.getString("login_alt"));

                vendas.add(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar vendas por filtro!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vendas;
    }

}
