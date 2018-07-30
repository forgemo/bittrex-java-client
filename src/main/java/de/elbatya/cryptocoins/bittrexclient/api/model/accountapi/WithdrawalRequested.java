package de.elbatya.cryptocoins.bittrexclient.api.model.accountapi;

/**
 * @author contact@elbatya.de
 */
public class WithdrawalRequested {
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "WithdrawalRequested{" +
                "uuid='" + uuid + '\'' +
                '}';
    }
}
