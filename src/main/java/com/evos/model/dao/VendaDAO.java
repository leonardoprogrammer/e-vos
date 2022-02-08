package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.vo.VendaVO;

public class VendaDAO {

    public void registrarVenda(VendaVO venda) {
        StringBuilder query = new StringBuilder("INSERT INTO VENDA");
        query.append("(id_produto, id_vendedor, id_cliente, data_compra, tipo_venda, forma_pagamento, ");
        query.append("gerou_nfs, observacao, dta_inc, login_inc, dta_alt, login_alt)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setLong(1, venda.getProduto().getId());
            // continuar passando valores

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

}
