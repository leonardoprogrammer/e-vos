package com.evos.business;

import com.evos.enums.TipoUsuario;
import com.evos.model.dao.CargoDAO;
import com.evos.model.dao.LoginDAO;
import com.evos.model.dao.UsuarioDAO;
import com.evos.model.entity.Cargo;
import com.evos.model.entity.Login;
import com.evos.model.entity.Usuario;
import com.evos.model.vo.CargoVO;
import com.evos.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionBeanUsuario {

    UsuarioDAO usuarioDAO;
    LoginDAO loginDAO;
    CargoDAO cargoDAO;
    SessionBeanCargo sessionBeanCargo;

    public void cadastrarUsuario(UsuarioVO userCadastro, Login loginCadastro, UsuarioVO userLogado) {
        usuarioDAO.cadastrarUsuario(userCadastro, userLogado);
        loginDAO.cadastrarLogin(loginCadastro);
    }

    public void alterarUsuario(UsuarioVO userAlt, UsuarioVO userLogado) {
        usuarioDAO.alterarUsuario(userAlt, userLogado);
    }

    public List<UsuarioVO> recuperarTodosUsuarios() {
        List<Usuario> usuarios = usuarioDAO.recuperarUsuarios();
        List<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();

        for (Usuario usuario : usuarios) {
            UsuarioVO usuarioVO = preencherVO(usuario, cargoDAO.recuperarCargoPorId(usuario.getIdCargo()));
            usuariosVO.add(usuarioVO);
        }

        return usuariosVO;
    }

    public UsuarioVO recuperarUsuarioPorId(long id) {
        Usuario usuario = usuarioDAO.recuperarUsuarioPorId(id);
        Cargo cargo = cargoDAO.recuperarCargoPorId(usuario.getIdCargo());

        UsuarioVO usuarioVO = preencherVO(usuario, cargo);

        return usuarioVO;
    }

    public UsuarioVO preencherVO(Usuario usuario, Cargo cargo) {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setId(usuario.getId());
        usuarioVO.setNome(usuario.getNome());
        if (cargo != null) {
            usuarioVO.setCargo(sessionBeanCargo.preencherVO(cargo));
        }
        usuarioVO.setTipoUsuario(TipoUsuario.get(usuario.getTipoUsuario()));
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
