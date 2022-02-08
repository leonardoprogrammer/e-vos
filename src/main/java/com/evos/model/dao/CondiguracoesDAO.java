package com.evos.model.dao;

import com.evos.model.vo.ConfiguracoesVO;

import java.util.Map;

public class CondiguracoesDAO {

    public ConfiguracoesVO recuperarConfiguracoes(long idEmpresa) {
        StringBuilder sb = new StringBuilder("select c from ConfiguracoesGerais c ");
        sb.append(" where c.id = :idEmpresa ");
    }

}
