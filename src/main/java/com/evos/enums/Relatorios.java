package com.evos.enums;

public enum Relatorios {

    VENDAS(1, "Relatóris de Vendas"),
    ESTOQUE(2, "Relatórios de Estoque");

    private final int id;
    private final String descricao;

    Relatorios(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Relatorios get(int id) {
        for (Relatorios t : Relatorios.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
