package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.filtro.FiltrosClientes;
import com.evos.model.entity.Cliente;
import com.evos.model.vo.ClienteVO;
import com.evos.util.Exception.EvosException;
import com.evos.util.Utils;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class ClienteDAO {

    public void cadastrarCliente(ClienteVO cliente) throws EvosException {
        StringBuilder query = new StringBuilder("INSERT INTO CLIENTE");
        query.append("(nome, cpf_cnpj, data_nasc, email, endereco, telefone_um, telefone_dois,");
        query.append(" envia_email, dta_inc, login_inc)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(query.toString());

            // Adiciona os valores como parâmetros
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpfCnpj());
            pstm.setDate(3, (Date) cliente.getDataNascimento().getTime());
            pstm.setString(4, cliente.getEmail());
            pstm.setString(5, cliente.getEndereco());
            pstm.setString(6, cliente.getEndereco());
            pstm.setString(7, cliente.getTelefoneUm());
            pstm.setString(8, cliente.getTelefoneDois());
            pstm.setString(8, cliente.isEnviaEmail() ? "S" : "N");
            pstm.setString(9, cliente.getDtaInc());
            pstm.setString(10, cliente.getLoginInc());

            // Executa a query para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao cadastrar cliente!", e.toString());
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

    public void alterarCliente(ClienteVO cliente) throws EvosException {
        StringBuilder query = new StringBuilder("UPDATE CLIENTE SET");
        query.append(" nome = ?, cpf_cnpj = ?, data_nasc = ?, email = ?, endereco = ?,");
        query.append(" telefone_um = ?, telefone_dois = ?, envia_email = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpfCnpj());
            pstm.setDate(3, (Date) cliente.getDataNascimento().getTime());
            pstm.setString(4, cliente.getEmail());
            pstm.setString(5, cliente.getEndereco());
            pstm.setString(6, cliente.getEndereco());
            pstm.setString(7, cliente.getTelefoneUm());
            pstm.setString(8, cliente.getTelefoneDois());
            pstm.setString(8, cliente.isEnviaEmail() ? "S" : "N");
            pstm.setString(9, cliente.getDtaInc());
            pstm.setString(10, cliente.getLoginInc());
            pstm.setLong(11, cliente.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao alterar cliente!", e.toString());
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

    public void deletarCliente(long id) throws EvosException {
        String query = "DELETE FROM CLIENTE WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao deletar cliente!", e.toString());
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

    public List<Cliente> recuperarClientes() {
        String query = "SELECT * FROM CLIENTE";
        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do bamco
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            // Enquanto existir dados no banco, faça
            while (rs.next()) {
                Cliente cliente = new Cliente();

                // Recupera os dados do banco e atribui ao objeto
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("cpf_cnpj"));
                cliente.getDataNascimento().setTime(rs.getDate("data_nasc"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefoneUm(rs.getString("telefone_um"));
                cliente.setTelefoneDois(rs.getString("telefone_dois"));
                cliente.setEnviaEmail(rs.getString("envia_email"));
                cliente.setDtaInc(rs.getString("dta_inc"));
                cliente.setLoginInc(rs.getString("login_inc"));
                cliente.setDtaAlt(rs.getString("dta_alt"));
                cliente.setLoginAlt(rs.getString("login_alt"));

                // Adiciona o objeto atual à lista
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar clientes!", e.toString());
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
            return clientes;
        }
    }

    public List<Cliente> recuperarClientesPorFiltros(FiltrosClientes filtros) {
        StringBuilder query = new StringBuilder("SELECT * FROM CLIENTE");
        int count = 0;

        if (!Utils.isNullOrZero(filtros.getId())) {
            query.append(" WHERE id = ?");
        } else {
            query.append(" WHERE id IS NOT NULL");
        }

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            query.append(" AND nome = ?");
        }

        if (!Utils.isNullOrEmpty(filtros.getCpf())) {
            query.append(" AND cpf_cnpj = ?");
        }

        if (!Utils.isNullOrEmpty(filtros.getDataCadastro())) {
            query.append(" AND dta_inc = ?");
        }

        if (!Utils.isNullOrEmpty(filtros.getEnviaEmail())) {
            query.append(" AND envia_email = ?");
        }

        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do bamco
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            if (!Utils.isNullOrZero(filtros.getId())) {
                pstm.setLong(count++, filtros.getId());
            }

            if (!Utils.isNullOrEmpty(filtros.getNome())) {
                pstm.setString(count++, filtros.getNome());
            }

            if (!Utils.isNullOrEmpty(filtros.getCpf())) {
                pstm.setString(count++, filtros.getCpf());
            }

            if (!Utils.isNullOrEmpty(filtros.getDataCadastro())) {
                pstm.setString(count++, filtros.getDataCadastro());
            }

            if (!Utils.isNullOrEmpty(filtros.getEnviaEmail())) {
                pstm.setString(count++, filtros.getEnviaEmail());
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("cpf_cnpj"));
                cliente.getDataNascimento().setTime(rs.getDate("data_nasc"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefoneUm(rs.getString("telefone_um"));
                cliente.setTelefoneDois(rs.getString("telefone_dois"));
                cliente.setEnviaEmail(rs.getString("envia_email"));
                cliente.setDtaInc(rs.getString("dta_inc"));
                cliente.setLoginInc(rs.getString("login_inc"));
                cliente.setDtaAlt(rs.getString("dta_alt"));
                cliente.setLoginAlt(rs.getString("login_alt"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar clientes por filtros!", e.toString());
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
        return clientes;
    }

    public Cliente recuperarClientePorId(long id) {
        String query = "SELECT * FROM CLIENTE WHERE id = ?";
        Cliente cliente = new Cliente();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("cpf_cnpj"));
                cliente.getDataNascimento().setTime(rs.getDate("data_nasc"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefoneUm(rs.getString("telefone_um"));
                cliente.setTelefoneDois(rs.getString("telefone_dois"));
                cliente.setEnviaEmail(rs.getString("envia_email"));
                cliente.setDtaInc(rs.getString("dta_inc"));
                cliente.setLoginInc(rs.getString("login_inc"));
                cliente.setDtaAlt(rs.getString("dta_alt"));
                cliente.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar cliente!", e.toString());
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
        return cliente;
    }
}
