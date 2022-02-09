package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Login;
import com.evos.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    public void cadastrarLogin(Login user) {
        StringBuilder query = new StringBuilder("INSERT INTO LOGIN");
        query.append("(idUsuario, username, senha, dta_inc, login_inc, dta_alt, login_alt)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setLong(1, user.getIdUsuario());
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getSenha());
            pstm.getString(4, user.getDtaInc());
            pstm.setString(5, user.getLoginInc());
            pstm.setString(6, user.getDtaAlt());
            pstm.setString(7, user.getLoginAlt());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Fecha as conexões
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

    public void alterarLogin(Login login) {
        StringBuilder query = new StringBuilder("UPDATE LOGIN SET");
        query.append(" id_usuario = ?, username = ?, senha = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setLong(1, login.getIdUsuario());
            pstm.setString(2, login.getUsername());
            pstm.setString(3, login.getSenha());
            pstm.setString(4, login.getDtaAlt());
            pstm.setString(5, login.getLoginAlt());
            pstm.setLong(6, login.getId());

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

    public void deletarLogin(Login login) {
        String query = "DELETE FROM LOGIN WHERE id = ?";

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

    public Login recuperarLoginPorId(long id) {
        String query = "SELECT * FROM LOGIN WHERE id = ?";
        Login login;

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                login = new Login();
                login.setId(rs.getLong("id"));
                login.setIdUsuario(rs.getLogin("id_usuario"));
                login.setUsername(rs.getString("username"));
                login.setSenha(rs.getString("senha"));
                login.setDtaInc(rs.getString("dta_inc"));
                login.setLoginInc(rs.getString("login_inc"));
                login.setDtaAlt(rs.getString("dta_alt"));
                login.setLoginAlt(rs.getString("login_alt"));
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
        return login;
    }

    public List<Login> recuperarTodosLogin() {
        String query = "SELECT * FROM LOGIN";
        List<Login> logins = new ArrayList<Login>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Login login = new Login();

                login.setId(rs.getLong("id"));
                login.setIdUsuario(rs.getLogin("id_usuario"));
                login.setUsername(rs.getString("username"));
                login.setSenha(rs.getString("senha"));
                login.setDtaInc(rs.getString("dta_inc"));
                login.setLoginInc(rs.getString("login_inc"));
                login.setDtaAlt(rs.getString("dta_alt"));
                login.setLoginAlt(rs.getString("login_alt"));

                logins.add(login);
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
        return logins;
    }
}
