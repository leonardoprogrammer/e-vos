package com.evos.business;

import com.evos.model.dao.EmpresaDAO;
import com.evos.model.entity.Empresa;
import com.evos.model.vo.EmpresaVO;

public class SessionBeanEmpresa {

    EmpresaDAO empresaDAO;

    public EmpresaVO recuperarEmpresa() {
        return preencherVO(empresaDAO.recuperarEmpresa());
    }

    public void alterarEmpresa(EmpresaVO empresa) {
        empresaDAO.alterarEmpresa(empresa);
    }

    public EmpresaVO preencherVO(Empresa empresa) {
        EmpresaVO empresaVO = new EmpresaVO();
        empresaVO.setId(empresa.getId());
        empresaVO.setNome(empresa.getNome());
        empresaVO.setCnpj(empresa.getCnpj());
        empresaVO.setPossuiCnpj(empresa.getPossuiCnpj().equals("S") ? true : false);
        empresaVO.setAtiva(empresa.getAtiva().equals("S") ? true : false);
        empresaVO.setDtaInc(empresa.getDtaInc());
        empresaVO.setLoginInc(empresa.getLoginInc());
        empresaVO.setDtaAlt(empresa.getDtaAlt());
        empresaVO.setLoginAlt(empresa.getLoginAlt());
        return empresaVO;
    }
}
