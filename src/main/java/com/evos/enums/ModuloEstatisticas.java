package com.evos.enums;

public enum ModuloEstatisticas {

    VENDAS(1, "Vendas"),
    ESTOQUE(2, "Estoque"),
    FINANCEIRO(3, "Financeiro");

    private final int id;
    private final String descricao;

    ModuloEstatisticas(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ModuloEstatisticas get(int id) {
        for (ModuloEstatisticas t : ModuloEstatisticas.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
