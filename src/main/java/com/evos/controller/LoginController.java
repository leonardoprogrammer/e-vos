package com.evos.controller;

import com.evos.business.SessionBeanLogin;
import com.evos.business.SessionBeanUsuario;
import com.evos.model.vo.LoginVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Exception.EvosException;
import com.evos.util.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private URL url;
    private ResourceBundle resourceBundle;

    private LoginVO login;
    private SessionBeanLogin sessionBeanLogin;
    private SessionBeanUsuario sessionBeanUsuario;

    // Componentes da Interface

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button esqueciMinhaSenha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.login = new LoginVO();
        this.url = url;
        this.resourceBundle = resourceBundle;
    }

    @FXML
    public void entrar() throws EvosException {
        if (camposValidos()) {
            login = new LoginVO(txtUsername.toString(), txtPassword.toString());
            boolean loginTrue = sessionBeanLogin.verificarLogin(login);
            if (loginTrue) {
                login = sessionBeanLogin.recuperarLoginPorCredenciais(login);
                UsuarioVO usuario = login.getUsuario();
                // TODO: Inicar painel principal do sistema
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setContentText("DADOS INCORRETOS!");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ATENÇÃO");
            alert.setContentText("Preencha todos os campos!");
        }
    }

    @FXML
    public void esqueciMinhaSenha() {
        // TODO: Iniciar formRecuperarAcesso
    }

    public boolean camposValidos() {
        if (!Utils.isNullOrEmpty(txtUsername.toString()) && Utils.isNullOrEmpty(txtPassword.toString())) {
            return true;
        }
        return false;
    }
}
