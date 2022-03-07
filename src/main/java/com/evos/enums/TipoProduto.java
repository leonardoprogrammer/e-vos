package com.evos.enums;

/**
 * @author leonardo.silva
 */
public enum TipoProduto {

    FISICO(1, "Produto Físico"),
    DIGITAL(2, "Produto Digital");

    private final int id;
    private final String descricao;

    TipoProduto(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoProduto get(int id) {
        for (TipoProduto t : TipoProduto.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
