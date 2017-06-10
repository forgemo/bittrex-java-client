package de.elbatya.cryptocoins.bittrexclient.api.model.accountapi;

/**
 * @author contact@elbatya.de
 */
public class Balance {

    private String currency;
    private Double balance;
    private Double available;
    private Double pending;
    private String cryptoAddress;
    private Boolean requested;
    private String uuid;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public Double getPending() {
        return pending;
    }

    public void setPending(Double pending) {
        this.pending = pending;
    }

    public String getCryptoAddress() {
        return cryptoAddress;
    }

    public void setCryptoAddress(String cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
    }

    public Boolean getRequested() {
        return requested;
    }

    public void setRequested(Boolean requested) {
        this.requested = requested;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
