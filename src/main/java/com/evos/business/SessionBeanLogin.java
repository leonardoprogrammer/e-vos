package com.evos.business;

import com.evos.model.dao.LoginDAO;
import com.evos.model.entity.Login;
import com.evos.model.vo.LoginVO;
import com.evos.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SessionBeanLogin {

    private LoginDAO loginDAO;
    private SessionBeanUsuario sessionBeanUsuario;

    public void cadastrarLogin(LoginVO login, UsuarioVO userLogado) {
        login.setLoginInc(userLogado.getNome());
        login.setDtaInc(Calendar.getInstance().toString());
        loginDAO.cadastrarLogin(login);
    }

    public void alterarLogin(LoginVO login, UsuarioVO userLogado) {
        login.setLoginAlt(userLogado.getNome());
        login.setDtaAlt(Calendar.getInstance().toString());
        loginDAO.alterarLogin(login);
    }

    public void deletarLogin(LoginVO login) {
        loginDAO.deletarLogin(login);
    }

    public List<LoginVO> recuperarTodosLogins() {
        List<Login> logins = loginDAO.recuperarLogins();
        List<LoginVO> loginsVO = new ArrayList<LoginVO>();

        if (logins != null) {
            for (Login login : logins) {
                UsuarioVO usuarioVO = sessionBeanUsuario.recuperarUsuarioPorId(login.getIdUsuario());
                loginsVO.add(preencherVO(login, usuarioVO));
            }
            return loginsVO;
        }
        return null;
    }

    public LoginVO recuperarLoginPorId(long id) {
        Login login = loginDAO.recuperarLoginPorId(id);

        if (login != null) {
            UsuarioVO usuarioVO = sessionBeanUsuario.recuperarUsuarioPorId(login.getIdUsuario());
            return preencherVO(login, usuarioVO);
        }
        return null;
    }

    public boolean verificarLogin(LoginVO login) {
        return loginDAO.verificarLogin(login.getUsername(), login.getSenha());
    }

    public LoginVO recuperarLoginPorLogin(LoginVO loginVO) {
        Login login = loginDAO.recuperarLoginPorLogin(loginVO);

        if (login != null) {
            UsuarioVO usuarioVO = sessionBeanUsuario.recuperarUsuarioPorId(login.getIdUsuario());
            return preencherVO(login, usuarioVO);
        }
        return null;
    }

    public LoginVO preencherVO(Login login, UsuarioVO usuarioVO) {
        LoginVO loginVO = new LoginVO();
        loginVO.setId(login.getId());
        if (usuarioVO != null) {
            loginVO.setUsuario(usuarioVO);
        }
        loginVO.setUsername(login.getUsername());
        loginVO.setSenha(login.getSenha());
        loginVO.setDtaInc(login.getDtaInc());
        loginVO.setLoginInc(login.getLoginInc());
        loginVO.setDtaAlt(login.getDtaAlt());
        loginVO.setLoginAlt(login.getLoginAlt());
        return loginVO;
    }
}
