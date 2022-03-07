package com.evos.business;

import com.evos.model.dao.LoginDAO;
import com.evos.model.entity.Login;
import com.evos.model.vo.LoginVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Exception.EvosException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author leonardo.silva
 */
public class SessionBeanLogin {

    private LoginDAO loginDAO;
    private SessionBeanUsuario sessionBeanUsuario;

    public void cadastrarLogin(LoginVO login, UsuarioVO userLogado) throws EvosException {
        login.setLoginInc(userLogado.getNome());
        login.setDtaInc(Calendar.getInstance().toString());
        loginDAO.cadastrarLogin(login);
    }

    public void alterarLogin(LoginVO login, UsuarioVO userLogado) throws EvosException {
        login.setLoginAlt(userLogado.getNome());
        login.setDtaAlt(Calendar.getInstance().toString());
        loginDAO.alterarLogin(login);
    }

    public void deletarLogin(LoginVO login) throws EvosException {
        loginDAO.deletarLogin(login);
    }

    public List<LoginVO> recuperarTodosLogins() throws EvosException {
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

    public LoginVO recuperarLoginPorId(long id) throws EvosException {
        Login login = loginDAO.recuperarLoginPorId(id);

        if (login != null) {
            UsuarioVO usuarioVO = sessionBeanUsuario.recuperarUsuarioPorId(login.getIdUsuario());
            return preencherVO(login, usuarioVO);
        }
        return null;
    }

    public boolean verificarLogin(LoginVO login) throws EvosException {
        return loginDAO.verificarLogin(login.getUsername().trim(), login.getSenha().trim());
    }

    public LoginVO recuperarLoginPorCredenciais(LoginVO loginVO) throws EvosException {
        Login login = loginDAO.recuperarLoginPorCredenciais(loginVO);

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
