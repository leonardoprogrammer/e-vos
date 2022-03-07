package com.evos.enums;

/**
 * @author leonardo.silva
 */
public enum TipoUsuario {

    ADMIN(1, "Administrador"),
    FUNCIONARIO(2, "Funcionário");

    private final int id;
    private final String descricao;

    TipoUsuario(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoUsuario get(int id) {
        for (TipoUsuario t : TipoUsuario.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
