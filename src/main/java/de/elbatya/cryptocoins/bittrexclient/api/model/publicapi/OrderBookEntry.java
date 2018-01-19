package de.elbatya.cryptocoins.bittrexclient.api.model.publicapi;

import java.math.BigDecimal;

/**
 * @author contact@elbatya.de
 */
public class OrderBookEntry {

    private BigDecimal Quantity;
    private BigDecimal Rate;

    public BigDecimal getQuantity() {
        return Quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    public BigDecimal getRate() {
        return Rate;
    }

    public void setRate(BigDecimal rate) {
        Rate = rate;
    }
}