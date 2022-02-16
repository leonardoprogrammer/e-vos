package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Login;
import com.evos.model.vo.LoginVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    public void cadastrarLogin(LoginVO user) {
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

    public void alterarLogin(LoginVO login) {
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

    public void deletarLogin(LoginVO login) {
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

    public List<Login> recuperarLogins() {
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

    public boolean verificarLogin(String username, String password) {
        String query = "SELECT * FROM LOGIN WHERE username = ? and senha = ?";
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

    public Login recuperarLoginPorLogin(LoginVO credenciais) {
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
