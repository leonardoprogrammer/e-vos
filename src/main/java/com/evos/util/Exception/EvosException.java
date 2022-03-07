package com.evos.util.Exception;

import javafx.scene.control.Alert;

/**
 * @author leonardo.silva
 */
public class EvosException extends Exception {

    /**
     * Instância de um Alert somente com mensagem
     * @param level
     * @param mensagem
     */
    public EvosException(ExceptionLevel level, String mensagem) {
        Alert alert = new Alert(getLevel(level));
        alert.setContentText(mensagem);
        alert.show();
    }

    /**
     * Instância de um Alert com título e mensagem
     * @param level
     * @param titulo
     * @param mensagem
     */
    public EvosException(ExceptionLevel level, String titulo, String mensagem) {
        Alert alert = new Alert(getLevel(level));
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }

    /**
     * Instância de um Alert com título, cabeçalho e mensagem
     * @param level
     * @param titulo
     * @param cabecalho
     * @param mensagem
     */
    public EvosException(ExceptionLevel level, String titulo, String cabecalho, String mensagem) {
        Alert alert = new Alert(getLevel(level));
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(mensagem);
        alert.show();
    }

    public static enum ExceptionLevel {
        NONE,
        INFO,
        WARNING,
        ERROR;

        private ExceptionLevel() {
        }
    }

    private Alert.AlertType getLevel(ExceptionLevel level) {
        switch (level) {
            case NONE:
                return Alert.AlertType.NONE;
            case INFO:
                return Alert.AlertType.INFORMATION;
            case WARNING:
                return Alert.AlertType.WARNING;
            case ERROR:
                return Alert.AlertType.ERROR;
            default:
                return Alert.AlertType.NONE;
        }
    }
}
