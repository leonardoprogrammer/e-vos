package com.evos.enums;

public enum AtivoInativo {

    ATIVO(1, "Ativo", true),
    INATIVO(2, "Inativo", false);

    private final int id;
    private final String descricao;
    private final boolean status;

    AtivoInativo(int id, String descricao, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public static AtivoInativo get(int id) {
        for (AtivoInativo t : AtivoInativo.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
