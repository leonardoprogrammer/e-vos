package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.Configuracoes;
import com.evos.model.vo.ConfiguracoesVO;
import com.evos.util.Exception.EvosException;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author leonardo.silva
 */
public class ConfiguracoesDAO {

    public void alterarConfiguracoes(ConfiguracoesVO configuracoes) throws EvosException {
        StringBuilder query = new StringBuilder("UPDATE CONFIGURACOESGERAIS SET");
        query.append(" enviar_email_venda = ?, enviar_notif_venda_app = ?, enviar_notif_meta_app = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setString(1, configuracoes.isEnviarEmailVenda() ? "S" : "N");
            pstm.setString(2, configuracoes.isEnviarNotifVendaApp() ? "S" : "N");
            pstm.setString(3, configuracoes.isEnviarNotifMetaApp() ? "S" : "N");

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao alterar configurações!", e.toString());
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

    public Configuracoes recuperarConfiguracoes() throws EvosException {
        String query = "SELECT * FROM CONFIGURACOESGERAIS";
        Configuracoes configuracoes = new Configuracoes();

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
                configuracoes = new Configuracoes();

                // Recupera os dados do banco e atribui ao objeto
                configuracoes.setEnviarEmailVenda(rs.getString("enviar_email_venda"));
                configuracoes.setEnviarNotifVendaApp(rs.getString("enviar_notif_venda_app"));
                configuracoes.setEnviarNotifMetaApp(rs.getString("enviar_notif_meta_app"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EvosException(EvosException.ExceptionLevel.ERROR, "Erro ao recuperar configurações!", e.toString());
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
