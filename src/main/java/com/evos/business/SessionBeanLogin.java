package com.evos.business;

import com.evos.model.dao.LoginDAO;
import com.evos.model.entity.Login;
import com.evos.model.vo.UsuarioVO;

import java.util.Date;

public class SessionBeanLogin {

    LoginDAO loginDAO;

    public void cadastrarLogin() {

    }
     public void alterarLogin(Login login, UsuarioVO userLogado) {
         login.setLoginAlt(userLogado.getNome());
         login.setDtaAlt(new Date().toString());
         loginDAO.alterarLogin(login);
     }
}
