package com.evos.model.vo;

import java.util.List;

public class ConfiguracoesVO {
    private String conexaoBanco;

    // NovaVenda
    private boolean enviarEmailVenda;

    // Historico
    private boolean permitirFuncionarioDeletarVenda;
    private List<CargoVO> deletamVendas; // se anterior estiver ativa, essa tbm deve estar enabled

}
