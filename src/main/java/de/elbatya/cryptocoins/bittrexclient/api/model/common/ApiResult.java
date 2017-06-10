package de.elbatya.cryptocoins.bittrexclient.api.model.common;

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

    public void setResult(T result) {
        this.result = result;
    }
}
