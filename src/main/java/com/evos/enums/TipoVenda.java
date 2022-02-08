package com.evos.enums;

public enum TipoVenda {

    FISICA(1, "Venda física"),
    ONLINE(2, "Venda online");

    private final int id;
    private final String descricao;

    TipoVenda(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoVenda get(int id) {
        for (TipoVenda t : TipoVenda.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
