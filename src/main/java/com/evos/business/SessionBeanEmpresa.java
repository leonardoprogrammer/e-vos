package com.evos.business;

import com.evos.model.dao.EmpresaDAO;
import com.evos.model.entity.Empresa;
import com.evos.model.vo.EmpresaVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Exception.EvosException;

import java.util.Calendar;

/**
 * @author leonardo.silva
 */
public class SessionBeanEmpresa {

    private EmpresaDAO empresaDAO;

    public EmpresaVO recuperarEmpresa() throws EvosException {
        Empresa empresa = empresaDAO.recuperarEmpresa();

        if (empresa != null) {
            return preencherVO(empresa);
        }
        return null;
    }

    public void alterarEmpresa(EmpresaVO empresa, UsuarioVO userLogado) throws EvosException {
        empresa.setLoginAlt(userLogado.getNome());
        empresa.setDtaAlt(Calendar.getInstance().toString());
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
