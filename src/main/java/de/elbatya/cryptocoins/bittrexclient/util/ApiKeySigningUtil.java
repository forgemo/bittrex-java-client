package de.elbatya.cryptocoins.bittrexclient.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author contact@elbatya.de
 */
public class ApiKeySigningUtil {

    private static final String ALGORITHM = "HmacSHA512";
    private static final int NONCE_BYTE_LENGTH = 32;

    private static SecureRandom random = new SecureRandom();

    public static String createNonce(){
        byte[] bytes = new byte[NONCE_BYTE_LENGTH];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String createSign(String uri, String apiSecret){
        byte[] signBytes = calculateSignBytes(uri, apiSecret);
        return bytesToHexString(signBytes);
    }

    private static byte[] calculateSignBytes(String uri, String secret) {

        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), ALGORITHM);
            mac.init(secretKeySpec);
            return mac.doFinal(uri.getBytes());

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }

    }

    private static String bytesToHexString(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}
