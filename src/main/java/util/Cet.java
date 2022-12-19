package util;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.lang.Math.pow;
import static java.math.RoundingMode.HALF_UP;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Calculador do CET.
 * <p>
 * O calculo abaixo esta de acordo com a formula da Resolucaoo CMN 3.517, de 2007
 * A formula e uma generalizacao e seu calculo por aproximacao deixa o programa
 * com entendimento mais simples
 * <p>
 * Ha uma margem de erro insignificante no calculo.
 */
public class Cet {

    private static final double CET_MAXVALUE = 10000.00;
    private static final double CET_PRECISION = 0.0000001;

    private Cet() {
    }

    /**
     * Calculo do custo efetivo total mensal.
     *
     * @param liquidValueFinanced {@link Double} Valor liquido financiado.
     * @param fixedParcelValue    {@link Double} Valor da parcela fixa
     * @param numberMonthlyParcel {@link Integer} Numero de parcelas mensais
     * @return {@link Double}
     */
    public static double monthly(double liquidValueFinanced, double fixedParcelValue, int numberMonthlyParcel) {
        var cet = 0D;
        double total;

        while (true) {
            total = 0D;

            for (var j = 0; j < numberMonthlyParcel; j++)
                total += fixedParcelValue / pow(1.0 + cet, j + 1.0);

            cet += CET_PRECISION;

            if (cet >= CET_MAXVALUE)
                return -1.0;
            if (total - liquidValueFinanced <= 0)
                break;
            else
                cet *= total / liquidValueFinanced;
        }

        return BigDecimal
                .valueOf(cet * 100.0)
                .setScale(3, HALF_UP)
                .doubleValue();
    }

    /**
     * Calculo do custo efetivo total anual.
     *
     * @param liquidValueFinanced         {@link Double} Valor liquido financiado.
     * @param fixedParcelValue            {@link Double} Valor da parcela fixa
     * @param numberMonthlyParcel         {@link Integer} Numero de parcelas mensais
     * @param contractDate                {@link LocalDate} Data do contrato (liberacao de recursos)
     * @param releaseDateFirstInstallment {@link LocalDate} Data da liberacao da primeira parcela
     * @return {@link Double}
     */
    public static double annual(double liquidValueFinanced,
                                double fixedParcelValue,
                                int numberMonthlyParcel,
                                LocalDate contractDate,
                                LocalDate releaseDateFirstInstallment) {

        var cet = 0D;
        double total;
        long days;

        while (true) {
            total = 0D;

            for (var j = 0; j < numberMonthlyParcel; j++) {
                days = j != 0
                        ? contractDate.until(releaseDateFirstInstallment.plusMonths(j), DAYS)
                        : contractDate.until(releaseDateFirstInstallment, DAYS);
                total += fixedParcelValue / pow(1.0 + cet, days / 365.0);
            }

            cet += CET_PRECISION;

            if (cet >= CET_MAXVALUE)
                return -1.0;
            if (total - liquidValueFinanced <= 0)
                break;
            else
                cet *= total / liquidValueFinanced;
        }

        return BigDecimal
                .valueOf(cet * 100.0)
                .setScale(3, HALF_UP)
                .doubleValue();
    }

}