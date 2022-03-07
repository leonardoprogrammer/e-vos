package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Empresa;
import com.evos.model.vo.EmpresaVO;
import com.evos.util.Exception.EvosException;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author leonardo.silva
 */
public class EmpresaDAO {

    public Empresa recuperarEmpresa() throws EvosException {
        String query = "SELECT * FROM EMPRESA";
        Empresa empresa = new Empresa();

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
                empresa = new Empresa();
                empresa.setId(rs.getLong("id"));
                empresa.setNome(rs.getString("nome"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setPossuiCnpj(rs.getString("possui_cnpj"));
                empresa.setAtiva(rs.getString("ativa"));
                empresa.setDtaInc(rs.getString("dta_inc"));
                empresa.setLoginInc(rs.getString("login_inc"));
                empresa.setDtaAlt(rs.getString("dta_alt"));
                empresa.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar empresa!", e.toString());
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
        return empresa;
    }

    public void alterarEmpresa(EmpresaVO empresa) throws EvosException {
        StringBuilder query = new StringBuilder("UPDATE EMPRESA SET");
        query.append(" nome = ?, cnpj = ?, possui_cnpj = ?, ativa = ?,");
        query.append(" dta_inc = ?, login_inc = ?, dta_alt = ?, login_alt = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, empresa.getNome());
            pstm.setString(2, empresa.getCnpj());
            pstm.setString(3, empresa.isPossuiCnpj() ? "S" : "N");
            pstm.setString(4, empresa.isAtiva() ? "S" : "N");
            pstm.setString(5, empresa.getDtaInc());
            pstm.setString(6, empresa.getLoginInc());
            pstm.setString(7, empresa.getDtaAlt());
            pstm.setString(8, empresa.getLoginAlt());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao alterar empresa!", e.toString());
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
}
