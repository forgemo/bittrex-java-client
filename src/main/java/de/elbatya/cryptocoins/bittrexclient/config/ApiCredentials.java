package de.elbatya.cryptocoins.bittrexclient.config;

/**
 * @author contact@elbatya.de
 */
public class ApiCredentials {

    private String key;
    private String secret;

    public ApiCredentials() {
    }

    public ApiCredentials(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
