package com.evos.model.vo;

public class PermissoesVO {
    // SOMENTE 'ADMIN' PODE ALTERAR PERMISSOES
    // o cadastro de permissões é feito automaticamente ao cadastrar cargos
    private long id;
    private long idUsuario;
    // VENDAS
    private boolean registraVenda;
    private boolean alteraVenda; // serve para alterar, cancelar e deletar
    // PRODUTOS E CATEGORIA
    private boolean cadastraProdutoCategoria;
    private boolean alteraProdutoCategoria; // serve para alterar, ativar/desativar e deletar
    // USUARIOS
    private boolean cadastraUsuario;
    private boolean alteraUsuario; // serve para alterar, ativar/desativar e deletar
    // CLIENTES
    private boolean cadastraCliente;
    private boolean alteraCliente; // serve para alterar, ativar/desativar e deletar
    // DESCONTOS
    private boolean cadastraDesconto;
    private boolean alteraDesconto; // serve para alterar, ativar/desativar e deletar
}
