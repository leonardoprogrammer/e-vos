package com.evos.business;

import com.evos.enums.TipoUsuario;
import com.evos.filtro.FiltrosUsuarios;
import com.evos.model.dao.CargoDAO;
import com.evos.model.dao.LoginDAO;
import com.evos.model.dao.UsuarioDAO;
import com.evos.model.entity.Cargo;
import com.evos.model.entity.Login;
import com.evos.model.entity.Usuario;
import com.evos.model.vo.CargoVO;
import com.evos.model.vo.LoginVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Exception.EvosException;
import com.evos.util.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class SessionBeanUsuario {

    private UsuarioDAO usuarioDAO;
    private SessionBeanCargo sessionBeanCargo;
    private SessionBeanLogin sessionBeanLogin;

    public void cadastrarUsuario(UsuarioVO userCadastro, LoginVO loginCadastro, UsuarioVO userLogado) throws EvosException {
        userCadastro.setLoginInc(userLogado.getNome());
        userCadastro.setDtaInc(Calendar.getInstance().toString());
        usuarioDAO.cadastrarUsuario(userCadastro);
        sessionBeanLogin.cadastrarLogin(loginCadastro, userLogado);
    }

    public void alterarUsuario(UsuarioVO userAlt, UsuarioVO userLogado) throws EvosException {
        userAlt.setLoginAlt(userLogado.getNome());
        userAlt.setDtaAlt(Calendar.getInstance().toString());
        usuarioDAO.alterarUsuario(userAlt);
    }

    public void deletarUsuario(UsuarioVO usuario) throws EvosException {
        usuarioDAO.deletarUsuario(usuario.getId());
    }

    public List<UsuarioVO> recuperarTodosUsuarios() throws EvosException {
        List<Usuario> usuarios = usuarioDAO.recuperarUsuarios();
        List<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();

        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                CargoVO cargoVO = sessionBeanCargo.recuperarCargoPorId(usuario.getIdCargo());
                usuariosVO.add(preencherVO(usuario, cargoVO));
            }
            return usuariosVO;
        }
        return null;
    }

    public List<UsuarioVO> recuperarUsuariosPorFiltros(FiltrosUsuarios filtros) {
        return null;
    }

    public UsuarioVO recuperarUsuarioPorId(long id) {
        Usuario usuario = usuarioDAO.recuperarUsuarioPorId(id);

        if (usuario != null) {
            CargoVO cargoVO = sessionBeanCargo.recuperarCargoPorId(usuario.getIdCargo());
            return preencherVO(usuario, cargoVO);
        }
        return null;
    }

    public UsuarioVO preencherVO(Usuario usuario, CargoVO cargoVO) {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setId(usuario.getId());
        usuarioVO.setNome(usuario.getNome());
        if (cargoVO != null) {
            usuarioVO.setCargo(cargoVO);
        }
        if (!Utils.isNullOrZero(usuario.getTipoUsuario())) {
            usuarioVO.setTipoUsuario(TipoUsuario.get(usuario.getTipoUsuario()));
        }
        usuarioVO.setDataAdmissao(usuario.getDataAdmissao());
        usuarioVO.setCpf(usuario.getCpf());
        usuarioVO.setDataNascimento(usuario.getDataNascimento());
        usuarioVO.setEmail(usuario.getEmail());
        usuarioVO.setAtivo(usuario.getAtivo().equals("S") ? true : false);
        usuarioVO.setDtaInc(usuario.getDtaInc());
        usuarioVO.setLoginInc(usuario.getLoginInc());
        usuarioVO.setDtaAlt(usuario.getDtaAlt());
        usuarioVO.setLoginAlt(usuario.getLoginAlt());
        return usuarioVO;
    }
}
