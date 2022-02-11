package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Empresa;
import com.evos.model.vo.EmpresaVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpresaDAO {

    public Empresa recuperarEmpresa() {
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

                // Recupera os dados do banco e atribui ao objeto
                // TODO: preencher objeto Empresa
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
        return empresa;
    }

    public void alterarEmpresa(EmpresaVO empresa) {

    }
}
