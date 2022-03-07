package com.evos.enums;

/**
 * @author leonardo.silva
 */
public enum Relatorios {

    VENDAS(1, "Relatóris de Vendas"),
    ESTOQUE(2, "Relatórios de Estoque"),
    FUNCIONARIOS(3, "Relatórios de Funcionários"),
    CLIENTES(4, "Relatórios de Clientes");

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
