package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.ConfiguracoesGerais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConfiguracoesDAO {

    public ConfiguracoesGerais recuperarConfiguracoes() {
        String query = "SELECT * FROM CONFIGURACOESGERAIS";
        ConfiguracoesGerais configuracoes = new ConfiguracoesGerais();

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
                configuracoes = new ConfiguracoesGerais();

                // Recupera os dados do banco e atribui ao objeto
                configuracoes.setEnviarEmailVenda(rs.getString("enviar_email_venda"));
                configuracoes.setEnviarNotifVendaApp(rs.getString("enviar_notif_venda_app"));
                configuracoes.setEnviarNotifMetaApp(rs.getString("enviar_notif_meta_app"));
            }
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
        return configuracoes;
    }

}
