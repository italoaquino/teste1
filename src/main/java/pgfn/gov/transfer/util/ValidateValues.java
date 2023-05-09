package pgfn.gov.transfer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateValues {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean validarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static boolean ValidarCPF(String cpf) {

        cpf = cpf.replace(".","").replace("-", "");

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return(false);

        boolean ret = false;
        String base = "000000000";
        String digitos = "00";
        if (cpf.length() <= 11) {
            if (cpf.length() < 11) {
                cpf = base.substring(0, 11 - cpf.length()) + cpf;
                base = cpf.substring(0, 9);
            }
            base = cpf.substring(0, 9);
            digitos = cpf.substring(9, 11);
            int soma = 0, mult = 11;
            int[] var = new int[11];
            // Recebe os números e realiza a multiplicação e soma.
            for (int i = 0; i < 9; i++) {
                var[i] = Integer.parseInt("" + cpf.charAt(i));
                if (i < 9)
                    soma += (var[i] * --mult);
            }
            // Cria o primeiro dígito verificador.
            int resto = soma % 11;
            if (resto < 2) {
                var[9] = 0;
            } else {
                var[9] = 11 - resto;
            }
            // Reinicia os valores.
            soma = 0;
            mult = 11;
            // Realiza a multiplicação e soma do segundo dígito.
            for (int i = 0; i < 10; i++)
                soma += var[i] * mult--;
            // Cria o segundo dígito verificador.
            resto = soma % 11;
            if (resto < 2) {
                var[10] = 0;
            } else {
                var[10] = 11 - resto;
            }
            if ((digitos.substring(0, 1).equalsIgnoreCase(new Integer(var[9])
                    .toString()))
                    && (digitos.substring(1, 2).equalsIgnoreCase(new Integer(
                    var[10]).toString()))) {
                ret = true;
            }
        }

        return ret;
    }

}
