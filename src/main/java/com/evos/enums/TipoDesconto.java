package com.evos.enums;

public enum TipoDesconto {

    PORCENTAGEM(1, "Porcentagem (%)"),
    VALOR(2, "Valor (R$)");

    private final int id;
    private final String descricao;

    TipoDesconto(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoDesconto get(int id) {
        for (TipoDesconto t : TipoDesconto.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
