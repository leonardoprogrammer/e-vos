package com.evos.business;

import com.evos.model.dao.PermissoesDAO;
import com.evos.model.entity.Permissoes;
import com.evos.model.vo.PermissoesVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Exception.EvosException;
import com.evos.util.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class SessionBeanPermissoes {

    private PermissoesDAO permissoesDAO;

    public void cadastrarPermissoes(PermissoesVO permissoesVO, UsuarioVO userLogado) throws EvosException {
        permissoesVO.setLoginInc(userLogado.getNome());
        permissoesVO.setDtaInc(Calendar.getInstance().toString());
        permissoesDAO.cadastrarPermissoes(permissoesVO);
    }

    public void alterarPermissoes(PermissoesVO permissoesVO, UsuarioVO userLogado) throws EvosException {
        permissoesVO.setLoginAlt(userLogado.getNome());
        permissoesVO.setDtaAlt(Calendar.getInstance().toString());
        permissoesDAO.alterarPermissoes(permissoesVO);
    }

    public void deletarPermissoes(PermissoesVO permissoesVO) throws EvosException {
        permissoesDAO.deletarPermissoes(permissoesVO.getId());
    }

    public List<PermissoesVO> recuperarTodasPermissoes() throws EvosException {
        List<Permissoes> permissoes = permissoesDAO.recuperarPermissoes();
        List<PermissoesVO> permissoesVO = new ArrayList<PermissoesVO>();

        if (permissoes != null) {
            for (Permissoes permissao : permissoes) {
                permissoesVO.add(preencherVO(permissao));
            }
            return permissoesVO;
        }
        return null;
    }

    public PermissoesVO recuperarPermissoesPorId(long id) {
        Permissoes permissoes = permissoesDAO.recuperarPermissoesPorId(id);

        if (permissoes != null) {
            return preencherVO(permissoes);
        }
        return null;
    }

    public PermissoesVO preencherVO(Permissoes permissoes) {
        PermissoesVO permissoesVO = new PermissoesVO();
        permissoesVO.setId(permissoesVO.getId());
        if (!Utils.isNullOrEmpty(permissoes.getRegistraVenda())) {
            permissoesVO.setRegistraVenda(permissoes.getRegistraVenda().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getAlteraCategoria())) {
            permissoesVO.setAlteraVenda(permissoes.getAlteraVenda().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getCadastraProduto())) {
            permissoesVO.setCadastraProduto(permissoes.getCadastraProduto().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getAlteraProduto())) {
            permissoesVO.setAlteraProduto(permissoes.getAlteraProduto().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getCadastraCategoria())) {
            permissoesVO.setCadastraCategoria(permissoes.getCadastraCategoria().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getAlteraCategoria())) {
            permissoesVO.setAlterarCategoria(permissoes.getAlteraCategoria().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getCadastraUsuario())) {
            permissoesVO.setCadastraUsuario(permissoes.getCadastraUsuario().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getAlteraUsuario())) {
            permissoesVO.setAlteraUsuario(permissoes.getAlteraUsuario().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getCadastraCliente())) {
            permissoesVO.setCadastraCliente(permissoes.getCadastraCliente().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getAlteraCliente())) {
            permissoesVO.setAlteraCliente(permissoes.getAlteraCliente().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getCadastraDesconto())) {
            permissoesVO.setCadastraDesconto(permissoes.getCadastraDesconto().equalsIgnoreCase("S") ? true : false);
        }
        if (!Utils.isNullOrEmpty(permissoes.getAlteraDesconto())) {
            permissoesVO.setAlteraDesconto(permissoes.getAlteraDesconto().equalsIgnoreCase("S") ? true : false);
        }
        permissoesVO.setDtaInc(permissoes.getDtaInc());
        permissoesVO.setLoginInc(permissoes.getLoginInc());
        permissoesVO.setDtaAlt(permissoes.getDtaAlt());
        permissoesVO.setLoginAlt(permissoes.getLoginAlt());
        return permissoesVO;
    }
}
