package de.elbatya.cryptocoins.bittrexclient.api.model.publicapi;

/**
 * @author contact@elbatya.de
 */
public class OrderBookEntry {

    private Double Quantity;
    private Double Rate;

    public Double getQuantity() {
        return Quantity;
    }

    public void setQuantity(Double quantity) {
        Quantity = quantity;
    }

    public Double getRate() {
        return Rate;
    }

    public void setRate(Double rate) {
        Rate = rate;
    }
}