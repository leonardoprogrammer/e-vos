package com.evos.enums;

/**
 * @author leonardo.silva
 */
public enum FormaPagamento {

    AVISTA_DINHEIRO(1, "Á vista - Dinheiro"),
    AVISTA_PIX(2, "À vista  - PIX"),
    AVISTA_TED(3, "À vista - TED"),
    AVISTA_CARTAO(4, "À vista - Cartão"),
    AVISTA_CHEQUE(5, "À vista - Cheque"),
    AVISTA_BOLETO(6, "À vista - Boleto bancário"),
    CREDITO_A_VISTA(7, "Cartão de crédito - À vista"),
    CREDITO_PARCELADO(8, "Cartão de Crédito - Parcelado");

    private final int id;
    private final String descricao;

    FormaPagamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FormaPagamento get(int id) {
        for (FormaPagamento t : FormaPagamento.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
