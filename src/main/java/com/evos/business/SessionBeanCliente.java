package com.evos.business;

import com.evos.model.dao.ClienteDAO;
import com.evos.model.entity.Cliente;
import com.evos.model.vo.ClienteVO;
import com.evos.model.vo.UsuarioVO;

import java.util.Calendar;
import java.util.List;

public class SessionBeanCliente {

    private ClienteDAO clienteDAO;

    public void cadastrarCliente(ClienteVO cliente, UsuarioVO userLogado) {
        cliente.setLoginInc(userLogado.getNome());
        cliente.setDtaInc(Calendar.getInstance().toString());
        clienteDAO.cadastrarCliente(cliente);
    }

    public void alterarCliente(ClienteVO cliente, UsuarioVO userLogado) {
        cliente.setLoginAlt(userLogado.getNome());
        cliente.setDtaAlt(Calendar.getInstance().toString());
        clienteDAO.alterarCliente(cliente);
    }

    public void deletarCliente(ClienteVO cliente) {
        clienteDAO.deletarCliente(cliente.getId());
    }

    public List<ClienteVO> recuperarTodosClientes() {

    }

    public ClienteVO recuperarClientePorId(long id) {

    }

    public ClienteVO preencherVO(Cliente cliente) {
        ClienteVO clienteVO = new ClienteVO();

        return clienteVO;
    }
}
