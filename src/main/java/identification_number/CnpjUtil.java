package identification_number;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.InputMismatchException;

/**
 * Has the responsibility to perform operations on String objects that must contain CNPJ values.
 */
public class CnpjUtil {

    private CnpjUtil() {
    }

    /**
     * Checks if a CNPJ value is valid.
     *
     * @param cnpj {@link String} The String object to check.
     * @return {@link Boolean} The primitive boolean. True if the value of cnpj is correct, false otherwaise.
     * If it contains invalid characters, an InputMismatchException exception is thrown.
     */
    public static boolean validate(String cnpj) {
        // considera-se erro CNPJ's formados por uma sequência de números iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14))
            return (false);

        char dig13;
        char dig14;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1.º. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = cnpj.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else
                dig13 = (char) ((11 - r) + 48);

            // Calculo do 2.º. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = cnpj.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else
                dig14 = (char) ((11 - r) + 48);

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
        } catch (InputMismatchException error) {
            return (false);
        }
    }

    /**
     * Converts the CNPJ value to "99.999.999/9999-99" pattern.
     *
     * @param cnpj {@link String} The String object containing a CNPJ value.
     * @return {@link String}     The String object containing a converted CNPJ value.
     */
    public static String format(String cnpj) {
        try {
            var mask = new MaskFormatter("##.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            cnpj = mask.valueToString(cnpj);
        } catch (ParseException ignored) {
        }

        return cnpj;
    }


}
