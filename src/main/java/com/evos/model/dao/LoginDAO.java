package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Login;
import com.evos.model.vo.LoginVO;
import com.evos.util.Exception.EvosException;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class LoginDAO {

    public void cadastrarLogin(LoginVO user) throws EvosException {
        StringBuilder query = new StringBuilder("INSERT INTO LOGIN");
        query.append("(id_usuario, username, senha, dta_inc, login_inc)");
        query.append(" VALUES(?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setLong(1, user.getUsuario().getId());
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getSenha());
            pstm.setString(4, user.getDtaInc());
            pstm.setString(5, user.getLoginInc());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao cadastrar login!", e.toString());
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

    public void alterarLogin(LoginVO login) throws EvosException {
        StringBuilder query = new StringBuilder("UPDATE LOGIN SET");
        query.append(" id_usuario = ?, username = ?, senha = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setLong(1, login.getUsuario().getId());
            pstm.setString(2, login.getUsername());
            pstm.setString(3, login.getSenha());
            pstm.setString(4, login.getDtaAlt());
            pstm.setString(5, login.getLoginAlt());
            pstm.setLong(6, login.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao alterar login!", e.toString());
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

    public void deletarLogin(LoginVO login) throws EvosException {
        String query = "DELETE FROM LOGIN WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, login.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao deletar login!", e.toString());
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

    public Login recuperarLoginPorId(long id) throws EvosException {
        String query = "SELECT * FROM LOGIN WHERE id = ?";
        Login login = new Login();

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
                login.setIdUsuario(rs.getLong("id_usuario"));
                login.setUsername(rs.getString("username"));
                login.setSenha(rs.getString("senha"));
                login.setDtaInc(rs.getString("dta_inc"));
                login.setLoginInc(rs.getString("login_inc"));
                login.setDtaAlt(rs.getString("dta_alt"));
                login.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar login!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return login;
    }

    public List<Login> recuperarLogins() throws EvosException {
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
                login.setIdUsuario(rs.getLong("id_usuario"));
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
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar logins!", e.toString());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return logins;
    }

    public boolean verificarLogin(String username, String password) throws EvosException {
        String query = "SELECT * FROM LOGIN WHERE username = ? AND senha = ?";
        boolean loginExiste = false;

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setString(1, username);
            pstm.setString(2, password);

            rs = pstm.executeQuery();

            if (rs.next()) {
                loginExiste = true;
            } else {
                loginExiste = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao verificar login!", e.toString());
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
        return loginExiste;
    }

    public Login recuperarLoginPorCredenciais(LoginVO credenciais) throws EvosException {
        String query = "SELECT * FROM LOGIN WHERE username = ? AND senha = ?";
        Login login = new Login();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setString(1, credenciais.getUsername());
            pstm.setString(2, credenciais.getSenha());

            rs = pstm.executeQuery();

            while (rs.next()) {
                login = new Login();
                login.setId(rs.getLong("id"));
                login.setIdUsuario(rs.getLong("id_usuario"));
                login.setUsername(rs.getString("username"));
                login.setSenha(rs.getString("senha"));
                login.setDtaInc(rs.getString("dta_inc"));
                login.setLoginInc(rs.getString("login_inc"));
                login.setDtaAlt(rs.getString("dta_alt"));
                login.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar login!", e.toString());
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
        return login;
    }

    public Login recuperarLoginPorLoginn(LoginVO credenciais) throws EvosException {
        String query = "SELECT * FROM LOGIN WHERE username = ? and senha = ?";
        Login login = new Login();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setString(1, credenciais.getUsername());
            pstm.setString(2, credenciais.getSenha());

            rs = pstm.executeQuery();

            while (rs.next()) {
                login = new Login();
                login.setId((Long) rs.getObject(1));
                login.setIdUsuario((Long) rs.getObject(2));
                login.setUsername((String) rs.getObject(3));
                login.setSenha((String) rs.getObject(4));
                login.setDtaInc((String) rs.getObject(5));
                login.setLoginInc((String) rs.getObject(6));
                login.setDtaAlt((String) rs.getObject(7));
                login.setLoginAlt((String) rs.getObject(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar login!", e.toString());
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
        return login;
    }
}
