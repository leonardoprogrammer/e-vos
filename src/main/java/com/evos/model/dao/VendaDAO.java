package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Venda;
import com.evos.model.vo.FiltroVendaVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.model.vo.VendaVO;
import com.evos.util.Utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VendaDAO {

    public void registrarVenda(VendaVO venda) {
        StringBuilder query = new StringBuilder("INSERT INTO VENDA");
        query.append("(id_produto, id_vendedor, id_cliente, data_compra, tipo_venda, forma_pagamento,");
        query.append(" gerou_nfs, observacao, cancelada, prod_devolvido, data_cancela, dta_inc, login_inc)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

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
            pstm.setDate(4, (Date) venda.getDataCompra().getTime());
            pstm.setInt(5, venda.getTipoVenda().getId());
            pstm.setInt(6, venda.getFormaPagamento().getId());
            pstm.setString(7, venda.isGerouNotaFiscal() ? "S" : "N");
            pstm.setString(8, venda.getObservacao());
            pstm.setString(9, "N");
            pstm.setString(10, "N");
            pstm.setDate(11, null);
            pstm.setString(12, venda.getDtaInc());
            pstm.setString(13, venda.getLoginInc());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
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

    public void alterarVenda(VendaVO venda) {
        StringBuilder query = new StringBuilder("UPDATE VENDA SET");
        query.append(" id_produto = ?, id_vendedor = ?, id_cliente = ?, data_compra = ?, tipo_venda = ?, forma_pagamento = ?,");
        query.append(" gerou_nfs = ?, observacao = ?, cancelada = ?, prod_devolvido = ?, data_cancela = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setLong(1, venda.getProduto().getId());
            pstm.setLong(2, venda.getVendedor().getId());
            pstm.setLong(3, venda.getCliente().getId());
            pstm.setDate(4, (Date) venda.getDataCompra().getTime());
            pstm.setInt(5, venda.getTipoVenda().getId());
            pstm.setInt(6, venda.getFormaPagamento().getId());
            pstm.setString(7, venda.isGerouNotaFiscal() ? "S" : "N");
            pstm.setString(8, venda.getObservacao());
            pstm.setString(9, venda.isCancelada() ? "S" : "N");
            pstm.setString(10, venda.isProdDevolvido() ? "S" : "N");
            pstm.setDate(11, (Date) venda.getDataCancela().getTime());
            pstm.setString(12, venda.getDtaAlt());
            pstm.setString(13, venda.getLoginAlt());
            pstm.setLong(14, venda.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
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

    public void cancelarVenda(long id, boolean prodDevolvido, String observacao, UsuarioVO userLogado) {
        StringBuilder query = new StringBuilder("UPDATE VENDA SET");
        query.append(" cancelada = ?, prod_devolvido, data_cancela = ?,");
        query.append(" dta_alt = ?, login_alt = ?");
        if (Utils.isNullOrEmpty(observacao)) {
            query.append(", observacao = ?");
        }
        query.append(" WHERE id = ?");

        int count = 0;
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(count++, "S");
            pstm.setString(count++, prodDevolvido ? "S" : "N");
            pstm.setDate(count++, (Date) Calendar.getInstance().getTime());
            pstm.setString(count++, Calendar.getInstance().toString());
            pstm.setString(count++, userLogado.getNome());
            if (Utils.isNullOrEmpty(observacao)) {
                pstm.setString(count++, observacao);
            }
            pstm.setLong(count++, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
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

    public void deletarVenda(long id) {
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

    public List<Venda> recuperarVendas() {
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
                venda.getDataCompra().setTime(rs.getDate("data_compra"));
                venda.setTipoVenda(rs.getInt("tipo_venda"));
                venda.setFormaPagamento(rs.getInt("forma_pagamento"));
                venda.setGerouNotaFiscal(rs.getString("gerou_nfs"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setCancelada(rs.getString("cancelada"));
                venda.setProdDevolvido(rs.getString("prod_devolvido"));
                venda.getDataCancela().setTime(rs.getDate("data_cancela"));
                venda.setDtaInc(rs.getString("dta_inc"));
                venda.setLoginInc(rs.getString("login_inc"));
                venda.setDtaAlt(rs.getString("dta_alt"));
                venda.setLoginAlt(rs.getString("login_alt"));

                vendas.add(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public Venda recuperarVendaPorId(long id) {
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
                venda.getDataCompra().setTime(rs.getDate("data_compra"));
                venda.setTipoVenda(rs.getInt("tipo_venda"));
                venda.setFormaPagamento(rs.getInt("forma_pagamento"));
                venda.setGerouNotaFiscal(rs.getString("gerou_nfs"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setCancelada(rs.getString("cancelada"));
                venda.setProdDevolvido(rs.getString("prod_devolvido"));
                venda.getDataCancela().setTime(rs.getDate("data_cancela"));
                venda.setDtaInc(rs.getString("dta_inc"));
                venda.setLoginInc(rs.getString("login_inc"));
                venda.setDtaAlt(rs.getString("dta_alt"));
                venda.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public List<Venda> recuperarVendasPorFiltro(FiltroVendaVO filtroVenda) {
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
        if (filtroVenda.isProdDevolvido()) {
            query.append(" AND prod_devolvido = ?");
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
            if (filtroVenda.isProdDevolvido()) {
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
                venda.getDataCompra().setTime(rs.getDate("data_compra"));
                venda.setTipoVenda(rs.getInt("tipo_venda"));
                venda.setFormaPagamento(rs.getInt("forma_pagamento"));
                venda.setGerouNotaFiscal(rs.getString("gerou_nfs"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setCancelada(rs.getString("cancelada"));
                venda.setProdDevolvido(rs.getString("prod_devolvido"));
                venda.getDataCancela().setTime(rs.getDate("data_cancela"));
                venda.setDtaInc(rs.getString("dta_inc"));
                venda.setLoginInc(rs.getString("login_inc"));
                venda.setDtaAlt(rs.getString("dta_alt"));
                venda.setLoginAlt(rs.getString("login_alt"));

                vendas.add(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
