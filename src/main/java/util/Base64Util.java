package util;

import exceptions.UnprocessableEntityException;

import java.util.Base64;

import static util.MessageContextHolder.msg;

public class Base64Util {

    private Base64Util() {
    }

    public static byte[] decode(String scr) throws UnprocessableEntityException {
        try {
            return Base64.getDecoder().decode(scr);
        } catch (Exception e) {
            throw new UnprocessableEntityException(msg("file.base64"));
        }
    }

    public static String encode(byte[] scr) throws UnprocessableEntityException {
        try {
            return Base64.getEncoder().encodeToString(scr);
        } catch (Exception e) {
            throw new UnprocessableEntityException(msg("file.base64"));
        }
    }

}
