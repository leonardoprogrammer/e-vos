package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.vo.ConfiguracoesVO;

import java.util.Map;

public class CondiguracoesDAO {

    public ConfiguracoesVO recuperarConfiguracoes(long idEmpresa) {
        String sb = "SELECT * FROM CONFIGURACOESGERAIS";
        ConfiguracoesVO

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSel rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            pstm.execute();

            while (rs.next()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (pstm != null) {
                    pstm.close():
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
