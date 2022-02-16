package com.evos.business;

import com.evos.model.dao.ConfiguracoesDAO;
import com.evos.model.entity.Configuracoes;
import com.evos.model.vo.ConfiguracoesVO;
import com.evos.model.vo.UsuarioVO;

import java.util.Calendar;

public class SessionBeanConfiguracoes {

    private ConfiguracoesDAO configuracoesDAO;

    public ConfiguracoesVO recuperarConfiguracoes() {
        Configuracoes configuracoes = configuracoesDAO.recuperarConfiguracoes();

        if (configuracoes != null) {
            return preencherVO(configuracoesDAO.recuperarConfiguracoes());
        }
        return null;
    }

    public void alterarConfiguracoes(ConfiguracoesVO configuracoes, UsuarioVO userLogado) {
        configuracoes.setLoginAlt(userLogado.getNome());
        configuracoes.setDtaAlt(Calendar.getInstance().toString());
        configuracoesDAO.alterarConfiguracoes(configuracoes);
    }

    public ConfiguracoesVO preencherVO(Configuracoes configuracoes) {
        ConfiguracoesVO configuracoesVO = new ConfiguracoesVO();
        configuracoesVO.setEnviarEmailVenda(configuracoes.getEnviarEmailVenda().equals("S") ? true : false);
        configuracoesVO.setEnviarNotifVendaApp(configuracoes.getEnviarNotifVendaApp().equals("S") ? true : false);
        configuracoesVO.setEnviarNotifMetaApp(configuracoes.getEnviarNotifMetaApp().equals("S") ? true : false);
        configuracoesVO.setDtaInc(configuracoes.getDtaInc());
        configuracoesVO.setLoginInc(configuracoes.getLoginInc());
        configuracoesVO.setDtaAlt(configuracoes.getDtaAlt());
        configuracoesVO.setLoginAlt(configuracoes.getLoginAlt());
        return configuracoesVO;
    }
}
