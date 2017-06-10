package de.elbatya.cryptocoins.bittrexclient.api.model.common;

import java.util.Optional;

/**
 * @author contact@elbatya.de
 */
public class ApiResult<T> {
    private boolean success;
    private String message;
    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public Optional<T> getResultAsOptional() {
        return Optional.ofNullable(result);
    }

    public T unwrap() throws BittrexApiException {
        if (result == null) {
            String errorMessage = String.format("Message from Bittrex server: %s", this.message);
            throw new BittrexApiException(errorMessage);
        }
        return result;
    }

}
