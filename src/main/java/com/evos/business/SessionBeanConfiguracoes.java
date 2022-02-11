package com.evos.business;

import com.evos.model.dao.ConfiguracoesDAO;
import com.evos.model.entity.ConfiguracoesGerais;
import com.evos.model.entity.Permissoes;
import com.evos.model.vo.ConfiguracoesVO;
import com.evos.model.vo.PermissoesVO;
import com.evos.model.vo.UsuarioVO;

public class SessionBeanConfiguracoes {

    ConfiguracoesDAO configuracoesDAO;

    public ConfiguracoesVO recuperarConfiguracoes() {
        return preencherVO(configuracoesDAO.recuperarConfiguracoes());
    }

    public void alterarConfiguracoes(ConfiguracoesVO configuracoes) {

    }

    public ConfiguracoesVO preencherVO(ConfiguracoesGerais configuracoes) {
        ConfiguracoesVO configuracoesVO = new ConfiguracoesVO();

        return configuracoesVO;
    }
}
