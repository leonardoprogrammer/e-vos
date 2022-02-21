package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Produto;
import com.evos.model.vo.ProdutoVO;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrarProduto(ProdutoVO produto) {
        StringBuilder query = new StringBuilder("INSERT INTO PRODUTO");
        query.append("(nome, tipo_produto, id_categoria, valor, ativo,");
        query.append(" dta_inc, login_inc, dta_alt, login_alt)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setString(1, produto.getNome());
            pstm.setLong(2, produto.getTipoProduto().getId());
            pstm.setLong(3, produto.getCategoria().getId());
            pstm.setDouble(4, produto.getValor());
            pstm.setString(5, produto.isAtivo() ? "S" : "N");
            pstm.setString(6, produto.getDtaInc());
            pstm.setString(7, produto.getLoginInc());
            pstm.setString(8, produto.getDtaAlt());
            pstm.setString(9, produto.getLoginAlt());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao cadastrar produto!");
            alert.setContentText(e.toString());
            alert.show();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void alterarProduto(ProdutoVO produto) {
        StringBuilder query = new StringBuilder("UPDATE PRODUTO SET");
        query.append(" nome = ?, tipo_produto = ?, id_categoria = ?, valor = ?, ativo = ?,");
        query.append(" dta_alt = ?, login_alt = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, produto.getNome());
            pstm.setLong(2, produto.getTipoProduto().getId());
            pstm.setLong(3, produto.getCategoria().getId());
            pstm.setDouble(4, produto.getValor());
            pstm.setString(5, produto.isAtivo() ? "S" : "N");
            pstm.setString(6, produto.getDtaAlt());
            pstm.setString(7, produto.getLoginAlt());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao alterar produto!");
            alert.setContentText(e.toString());
            alert.show();
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

    public void deletarProduto(ProdutoVO produto) {
        String query = "DELETE FROM PRODUTO WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, produto.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao deletar produto!");
            alert.setContentText(e.toString());
            alert.show();
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

    public List<Produto> recuperarProdutos() {
        String query = "SELECT * FROM PRODUTO";
        List<Produto> produtos = new ArrayList<Produto>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTipoProduto(rs.getInt("tipo_produto"));
                produto.setIdCategoria(rs.getInt("id_categoria"));
                produto.setValor(rs.getDouble("valor"));
                produto.setAtivo(rs.getString("ativo"));
                produto.setDtaInc(rs.getString("dta_inc"));
                produto.setLoginInc(rs.getString("login_inc"));
                produto.setDtaAlt(rs.getString("dta_alt"));
                produto.setLoginAlt(rs.getString("login_alt"));

                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao recuperar produtos!");
            alert.setContentText(e.toString());
            alert.show();
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
        return produtos;
    }

    public Produto recuperarProdutoPorId(long id) {
        String query = "SELECY * FROM PRODUTO WHERE id = ?";
        Produto produto = new Produto();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTipoProduto(rs.getInt("tipo_produto"));
                produto.setIdCategoria(rs.getInt("id_categoria"));
                produto.setValor(rs.getDouble("valor"));
                produto.setAtivo(rs.getString("ativo"));
                produto.setDtaInc(rs.getString("dta_inc"));
                produto.setLoginInc(rs.getString("login_inc"));
                produto.setDtaAlt(rs.getString("dta_alt"));
                produto.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao recuperar produto!");
            alert.setContentText(e.toString());
            alert.show();
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
        return produto;
    }
}
