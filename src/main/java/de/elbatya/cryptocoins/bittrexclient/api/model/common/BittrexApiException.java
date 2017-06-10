package de.elbatya.cryptocoins.bittrexclient.api.model.common;

/**
 * @author contact@elbatya.de
 */
public class BittrexApiException extends RuntimeException {

    public BittrexApiException() {
    }

    public BittrexApiException(String message) {
        super(message);
    }

    public BittrexApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BittrexApiException(Throwable cause) {
        super(cause);
    }

    public BittrexApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
