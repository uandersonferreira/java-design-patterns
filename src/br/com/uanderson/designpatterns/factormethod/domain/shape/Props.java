package br.com.uanderson.designpatterns.factormethod.domain.shape;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {

    private static Properties props;

    static {
        props = new Properties();//Intãncia um Properties.

        // Carrega as propriedades a partir do arquivo "config.properties"
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obtém o valor de uma propriedade como uma String
    public static String getString(String property) {
        return props.getProperty(property);
    }

    // Obtém o valor de uma propriedade como um inteiro, com um valor padrão especificado
    public static int getInt(String property, int defaultValue) {
        String value = getString(property);

        try {
            // Tenta converter a String em um número inteiro
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Se ocorrer uma exceção (por exemplo, se o valor não for um número válido), retorna o valor padrão
            return defaultValue;
        }
    }
}
