package identification_number;

import identification_number.enums.IdentificationNumber;

import static identification_number.enums.IdentificationNumber.CNPJ;
import static identification_number.enums.IdentificationNumber.CPF;

/**
 * Has the responsibility of performing operations on Brasilian Identification Numbers.
 */
public class IdentificationNumberUtil {

    private IdentificationNumberUtil() {
    }

    public static IdentificationNumber clasifyIdentificationNumber(String document) {
        return document.length() == 14
                ? CNPJ
                : CPF;

    }

}
