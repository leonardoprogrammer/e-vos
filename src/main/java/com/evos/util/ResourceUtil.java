package com.evos.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author leonardo.silva
 */
public class ResourceUtil {

    private static ResourceBundle bundle = ResourceBundle.getBundle("resources/message/messages_geral", new Locale("pt", "br"));

    public static String getMessage(String message) {
        return bundle.getString(message);
    }
}
