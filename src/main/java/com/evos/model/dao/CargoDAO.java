package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Cargo;
import com.evos.model.vo.CargoVO;
import com.evos.model.vo.UsuarioVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CargoDAO {

    public void cadastrarCargo(CargoVO cargo) {
        StringBuilder query = new StringBuilder("INSERT INTO CARGO");
        query.append("(nome, ativo, dta_inc, login_inc)");
        query.append(" VALUES(?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setString(1, cargo.getNome());
            pstm.setString(3, "S");
            pstm.setString(4, cargo.getDtaInc());
            pstm.setString(5, cargo.getLoginInc());

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

    public void alterarCargo(CargoVO cargo) {
        StringBuilder query = new StringBuilder("UPDATE CARGO SET");
        query.append(" nome = ?, ativo = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, cargo.getNome());
            pstm.setString(3, cargo.isAtivo() ? "S" : "N");
            pstm.setString(6, cargo.getDtaAlt());
            pstm.setString(7, cargo.getLoginAlt());
            pstm.setLong(8, cargo.getId());

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

    public void deletarCargo(long id) {
        String query = "DELETE FROM CARGO WHERE id = ?";

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

    public void substituirCargoUsuario(CargoVO cargoRemover, CargoVO cargoSubstituto, UsuarioVO userLogado) {
        StringBuilder query = new StringBuilder("UPDATE USUARIO SET");
        query.append(" id_cargo = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setLong(1, cargoSubstituto.getId());
            pstm.setString(2, Calendar.getInstance().toString());
            pstm.setString(3, userLogado.getNome());
            pstm.setLong(4, cargoRemover.getId());

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

    public List<Cargo> recuperarCargos() {
        String query = "SELECT * FROM CARGO";
        List<Cargo> cargos = new ArrayList<Cargo>();

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
                Cargo cargo = new Cargo();

                // Recupera os dados do banco e atribui ao objeto
                cargo.setId(rs.getLong("id"));
                cargo.setNome(rs.getString("nome"));
                cargo.setAtivo(rs.getString("ativo"));
                cargo.setDtaInc(rs.getString("dta_inc"));
                cargo.setLoginInc(rs.getString("login_inc"));
                cargo.setDtaAlt(rs.getString("dta_alt"));
                cargo.setLoginAlt(rs.getString("login_alt"));

                // Adiciona o objeto atual à lista
                cargos.add(cargo);
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
        return cargos;
    }

    public Cargo recuperarCargoPorId(long id) {
        String query = "SELECT * FROM CARGO WHERE id = ?";
        Cargo cargo = new Cargo();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                cargo = new Cargo();
                cargo.setId(rs.getLong("id"));
                cargo.setNome(rs.getString("nome"));
                cargo.setAtivo(rs.getString("ativo"));
                cargo.setDtaInc(rs.getString("dta_inc"));
                cargo.setLoginInc(rs.getString("login_inc"));
                cargo.setDtaAlt(rs.getString("dta_alt"));
                cargo.setLoginAlt(rs.getString("login_alt"));
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
        return cargo;
    }
}
