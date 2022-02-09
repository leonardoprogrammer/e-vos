package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Cargo;
import com.evos.model.vo.CargoVO;
import com.evos.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CargoDAO {

    public void cadastrarCargo(CargoVO cargo) {
        StringBuilder query = new StringBuilder("INSERT INTO CARGO");
        query.append("(nome, data_cadastro, ativo, dta_inc, login_inc, dta_alt, login_alt)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setString(1, cargo.getNome());
            pstm.setDate(2, cargo.getDataCadastro());
            pstm.setString(3, cargo.isAtivo() ? "S" : "N");
            pstm.setString(4, cargo.getDtaInc());
            pstm.setString(5, cargo.getLoginInc());
            pstm.setString(6, cargo.getDtaAlt());
            pstm.setString(7, cargo.getLoginAlt());

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
        query.append(" nome = ?, data_cadastro = ?, ativo = ?,");
        query.append(" dta_inc = ?, login_inc = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, cargo.getNome());
            pstm.setString(2, cargo.getDataCadastro());
            pstm.setString(3, cargo.isAtivo() ? "S" : "N");
            pstm.setString(4, cargo.getDtaInc());
            pstm.setString(5, cargo.getLoginInc());
            pstm.setString(6, cargo.getDtaAlt());
            pstm.setString(7, cargo.getLoginAlt());
            pstm.setString(8, cargo.getId());

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
            pstm.setString(2, new Date().toString());
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
    }

    public Cargo recuperarCargoPorId(long id) {

    }
}
