package com.evos.enums;

public enum SimNao {

    SIM(1, "Sim", true),
    NAO(2, "Não", false);

    private final int id;
    private final String descricao;
    private final boolean status;

    SimNao(int id, String descricao, boolean status) {
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

    public static SimNao get(int id) {
        for (SimNao t : SimNao.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
