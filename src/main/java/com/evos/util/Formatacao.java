package com.evos.util;

import javax.swing.text.MaskFormatter;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatacao {

    private static DateFormat dateFormat;
    private static DateFormat dateFormatLenient;

    public static String getValorFormatado(String mascara, String valor) {
        for(int i = 0; i < valor.length(); ++i) {
            mascara = mascara.replaceFirst("[#]", valor.substring(i, i + 1));
        }

        return mascara.replaceAll("[#]", "");
    }

    public static String getDataHoraFormatada(Date valorData) {
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("pt", "BR"));
        }

        return dateFormat.format(valorData);
    }

    public static String getHoraFormatada(Date valorData) {
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("HH:mm", new Locale("pt", "BR"));
        }

        return dateFormat.format(valorData);
    }

    public static Date getHoraFormatada(String valorData) throws ParseException {
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("HH:mm", new Locale("pt", "BR"));
        }

        return dateFormat.parse(valorData);
    }

    public static String getDataFormatada(Date valorData) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        return df.format(valorData);
    }

    public static Date getDataFormatada(String valorData) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        return df.parse(valorData);
    }

    public static String getDataExtenso(Date valor) {
        return (new SimpleDateFormat(" EEEEE, dd 'de' MMMMM 'de' yyyy", new Locale("pt", "BR"))).format(valor);
    }

    public static String lpad(String valueToPad, String filler, int size) {
        while(valueToPad.length() < size) {
            valueToPad = filler + valueToPad;
        }

        return valueToPad;
    }

    public static String rpad(String valueToPad, String filler, int size) {
        while(valueToPad.length() < size) {
            valueToPad = valueToPad + filler;
        }

        return valueToPad;
    }

    public static String limparCnpj(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");
        return cnpj;
    }

    public static String limparCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        return cpf;
    }

    public static String limparCep(String cep) {
        if (cep == null) {
            return cep;
        } else {
            cep = cep.replaceAll("-", "");
            cep = cep.replaceAll("\\.", "");
            return cep;
        }
    }

    public static String formatarCep(String cep) {
        return formatar(cep, "#####-###");
    }

    public static String limparTelefone(String fone) {
        if (fone == null) {
            return fone;
        } else {
            fone = fone.replace("-", "");
            fone = fone.replace("(", "");
            fone = fone.replace(")", "");
            fone = fone.replace(" ", "");
            return fone.trim();
        }
    }

    public static String limparCadastro(String cadastro) {
        if (!Utils.isNullOrEmpty(cadastro)) {
            cadastro = cadastro.replaceAll("[^a-zA-Z0-9\\s]", "");
        }

        return cadastro;
    }

    public static String formatar(String valor, String mascara) {
        if (valor == null) {
            return null;
        } else {
            String dado = "";

            int indMascara;
            for(indMascara = 0; indMascara < valor.length(); ++indMascara) {
                char c = valor.charAt(indMascara);
                if (Character.isDigit(c)) {
                    dado = dado + c;
                }
            }

            indMascara = mascara.length();
            int indCampo = dado.length();

            while(indCampo > 0 && indMascara > 0) {
                --indMascara;
                if (mascara.charAt(indMascara) == '#') {
                    --indCampo;
                }
            }

            String saida;
            for(saida = ""; indMascara < mascara.length(); ++indMascara) {
                saida = saida + (mascara.charAt(indMascara) == '#' ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
            }

            return saida;
        }
    }

    public static String formatarCpf(String cpf) {
        while(cpf.length() < 11) {
            cpf = "0" + cpf;
        }

        return formatar(cpf, "###.###.###-##");
    }

    public static String formatarCnpj(String cnpj) {
        while(cnpj.length() < 14) {
            cnpj = "0" + cnpj;
        }

        return formatar(cnpj, "##.###.###/####-##");
    }

    public static String formatarCPFCNPJ(String valor) {
        if (!Utils.isNullOrEmpty(valor)) {
            String mask_pattern = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
            String mask_replace = "$1.$2.$3-$4";
            if (valor.length() > 11) {
                mask_pattern = "(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})";
                mask_replace = "$1.$2.$3/$4-$5";
            }

            Pattern pattern = Pattern.compile(mask_pattern);
            Matcher matcher = pattern.matcher(valor);
            if (matcher.matches()) {
                valor = matcher.replaceAll(mask_replace);
            }
        }

        return valor;
    }

    public static String remove_caracteres_cpf_cnpj(String valor) {
        return valor.replaceAll("\\D", "");
    }

    public static String remove_caracteres(String valor) {
        String toReturn = "";
        if (!Utils.isNullOrEmpty(valor)) {
            toReturn = valor.replaceAll("\\D", "");
        }

        return toReturn;
    }

    public static String remove_naoCaracteres(String valor) {
        String toReturn = "";
        if (!Utils.isNullOrEmpty(valor)) {
            toReturn = valor.replaceAll("[^a-zA-Z0-9\\s]", "");
        }

        return toReturn;
    }

    public static String formatarFoneFax(String valor) {
        try {
            if (valor != null && !"".equals(valor)) {
                valor = valor.trim();
                valor = valor.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "");
            }

            MaskFormatter f = new MaskFormatter("(##) ####-####");
            f.setValueContainsLiteralCharacters(false);
            return f.valueToString(valor.replaceAll(" ", ""));
        } catch (ParseException var2) {
            System.out.println(var2.toString());
            return null;
        }
    }

    public static String formatarNumero(Object valor, String mascara) {
        DecimalFormat df = new DecimalFormat(mascara);
        return df.format(valor);
    }

    public static String formataValor(Double numero, int minFractionDigits, int maxFractionDigits) throws ParseException {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(maxFractionDigits);
        nf.setMinimumFractionDigits(minFractionDigits);
        return nf.format(numero);
    }

    public static String preencherComZeros(String numeroStr, int tamanhoCampo) {
        if (numeroStr.length() > tamanhoCampo) {
            throw new IllegalArgumentException("O numero contem mais posicoes que o esperado (" + tamanhoCampo + "):" + numeroStr.length());
        } else if (numeroStr.length() == tamanhoCampo) {
            return numeroStr;
        } else {
            StringBuffer numeroAjustado = new StringBuffer(tamanhoCampo);
            int repeat = tamanhoCampo - numeroStr.length();

            for(int i = 0; i < repeat; ++i) {
                numeroAjustado.append("0");
            }

            numeroAjustado.append(numeroStr);
            if (numeroAjustado.length() > tamanhoCampo) {
                throw new IllegalStateException("Tamanho de campo diferente do esperado.");
            } else {
                return numeroAjustado.toString();
            }
        }
    }

    public static String mascararNome(String nome) {
        if (Utils.isNullOrEmpty(nome)) {
            return "";
        } else {
            String[] nomeMascarado = nome.split(" ");
            return nomeMascarado[0].toString();
        }
    }

    public static String mascararLogradouro(String logradouro) {
        if (Utils.isNullOrEmpty(logradouro)) {
            return "";
        } else {
            String[] logradouroMascarado = logradouro.split(" ");
            if (logradouroMascarado.length > 2) {
                return logradouroMascarado[0].toString().concat(" ").concat(logradouroMascarado[1].toString()).concat(" ...");
            } else if (logradouroMascarado.length == 2 && (!logradouroMascarado[0].toString().equalsIgnoreCase("RUA") || !logradouroMascarado[0].toString().equalsIgnoreCase("AVENIDA"))) {
                return logradouroMascarado[0].toString().concat(" ...");
            } else {
                return logradouroMascarado.length == 1 ? logradouroMascarado[0].toString() : logradouro;
            }
        }
    }

    public static String mascararCpfCnpj(String cpfCnpj) {
        if (Utils.isNullOrEmpty(cpfCnpj)) {
            return "";
        } else {
            String cpfCnpjMascarado = remove_caracteres(cpfCnpj);
            if (cpfCnpjMascarado.length() == 11) {
                return cpfCnpjMascarado.substring(0, 3).concat(".***.").concat(cpfCnpjMascarado.substring(6, 9)).concat("-**");
            } else if (cpfCnpjMascarado.length() == 14) {
                return cpfCnpjMascarado.substring(0, 2).concat(".***.").concat(cpfCnpjMascarado.substring(5, 8)).concat("/").concat(cpfCnpjMascarado.substring(8, 12)).concat("-**");
            } else {
                return cpfCnpjMascarado.length() > 4 ? mascararUltimosCaracteres(cpfCnpjMascarado, cpfCnpjMascarado.length() - 4) : cpfCnpjMascarado;
            }
        }
    }

    public static String mascararRg(String rg) {
        if (Utils.isNullOrEmpty(rg)) {
            return "";
        } else {
            String rgMascarado = remove_caracteres(rg);
            if (rgMascarado.length() == 9) {
                return rgMascarado.substring(0, 2).concat(".***.").concat(rgMascarado.substring(5, 8)).concat("-*");
            } else {
                return rgMascarado.length() > 4 ? mascararUltimosCaracteres(rgMascarado, rgMascarado.length() - 4) : rgMascarado;
            }
        }
    }

    public static String mascararTelefone(String telefone) {
        if (Utils.isNullOrEmpty(telefone)) {
            return "";
        } else {
            String telefoneMascarado = remove_caracteres(telefone);
            if (telefoneMascarado.length() != 10 && (telefoneMascarado.length() != 11 || !telefoneMascarado.substring(0).toString().equals("0"))) {
                if (telefoneMascarado.length() == 11 || telefoneMascarado.length() == 12 && telefoneMascarado.substring(0).toString().equals("0")) {
                    return "(".concat(telefoneMascarado.substring(0, 2)).concat(") ").concat("*****-").concat(telefoneMascarado.substring(7, 11));
                } else if (telefoneMascarado.length() == 8) {
                    return "****-".concat(telefoneMascarado.substring(4, 8));
                } else if (telefoneMascarado.length() == 9) {
                    return "*****-".concat(telefoneMascarado.substring(5, 9));
                } else {
                    return (telefoneMascarado.length() <= 4 || telefoneMascarado.length() >= 8) && telefoneMascarado.length() <= 11 ? telefoneMascarado : mascararPrimeirosCaracteres(telefoneMascarado, telefoneMascarado.length() - 4);
                }
            } else {
                return "(".concat(telefoneMascarado.substring(0, 2)).concat(") ").concat("****-").concat(telefoneMascarado.substring(6, 10));
            }
        }
    }

    public static String mascararEmail(String email) {
        if (Utils.isNullOrEmpty(email)) {
            return "";
        } else if (email.contains("@")) {
            String[] emailMask = email.split("@");
            if (emailMask[0].length() == 1) {
                return email;
            } else {
                return emailMask[0].length() == 2 ? emailMask[0].substring(0, 1).concat("...@").concat(emailMask[1].toString()) : emailMask[0].substring(0, 1).concat("...").concat(emailMask[0].substring(emailMask[0].length() - 1, emailMask[0].length())).concat("@").concat(emailMask[1].toString());
            }
        } else {
            return email.length() > 4 ? mascararPrimeirosCaracteres(email, email.length() - 4) : email;
        }
    }

    public static String mascararUltimosCaracteres(String caracteres, int quantidade) {
        if (Utils.isNullOrEmpty(caracteres)) {
            return "";
        } else if (caracteres.length() < quantidade) {
            throw new IllegalArgumentException("A frase contem mais posicoes que o esperado (" + quantidade + "):" + caracteres.length());
        } else if (quantidade <= 0) {
            return caracteres;
        } else {
            String asteristicos = "";

            for(int i = 0; i < quantidade; ++i) {
                asteristicos.concat("*");
            }

            return caracteres.substring(0, caracteres.length() - quantidade).concat(asteristicos);
        }
    }

    public static String mascararPrimeirosCaracteres(String caracteres, int quantidade) {
        if (Utils.isNullOrEmpty(caracteres)) {
            return "";
        } else if (caracteres.length() < quantidade) {
            throw new IllegalArgumentException("A frase contem mais posicoes que o esperado (" + quantidade + "):" + caracteres.length());
        } else if (quantidade <= 0) {
            return caracteres;
        } else {
            String asteristicos = "";

            for(int i = 0; i < quantidade; ++i) {
                asteristicos.concat("*");
            }

            return asteristicos.concat(caracteres.substring(quantidade - 1, caracteres.length()));
        }
    }

}
