package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.VendaItem;
import com.evos.model.vo.VendaItemVO;
import com.evos.util.Exception.EvosException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class VendaItemDAO {

    public void registrarItemVenda(VendaItemVO item) throws EvosException {
        StringBuilder query = new StringBuilder("INSERT INTO VENDAITEM");
        query.append("(id_venda, sequencial, id_produto, valor_unidade, desconto_produto, valor_item, quantidade)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setLong(1, item.getIdVenda());
            pstm.setLong(2, item.getSequencial());
            pstm.setLong(3, item.getProduto().getId());
            pstm.setDouble(4, item.getValorUnidade());
            pstm.setDouble(5, item.getDescontoProduto());
            pstm.setDouble(6, item.getValorItem());
            pstm.setInt(7, item.getQuantidade());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao registar um item da venda!", e.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletarItensVenda(long idVenda) throws EvosException {
        String query = "DELETE FROM VENDAITEM WHERE id_venda = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, idVenda);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao deletar itens da venda!", e.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<VendaItem> recuperarItens() throws EvosException {
        String query = "SELECT * FROM VENDAITEM";
        List<VendaItem> itens = new ArrayList<VendaItem>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

         try {
             conn = ConnectionFactory.createConnectionToMySql();
             pstm = conn.prepareStatement(query);
             rs = pstm.executeQuery();

             while (rs.next()) {
                 VendaItem item = new VendaItem();

                 item.setId(rs.getLong("id"));
                 item.setIdVenda(rs.getLong("id_venda"));
                 item.setSequencial(rs.getLong("sequencial"));
                 item.setIdProduto(rs.getLong("id_produto"));
                 item.setValorUnidade(rs.getDouble("valor_unidade"));
                 item.setDescontoProduto(rs.getDouble("desconto_produto"));
                 item.setValorItem(rs.getDouble("valor_item"));
                 item.setQuantidade(rs.getInt("quantidade"));

                 itens.add(item);
             }
         } catch (Exception e) {
             e.printStackTrace();
             throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar itens!", e.toString());
         } finally {
             try {
                 if (conn != null) {
                     conn.close();
                 }

                 if (pstm != null) {
                     pstm.close();
                 }

                 if (rs != null) {
                     rs.close();
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         return itens;
    }

    public List<VendaItem> recuperarItensPorVenda(long idVenda) {
        String query = "SELET * FROM VENDAITEM WHERE id_venda = ?";
        List<VendaItem> itens = new ArrayList<VendaItem>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, idVenda);

            rs = pstm.executeQuery();

            while (rs.next()) {
                VendaItem item = new VendaItem();

                item.setId(rs.getLong("id"));
                item.setIdVenda(rs.getLong("id_venda"));
                item.setSequencial(rs.getLong("sequencial"));
                item.setIdProduto(rs.getLong("id_produto"));
                item.setValorUnidade(rs.getDouble("valor_unidade"));
                item.setDescontoProduto(rs.getDouble("desconto_produto"));
                item.setValorItem(rs.getDouble("valor_item"));
                item.setQuantidade(rs.getInt("quantidade"));

                itens.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar item da venda!", e.toString());
            } catch (EvosException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return itens;
    }

    public VendaItem recuperarItemPorId(long id) throws EvosException {
        String query = "SELET * FROM VENDAITEM WHERE id = ?";
        VendaItem item = new VendaItem();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                item = new VendaItem();
                item.setId(rs.getLong("id"));
                item.setIdVenda(rs.getLong("id_venda"));
                item.setSequencial(rs.getLong("sequencial"));
                item.setIdProduto(rs.getLong("id_produto"));
                item.setValorUnidade(rs.getDouble("valor_unidade"));
                item.setDescontoProduto(rs.getDouble("desconto_produto"));
                item.setValorItem(rs.getDouble("valor_item"));
                item.setQuantidade(rs.getInt("quantidade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar item da venda!", e.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return item;
    }
}
