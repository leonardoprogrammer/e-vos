package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Usuario;
import com.evos.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDAO {

    public void cadastrarUsuario(UsuarioVO usuario, UsuarioVO userLogado) {
        StringBuilder query = new StringBuilder("INSERT INTO USUARIO");
        query.append("(");
        query.append("nome, id_cargo, tipo_usuario, data_admissao, cpf, data_nasc, email, ativo, ");
        query.append("dta_inc, login_inc, dta_alt, login_alt");
        query.append(")");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setString(1, usuario.getNome());
            pstm.setLong(2, usuario.getCargo().getId());
            pstm.setInt(3, usuario.getTipoUsuario().getId());
            pstm.setDate(4, usuario.getDataAdmissao());
            pstm.setString(5, usuario.getCpf());
            pstm.setDate(6, usuario.getDataNascimento());
            pstm.setString(7, usuario.getEmail());
            pstm.setString(8, usuario.isAtivo() ? "S" : "N");
            pstm.setDate(9, new Date());
            pstm.setString(10, userLogado.getNome());
            pstm.setDate(11, new Date());
            pstm.setString(12, userLogado.getNome());

            // Executa a query para inserção dos dados
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha as conexões
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

    public void deletarUsuario(long id) {
        String query = "DELETE FROM USUARIO WHERE id = ?";

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

    public void alterarUsuario(UsuarioVO usuario, UsuarioVO userLogado) {
        StringBuilder query = new StringBuilder("UPDATE USUARIO SET");
        query.append(" nome = ?, id_cargo = ?, tipo_usuario = ?, data_admissao = ?,");
        query.append(" cpf = ?, data_nasc = ?, email = ?, ativo = ?,");
        query.append(" dta_inc = ?, login_inc = ?, dta_alt, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, usuario.getNome());
            pstm.setLong(2, usuario.getCargo().getId());
            pstm.setInt(3, usuario.getTipoUsuario().getId());
            pstm.setDate(4, usuario.getDataAdmissao());
            pstm.setString(5, usuario.getCpf());
            pstm.setDate(6, usuario.getDataNascimento());
            pstm.setString(7, usuario.getEmail());
            pstm.setString(8, usuario.isAtivo() ? "S" : "N");
            pstm.setDate(9, usuario.getDtaInc());
            pstm.setString(10, usuario.getLoginInc());
            pstm.setDate(11, new Date());
            pstm.setString(12, userLogado.getNome());
            pstm.setLong(13, usuario.getId());

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

    public Usuario recuperarUsuario(long id) {
        String query = "SELECT * FROM USUARIO WHERE = ?";
        Usuario usuario = new Usuario();

        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do banco
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdCargo(rs.getLong("id_cargo"));
                usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
                usuario.setDataAdmissao(rs.getDate("data_admissao"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getDate("data_nasc"));
                usuario.setEmail(rs.getString("email"));
                usuario.setAtivo(rs.getString("ativo"));
                usuario.setDtaInc(rs.getString("dta_inc"));
                usuario.setLoginInc(rs.getString("login_inc"));
                usuario.setDtaAlt(rs.getString("dta_alt"));
                usuario.setLoginAlt(rs.getString("login_alt"));
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
    }

    public List<Usuario> recuperarUsuarios() {
        String query = "SELECT * FROM USUARIO";
        List<Usuario> usuarios = new ArrayList<Usuario>();

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
                Usuario usuario = new Usuario();

                // Recupera os dados do banco e atribui ao objeto
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdCargo(rs.getLong("id_cargo"));
                usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
                usuario.setDataAdmissao(rs.getDate("data_admissao"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getDate("data_nasc"));
                usuario.setEmail(rs.getString("email"));
                usuario.setAtivo(rs.getString("ativo"));
                usuario.setDtaInc(rs.getString("dta_inc"));
                usuario.setLoginInc(rs.getString("login_inc"));
                usuario.setDtaAlt(rs.getString("dta_alt"));
                usuario.setLoginAlt(rs.getString("login_alt"));

                // Adiciona o objeto atual à lista
                usuarios.add(usuario);
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
        return usuarios;
    }
}
