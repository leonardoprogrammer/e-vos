package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Categoria;
import com.evos.model.vo.CategoriaVO;
import com.evos.util.Exception.EvosException;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void cadastrarCategoria(CategoriaVO categoria) throws EvosException {
        StringBuilder query = new StringBuilder("INSERT INTO CATEGORIA");
        query.append("(nome, ativo, dta_inc, login_inc)");
        query.append(" VALUES (?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiociona os valores como parâmetros
            pstm.setString(1, categoria.getNome());
            pstm.setString(2, "S");
            pstm.setString(3, categoria.getDtaInc());
            pstm.setString(4, categoria.getLoginInc());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao cadastrar categoria!");
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

    public void alterarCategoria(CategoriaVO categoria) throws EvosException {
        StringBuilder query = new StringBuilder("UPDATE CATEGORIA SET");
        query.append(" nome = ?, ativo = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, categoria.getNome());
            pstm.setString(2, categoria.isAtivo() ? "S" : "N");
            pstm.setString(3, categoria.getDtaAlt());
            pstm.setString(4, categoria.getLoginAlt());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao alterar categoria!", e.toString());
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

    public void deletarCategoria(long id) throws EvosException {
        String query = "DELETE FROM CATEGORIA WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao deletar categoria!", e.toString());
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

    public List<Categoria> recuperarCategorias() throws EvosException {
        String query = "SELECT * FROM CATEGORIA";
        List<Categoria> categorias = new ArrayList<Categoria>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();

                categoria = new Categoria();
                categoria.setId(rs.getLong("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setAtivo(rs.getString("ativo"));
                categoria.setDtaInc(rs.getString("dta_inc"));
                categoria.setLoginInc(rs.getString("login_inc"));
                categoria.setDtaAlt(rs.getString("dta_alt"));
                categoria.setLoginAlt(rs.getString("login_alt"));

                categorias.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar categorias!", e.toString());
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
        return categorias;
    }

    public Categoria recuperarCategoriaPorId(long id) throws EvosException {
        String query = "SELECT * FROM CATEGORIA WHERE id = ?";
        Categoria categoria = new Categoria();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getLong("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setAtivo(rs.getString("ativo"));
                categoria.setDtaInc(rs.getString("dta_inc"));
                categoria.setLoginInc(rs.getString("login_inc"));
                categoria.setDtaAlt(rs.getString("dta_alt"));
                categoria.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar categoria!", e.toString());
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
        return categoria;
    }
}
