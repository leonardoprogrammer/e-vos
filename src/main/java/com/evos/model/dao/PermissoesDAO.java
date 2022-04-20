package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Permissoes;
import com.evos.model.vo.PermissoesVO;
import com.evos.util.Exception.EvosException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class PermissoesDAO {

    public void cadastrarPermissoes(PermissoesVO permissoes) throws EvosException {
        StringBuilder query = new StringBuilder("INSER INTO PERMISSOES");
        query.append("(registra_venda, altera_venda, cadastra_produto, altera_produto,");
        query.append(" cadastra_categoria, altera_categoria, cadastra_usuario, altera_usuario,");
        query.append(" cadastra_cliente, altera_cliente, cadastra_desconto, altera_desconto");
        query.append(" dta_inc, login_inc)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setString(1, permissoes.isRegistraVenda() ? "S" : "N");
            pstm.setString(2, permissoes.isAlteraVenda() ? "S" : "N");
            pstm.setString(3, permissoes.isCadastraProduto() ? "S" : "N");
            pstm.setString(4, permissoes.isAlteraProduto() ? "S" : "N");
            pstm.setString(5, permissoes.isCadastraCategoria() ? "S" : "N");
            pstm.setString(6, permissoes.isAlterarCategoria() ? "S" : "N");
            pstm.setString(7, permissoes.isCadastraUsuario() ? "S" : "N");
            pstm.setString(8, permissoes.isAlteraUsuario() ? "S" : "N");
            pstm.setString(9, permissoes.isCadastraCliente() ? "S" : "N");
            pstm.setString(10, permissoes.isAlteraCliente() ? "S" : "N");
            pstm.setString(11, permissoes.isCadastraDesconto() ? "S" : "N");
            pstm.setString(12, permissoes.isAlteraDesconto() ? "S" : "N");
            pstm.setString(13, permissoes.getDtaInc());
            pstm.setString(14, permissoes.getLoginInc());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao cadastrar permissões!", e.toString());
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

    public void alterarPermissoes(PermissoesVO permissoes) throws EvosException {
        StringBuilder query = new StringBuilder("UPADTE PERMISSOES SET");
        query.append(" registra_venda = ?, altera_venda = ?, cadastra_produto = ?, altera_produto = ?,");
        query.append(" cadastra_categoria = ?, altera_categoria = ?, cadastra_usuario = ?, altera_usuario = ?,");
        query.append(" cadastra_cliente = ?, altera_cliente = ?, cadastra_desconto = ?, altera_desconto = ?,");
        query.append(" dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, permissoes.isRegistraVenda() ? "S" : "N");
            pstm.setString(2, permissoes.isAlteraVenda() ? "S" : "N");
            pstm.setString(3, permissoes.isCadastraProduto() ? "S" : "N");
            pstm.setString(4, permissoes.isAlteraProduto() ? "S" : "N");
            pstm.setString(5, permissoes.isCadastraCategoria() ? "S" : "N");
            pstm.setString(6, permissoes.isAlterarCategoria() ? "S" : "N");
            pstm.setString(7, permissoes.isCadastraUsuario() ? "S" : "N");
            pstm.setString(8, permissoes.isAlteraUsuario() ? "S" : "N");
            pstm.setString(9, permissoes.isCadastraCliente() ? "S" : "N");
            pstm.setString(10, permissoes.isAlteraCliente() ? "S" : "N");
            pstm.setString(11, permissoes.isCadastraDesconto() ? "S" : "N");
            pstm.setString(12, permissoes.isAlteraDesconto() ? "S" : "N");
            pstm.setString(13, permissoes.getDtaAlt());
            pstm.setString(14, permissoes.getLoginAlt());
            pstm.setLong(15, permissoes.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao alterar permissões!", e.toString());
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

    public void deletarPermissoes(long id) throws EvosException {
        String query = "DELETE FROM PERMISSOES WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao deletar permissões!", e.toString());
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

    public List<Permissoes> recuperarPermissoes() throws EvosException {
        String query = "SELECT * FROM PERMISSOES";
        List<Permissoes> permissoes = new ArrayList<Permissoes>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do banco
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            // Enquanto existir dados no banco, faça
            while (rs.next()) {
                Permissoes permissao = new Permissoes();

                // Recupera os dados do banco e atribui ao objeto
                permissao.setId(rs.getLong("id"));
                permissao.setRegistraVenda(rs.getString("registra_venda"));
                permissao.setAlteraVenda(rs.getString("altera_venda"));
                permissao.setCadastraProduto(rs.getString("cadastra_produto"));
                permissao.setAlteraProduto(rs.getString("altera_produto"));
                permissao.setCadastraCategoria(rs.getString("cadastra_categoria"));
                permissao.setAlteraCategoria(rs.getString("altera_categoria"));
                permissao.setCadastraUsuario(rs.getString("cadastra_usuario"));
                permissao.setAlteraUsuario(rs.getString("altera_usuario"));
                permissao.setCadastraCliente(rs.getString("cadastra_cliente"));
                permissao.setAlteraCliente(rs.getString("altera_cliente"));
                permissao.setCadastraDesconto(rs.getString("cadastra_desconto"));
                permissao.setAlteraDesconto(rs.getString("altera_desconto"));
                permissao.setDtaInc(rs.getString("dta_inc"));
                permissao.setLoginInc(rs.getString("login_inc"));
                permissao.setDtaAlt(rs.getString("dta_alt"));
                permissao.setLoginAlt(rs.getString("login_alt"));

                // Adiciona o objeto atual à lista
                permissoes.add(permissao);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro recuperar permissões!", e.toString());
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
        return permissoes;
    }

    public Permissoes recuperarPermissoesPorId(long id) {
        String query = "SELECT * FROM PERMISSOES WHERE id = ?";
        Permissoes permissoes = new Permissoes();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                permissoes = new Permissoes();
                permissoes.setId(rs.getLong("id"));
                permissoes.setRegistraVenda(rs.getString("registra_venda"));
                permissoes.setAlteraVenda(rs.getString("altera_venda"));
                permissoes.setCadastraProduto(rs.getString("cadastra_produto"));
                permissoes.setAlteraProduto(rs.getString("altera_produto"));
                permissoes.setCadastraCategoria(rs.getString("cadastra_categoria"));
                permissoes.setAlteraCategoria(rs.getString("altera_categoria"));
                permissoes.setCadastraUsuario(rs.getString("cadastra_usuario"));
                permissoes.setAlteraUsuario(rs.getString("altera_usuario"));
                permissoes.setCadastraCliente(rs.getString("cadastra_cliente"));
                permissoes.setAlteraCliente(rs.getString("altera_cliente"));
                permissoes.setCadastraDesconto(rs.getString("cadastra_desconto"));
                permissoes.setAlteraDesconto(rs.getString("altera_desconto"));
                permissoes.setDtaInc(rs.getString("dta_inc"));
                permissoes.setLoginInc(rs.getString("login_inc"));
                permissoes.setDtaAlt(rs.getString("dta_alt"));
                permissoes.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar permissões!", e.toString());
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
        return permissoes;
    }
}
