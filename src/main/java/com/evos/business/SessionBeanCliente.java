package com.evos.business;

import com.evos.model.dao.ClienteDAO;
import com.evos.model.entity.Cliente;
import com.evos.model.vo.ClienteVO;
import com.evos.model.vo.UsuarioVO;

import java.util.ArrayList;
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
        List<Cliente> clientes = clienteDAO.recuperarClientes();
        List<ClienteVO> clientesVO = new ArrayList<ClienteVO>();

        if (clientes != null) {
            for (Cliente cliente : clientes) {
                clientesVO.add(preencherVO(cliente));
            }
            return clientesVO;
        }
        return null;
    }

    public ClienteVO recuperarClientePorId(long id) {
        Cliente cliente = clienteDAO.recuperarClientePorId(id);

        if (cliente != null) {
            return preencherVO(cliente);
        }
        return null;
    }

    public ClienteVO preencherVO(Cliente cliente) {
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setId(cliente.getId());
        clienteVO.setNome(cliente.getNome());
        clienteVO.setCpfCnpj(cliente.getCpfCnpj());
        clienteVO.setDataNascimento(cliente.getDataNascimento());
        clienteVO.setEmail(cliente.getEmail());
        clienteVO.setEndereco(cliente.getEndereco());
        clienteVO.setTelefoneUm(cliente.getTelefoneUm());
        clienteVO.setTelefoneDois(cliente.getTelefoneDois());
        clienteVO.setEnviaEmail(cliente.getEnviaEmail().equals("S") ? true : false);
        clienteVO.setDtaInc(cliente.getDtaInc());
        clienteVO.setLoginInc(cliente.getLoginInc());
        clienteVO.setDtaAlt(cliente.getDtaAlt());
        clienteVO.setLoginAlt(cliente.getLoginAlt());
        return clienteVO;
    }
}
